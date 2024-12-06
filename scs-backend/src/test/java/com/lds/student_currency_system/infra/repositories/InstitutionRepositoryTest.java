// package com.lds.student_currency_system.infra.repositories;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import com.lds.student_currency_system.domain.model.Institution;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

// @DataJpaTest
// class InstitutionRepositoryTest {

//     @Autowired
//     private InstitutionRepository institutionRepository;

//     @Test
//     void testSaveAndFindInstitution() {
//         Institution institution = new Institution("Test University");
//         institutionRepository.save(institution);

//         Institution foundInstitution = institutionRepository.findById(institution.getId()).orElse(null);

//         assertNotNull(foundInstitution);
//         assertEquals("Test University", foundInstitution.getName());
//     }
// }