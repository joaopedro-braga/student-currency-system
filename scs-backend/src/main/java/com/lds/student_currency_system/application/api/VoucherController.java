package com.lds.student_currency_system.application.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lds.student_currency_system.application.dto.VoucherResponse;
import com.lds.student_currency_system.application.mapper.VoucherMapper;
import com.lds.student_currency_system.domain.model.Student;
import com.lds.student_currency_system.domain.model.Voucher;
import com.lds.student_currency_system.domain.service.VoucherService;

import java.util.List;

@RestController
@RequestMapping("/api/vouchers")
@RequiredArgsConstructor
public class VoucherController {

    private final VoucherService voucherService;

    @PostMapping("/{idAdvantage}/create")
    public ResponseEntity<VoucherResponse> createVoucher(@PathVariable Long idAdvantage, 
    @AuthenticationPrincipal Student student) {
        Voucher voucher = voucherService.createVoucher(idAdvantage, student);
        return ResponseEntity.status(HttpStatus.CREATED).body(VoucherMapper.toVoucherResponse(voucher));
    }

    @GetMapping("/validate/{id}")
    public ResponseEntity<VoucherResponse> getVoucherById(@PathVariable Long id) {
        Voucher voucher = voucherService.findById(id)
                .orElseThrow(() -> new RuntimeException("Voucher not found!"));

        VoucherResponse response = VoucherMapper.toVoucherResponse(voucher);

        voucherService.markAsUsed(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<VoucherResponse>> getAllVouchers(@AuthenticationPrincipal Student student) {
        List<Voucher> vouchers = voucherService.findAll(student);
        return ResponseEntity.ok(VoucherMapper.toVoucherResponseList(vouchers));
    }

    @GetMapping("/active")
    public ResponseEntity<List<VoucherResponse>> getAllActiveVouchers(@AuthenticationPrincipal Student student) {
        List<Voucher> vouchers = voucherService.findAllActive(student);
        return ResponseEntity.ok(VoucherMapper.toVoucherResponseList(vouchers));
    }

    @GetMapping("/redeemed")
    public ResponseEntity<List<VoucherResponse>> getAllRedeemedVouchers(@AuthenticationPrincipal Student student) {
        List<Voucher> vouchers = voucherService.findAllRedeemed(student);
        return ResponseEntity.ok(VoucherMapper.toVoucherResponseList(vouchers));
    }

    @PutMapping("/use/{id}")
    public ResponseEntity<VoucherResponse> updateVoucher(@PathVariable Long id) {
        voucherService.markAsUsed(id);
        return ResponseEntity.ok(VoucherMapper.toVoucherResponse(voucherService.findById(id).get()));
    }

}