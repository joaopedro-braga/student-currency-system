// package com.lds.student_currency_system.domain.model;

// import org.junit.jupiter.api.Test;

// import java.util.Date;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// class VoucherTest {

//     @Test
//     void testVoucherCreation() {
//         Company company = new Company("Company Name", "company@example.com", "companypass", "12345678901234", "Company Address");
//         Date date = new Date();
//         Advantage advantage = new Advantage("Discount", "image.jpg", 25.0f, company, "10% off", date);
//         Institution institution = new Institution("University");
//         Student student = new Student("Student Name", "student@example.com", "studentpass", "98765432101", "Address", institution, "Computer Science", 50.0f);
//         Voucher voucher = new Voucher("ABCD123", advantage, new Date(), "Discount", student);
//         assertEquals("ABCD123", voucher.getCode());
//         assertEquals(advantage, voucher.getAdvantage());
//         assertEquals("Discount", voucher.getType());
//         assertEquals(student, voucher.getStudent());
//     }
// }