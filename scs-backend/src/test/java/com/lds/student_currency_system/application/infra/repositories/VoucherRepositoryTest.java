package com.lds.student_currency_system.application.infra.repositories;

import com.lds.student_currency_system.application.domain.model.Advantage;
import com.lds.student_currency_system.application.domain.model.Company;
import com.lds.student_currency_system.application.domain.model.Institution;
import com.lds.student_currency_system.application.domain.model.Student;
import com.lds.student_currency_system.application.domain.model.Voucher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class VoucherRepositoryTest {

    @Autowired
    private VoucherRepository voucherRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    AdvantageRepository advantageRepository;
    @Autowired
    InstitutionRepository institutionRepository;
    @Autowired
    StudentRepository studentRepository;

    @Test
    void testSaveAndFindVoucher() {
        Company company = new Company("Company Name", "company@example.com", "companypass", "12345678901234", "Company Address");
        companyRepository.save(company);

        Advantage advantage = new Advantage("Discount", "image.jpg", 25.0f, company, "10% off", new Date());
        advantageRepository.save(advantage);

        Institution institution = new Institution("Test University");
        institutionRepository.save(institution);

        Student student = new Student("Student Name", "student@example.com", "studentpass", "98765432101", "Address", institution, "Computer Science", 50.0f);
        studentRepository.save(student);

        Voucher voucher = new Voucher("ABCD123", advantage, new Date(), "Discount", student);
        voucherRepository.save(voucher);

        Voucher foundVoucher = voucherRepository.findById(voucher.getId()).orElse(null);

        assertNotNull(foundVoucher);
        assertEquals("ABCD123", foundVoucher.getCode());
    }
}