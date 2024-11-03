package com.lds.student_currency_system.application.api;

import com.lds.student_currency_system.domain.model.Institution;
import com.lds.student_currency_system.domain.model.Professor;
import com.lds.student_currency_system.domain.model.Student;
import com.lds.student_currency_system.domain.model.Transfer;
import com.lds.student_currency_system.domain.service.ProfessorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ProfessorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProfessorService professorService;

    @InjectMocks
    private ProfessorController professorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(professorController).build();
    }

    @Test
    @DisplayName("Create Professor - Success")
    void testCreateProfessor() throws Exception {
        Institution institution = new Institution("Test Institution");
        institution.setId(1L);
        Professor professor = new Professor("Test Professor", "professor@example.com", "password", "12345678901", "Test Department", institution, 100f);
        professor.setId(1L);

        when(professorService.save(any(Professor.class))).thenReturn(professor);

        mockMvc.perform(post("/api/professors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Test Professor\", \"email\": \"professor@example.com\", \"password\": \"password\", \"cpf\": \"12345678901\", \"department\": \"Test Department\", \"institution\": {\"id\": 1}, \"balance\": 100.0}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    @DisplayName("Make Transfer - Success")
    void testMakeTransfer() throws Exception {
        long professorId = 1L;
        long studentId = 2L;

        Transfer transfer = new Transfer(new Date(), null, 50f, "CREDIT", "Test Transfer");
        transfer.setTransactor(new Professor()); 


        Student student = new Student();
        student.setId(studentId);

        Transfer completedTransfer = new Transfer(new Date(), null, 50f, "CREDIT", "Test Transfer");
        completedTransfer.setId(1L); 



        when(professorService.makeTransfer(eq(professorId), any(Transfer.class), any(Student.class))).thenReturn(completedTransfer);



        mockMvc.perform(post("/api/professors/{professorId}/transfers?studentId={studentId}", professorId, studentId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"date\": \"2023-10-27T12:00:00.000+00:00\", \"coinQuantity\": 50.0, \"type\": \"CREDIT\", \"description\": \"Test Transfer\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

    }



    @Test
    @DisplayName("Make Transfer - Bad Request")
    void testMakeTransferBadRequest() throws Exception {
        long professorId = 1L;
        long studentId = 2L;

        when(professorService.makeTransfer(eq(professorId), any(Transfer.class), any(Student.class))).thenThrow(new RuntimeException("Transfer failed")); // Simulate an exception

        mockMvc.perform(post("/api/professors/{professorId}/transfers?studentId={studentId}", professorId, studentId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"date\": \"2023-10-27T12:00:00.000+00:00\", \"coinQuantity\": 50.0, \"type\": \"CREDIT\", \"description\": \"Test Transfer\"}"))
                .andExpect(status().isBadRequest());
    }
}