// package com.lds.student_currency_system.infra.repositories;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import com.lds.student_currency_system.domain.model.Institution;
// import com.lds.student_currency_system.domain.model.Professor;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

// @DataJpaTest
// class ProfessorRepositoryTest {

//     @Autowired
//     private ProfessorRepository professorRepository;
//     @Autowired
//     private InstitutionRepository institutionRepository;

//     @Test
//     void testSaveAndFindProfessor() {
//         Institution institution = new Institution("Test University");
//         institutionRepository.save(institution);

//         Professor professor = new Professor("Professor Name", "professor@example.com", "profpass", "12345678901", "Department", institution, 100.0f);
//         professorRepository.save(professor);

//         Professor foundProfessor = professorRepository.findById(professor.getId()).orElse(null);

//         assertNotNull(foundProfessor);
//         assertEquals("Professor Name", foundProfessor.getName());
//     }
// }