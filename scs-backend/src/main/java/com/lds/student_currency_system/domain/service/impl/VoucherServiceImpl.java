package com.lds.student_currency_system.domain.service.impl;

import com.lds.student_currency_system.infra.repositories.AdvantageRepository;
import com.lds.student_currency_system.infra.repositories.StudentRepository;
import com.lds.student_currency_system.infra.repositories.TransferRepository;
import com.lds.student_currency_system.infra.repositories.VoucherRepository;

import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;

import com.lds.student_currency_system.application.mapper.VoucherMapper;
import com.lds.student_currency_system.domain.enums.VoucherStatus;
import com.lds.student_currency_system.domain.model.Advantage;
import com.lds.student_currency_system.domain.model.Student;
import com.lds.student_currency_system.domain.model.Transfer;
import com.lds.student_currency_system.domain.model.Voucher;
import com.lds.student_currency_system.domain.service.VoucherService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;
    private final AdvantageRepository advantageRepository;
    private final StudentRepository studentRepository;
    private final TransferRepository transferRepository;
    private final EmailService emailService;


    @Override
    @Transactional
    public Voucher createVoucher(Long idAdvantage, Student student) {

        Advantage advantage = advantageRepository.findById(idAdvantage)
                .orElseThrow(() -> new RuntimeException("Advantage not found!"));

        if (student.getBalance() < advantage.getPrice())
            throw new RuntimeException("Insufficient balance!");

        student.setBalance(student.getBalance() - advantage.getPrice());
        studentRepository.save(student);
        createTransfer(student, advantage);

        Voucher voucher = buildVoucher(student, advantage);


        try {
            emailService.sendVoucherNotification("joao.psbraga6@gmail.com", VoucherMapper.toVoucherResponse(voucher));
            emailService.sendPartnerVoucherAcquisitionNotification("joao.psbraga6@gmail.com", student.getName(), VoucherMapper.toVoucherResponse(voucher));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return voucherRepository.save(voucher);
    }

    private Voucher buildVoucher(Student student, Advantage advantage) {
        String code = UUID.randomUUID().toString().substring(0, 8);
        Date validity = Date.valueOf(LocalDate.now().plusMonths(3));
        String qrcode = "https://sqdbpldndwyesovwwijy.supabase.co/storage/v1/object/public/qrcode/qrcode.png";

        System.out.println("\n\n\n\nQrcode: " + qrcode);

        return new Voucher(
            code,
            qrcode,
            advantage,
            validity,
            VoucherStatus.UNUSED,
            student
        );
    }

    private void createTransfer(Student student, Advantage advantage) {
        String description = "Voucher purchase: " + advantage.getName();
        Transfer transfer = new Transfer(student, advantage.getCompany(), advantage.getPrice(), description);
        transferRepository.save(transfer);    
    }

    @Override
    public Optional<Voucher> findById(Long id) {
        return voucherRepository.findById(id);
    }

    @Override
    public List<Voucher> findAll(Student student) {
        return voucherRepository.findAllByStudentId(student.getId());
    }

    @Override
    public List<Voucher> findAllActive(Student student) {
        return voucherRepository.findAllByStudentIdAndStatusAndValidityAfter(
            student.getId(), 
            VoucherStatus.UNUSED,
            Date.valueOf(LocalDate.now()));
    }

    @Override
    public List<Voucher> findAllRedeemed(Student student) {
        return voucherRepository.findByStudentIdAndStatusOrValidityBefore(
            student.getId(),
            VoucherStatus.USED,
            Date.valueOf(LocalDate.now()));
    }

    @Override
    public void deleteById(Long id) {
        voucherRepository.deleteById(id);
    }

    @Override
    public Voucher markAsUsed(Long idVoucher) {
        Voucher voucher = voucherRepository.findById(idVoucher)
                .orElseThrow(() -> new RuntimeException("Voucher not found!"));

        voucher.setStatus(VoucherStatus.USED);
        return voucherRepository.save(voucher);
    }

}