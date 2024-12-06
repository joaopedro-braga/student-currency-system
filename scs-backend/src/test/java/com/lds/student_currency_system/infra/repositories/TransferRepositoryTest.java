// package com.lds.student_currency_system.infra.repositories;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import com.lds.student_currency_system.domain.model.Institution;
// import com.lds.student_currency_system.domain.model.Professor;
// import com.lds.student_currency_system.domain.model.Transfer;
// import java.util.Date;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

// @DataJpaTest
// class TransferRepositoryTest {

//     @Autowired
//     private TransferRepository transferRepository;
//     @Autowired
//     private ProfessorRepository professorRepository;
//     @Autowired
//     private InstitutionRepository institutionRepository;

//     @Test
//     void testSaveAndFindTransfer() {
//         Institution institution = new Institution("Institution name");
//         institutionRepository.save(institution);

//         Professor professor = new Professor("Professor Name", "professor@example.com", "profpass", "12345678901", "Department", institution, 100.0f);
//         professorRepository.save(professor);

//         Transfer transfer = new Transfer(new Date(), professor, 50.0f, "Donation", "Test transfer");
//         transferRepository.save(transfer);

//         Transfer foundTransfer = transferRepository.findById(transfer.getId()).orElse(null);

//         assertNotNull(foundTransfer);
//         assertEquals(50.0f, foundTransfer.getCoinQuantity());
//     }
// }