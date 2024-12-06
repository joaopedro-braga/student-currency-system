// package com.lds.student_currency_system.domain.service;

// import com.lds.student_currency_system.infra.repositories.ProfessorRepository;
// import com.lds.student_currency_system.infra.repositories.StudentRepository;
// import com.lds.student_currency_system.infra.repositories.TransferRepository;
// import com.lds.student_currency_system.domain.model.Professor;
// import com.lds.student_currency_system.domain.model.Student;
// import com.lds.student_currency_system.domain.model.Transfer;
// import com.lds.student_currency_system.domain.service.impl.ProfessorServiceImpl;

// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.doNothing;
// import static org.mockito.Mockito.never;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// @ExtendWith(MockitoExtension.class)
// class ProfessorServiceTest {

//     @Mock
//     private ProfessorRepository professorRepository;

//     @Mock
//     private StudentRepository studentRepository;

//     @Mock
//     private TransferRepository transferRepository;

//     @InjectMocks
//     private ProfessorServiceImpl professorService;

//     @Test
//     @DisplayName("Must save a new professor")
//     void save() {
//         Professor professor = new Professor();
//         professor.setId(1L);
//         professor.setName("Professor Test");

//         when(professorRepository.save(any(Professor.class))).thenReturn(professor);

//         Professor savedProfessor = professorService.save(professor);

//         assertNotNull(savedProfessor);
//         assertEquals(professor.getId(), savedProfessor.getId());
//         assertEquals(professor.getName(), savedProfessor.getName());

//         verify(professorRepository, times(1)).save(professor);
//     }

//     @Test
//     @DisplayName("Must find a professor by id")
//     void findById() {
//         Long id = 1L;
//         Professor professor = new Professor();
//         professor.setId(id);
//         professor.setName("Professor Test");

//         when(professorRepository.findById(id)).thenReturn(Optional.of(professor));

//         Optional<Professor> foundProfessor = professorService.findById(id);

//         assertTrue(foundProfessor.isPresent());
//         assertEquals(professor.getId(), foundProfessor.get().getId());
//         assertEquals(professor.getName(), foundProfessor.get().getName());

//         verify(professorRepository, times(1)).findById(id);
//     }

//     @Test
//     @DisplayName("Must find all professors")
//     void findAll() {
//         List<Professor> professorList = new ArrayList<>();

//         Professor professor1 = new Professor();
//         professor1.setId(1L);
//         professor1.setName("Professor 1");

//         Professor professor2 = new Professor();
//         professor2.setId(2L);
//         professor2.setName("Professor 2");

//         professorList.add(professor1);
//         professorList.add(professor2);

//         when(professorRepository.findAll()).thenReturn(professorList);

//         List<Professor> foundProfessors = professorService.findAll();

//         assertNotNull(foundProfessors);
//         assertEquals(2, foundProfessors.size());

//         verify(professorRepository, times(1)).findAll();
//     }

//     @Test
//     @DisplayName("Must delete a professor by id")
//     void deleteById() {
//         Long id = 1L;

//         doNothing().when(professorRepository).deleteById(id);

//         professorService.deleteById(id);

//         verify(professorRepository, times(1)).deleteById(id);
//     }

//     @Test
//     @DisplayName("Must update a professor")
//     void update() {
//         Long id = 1L;
//         Professor professor = new Professor();
//         professor.setId(id);
//         professor.setName("Professor Updated");

//         when(professorRepository.existsById(id)).thenReturn(true);
//         when(professorRepository.save(any(Professor.class))).thenReturn(professor);

//         Professor updatedProfessor = professorService.update(professor);

//         assertNotNull(updatedProfessor);
//         assertEquals(professor.getId(), updatedProfessor.getId());
//         assertEquals(professor.getName(), updatedProfessor.getName());

//         verify(professorRepository, times(1)).existsById(id);
//         verify(professorRepository, times(1)).save(professor);
//     }

//     @Test
//     @DisplayName("Must throw exception when trying to update a professor that does not exist")
//     void updateNotFound() {
//         Long id = 1L;
//         Professor professor = new Professor();
//         professor.setId(id);

//         when(professorRepository.existsById(id)).thenReturn(false);

//         assertThrows(RuntimeException.class, () -> professorService.update(professor));

//         verify(professorRepository, times(1)).existsById(id);
//         verify(professorRepository, never()).save(professor);
//     }

//     @Test
//     @DisplayName("Should make a transfer successfully")
//     void makeTransfer() throws Exception {
//         Long professorId = 1L;
//         Professor professor = new Professor();
//         professor.setId(professorId);
//         professor.setName("Professor");
//         professor.setBalance(100);

//         Student student = new Student();
//         student.setId(1L);
//         student.setName("Student");

//         Transfer transfer = new Transfer();
//         transfer.setCoinQuantity(50);

//         when(professorRepository.findById(professorId)).thenReturn(Optional.of(professor));
//         when(studentRepository.save(any(Student.class))).thenReturn(student);
//         when(transferRepository.save(any(Transfer.class))).thenReturn(transfer);
//         when(professorRepository.save(any(Professor.class))).thenReturn(professor);

//         Transfer savedTransfer = professorService.makeTransfer(professorId, transfer, student);

//         assertNotNull(savedTransfer);
//         assertEquals(professor, savedTransfer.getTransactor());
//         assertEquals(50, professor.getBalance());

//         verify(professorRepository, times(1)).findById(professorId);
//         verify(studentRepository, times(1)).save(student);
//         verify(transferRepository, times(1)).save(any(Transfer.class));
//         verify(professorRepository, times(1)).save(professor);
//     }

//     @Test
//     @DisplayName("Should throw exception when professor not found")
//     void makeTransferProfessorNotFound() throws Exception {
//         Long professorId = 1L;
//         Transfer transfer = new Transfer();
//         Student student = new Student();

//         when(professorRepository.findById(professorId)).thenReturn(Optional.empty());

//         assertThrows(Exception.class, () -> professorService.makeTransfer(professorId, transfer, student));

//         verify(professorRepository, times(1)).findById(professorId);
//         verify(studentRepository, never()).save(any(Student.class));
//         verify(transferRepository, never()).save(any(Transfer.class));
//         verify(professorRepository, never()).save(any(Professor.class));
//     }

//     @Test
//     @DisplayName("Should throw exception when professor does not have enough balance")
//     void makeTransferInsufficientBalance() {
//         Long professorId = 1L;
//         Professor professor = new Professor();
//         professor.setId(professorId);
//         professor.setName("Professor");
//         professor.setBalance(10);

//         Student student = new Student();
//         student.setId(1L);
//         student.setName("Student");

//         Transfer transfer = new Transfer();
//         transfer.setCoinQuantity(50);

//         when(professorRepository.findById(professorId)).thenReturn(Optional.of(professor));

//         assertThrows(Exception.class, () -> professorService.makeTransfer(professorId, transfer, student));

//         verify(professorRepository, times(1)).findById(professorId);
//         verify(studentRepository, never()).save(any(Student.class));
//         verify(transferRepository, never()).save(any(Transfer.class));
//         verify(professorRepository, never()).save(any(Professor.class));
//     }
// }