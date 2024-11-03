package com.lds.student_currency_system.application.api;

import com.lds.student_currency_system.domain.model.Institution;
import com.lds.student_currency_system.domain.service.InstitutionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class InstitutionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private InstitutionService institutionService;

    @InjectMocks
    private InstitutionController institutionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(institutionController).build();
    }

    @Test
    @DisplayName("Create Institution - Success")
    void testCreateInstitution() throws Exception {
        Institution institution = new Institution("Test Institution");
        institution.setId(1L);

        when(institutionService.save(any(Institution.class))).thenReturn(institution);

        mockMvc.perform(post("/api/institutions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Test Institution\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test Institution"));
    }

    @Test
    @DisplayName("Get Institution by ID - Success")
    void testGetInstitutionById() throws Exception {
        Institution institution = new Institution("Test Institution");
        institution.setId(1L);

        when(institutionService.findById(1L)).thenReturn(Optional.of(institution));

        mockMvc.perform(get("/api/institutions/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test Institution"));
    }

    @Test
    @DisplayName("Get Institution by ID - Not Found")
    void testGetInstitutionByIdNotFound() throws Exception {
        when(institutionService.findById(anyLong())).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/institutions/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Get All Institutions - Success")
    void testGetAllInstitutions() throws Exception {
        Institution institution1 = new Institution("Test Institution 1");
        institution1.setId(1L);
        Institution institution2 = new Institution("Test Institution 2");
        institution2.setId(2L);

        List<Institution> institutions = Arrays.asList(institution1, institution2);

        when(institutionService.findAll()).thenReturn(institutions);


        mockMvc.perform(get("/api/institutions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[1].id").value(2L));
    }

    @Test
    @DisplayName("Update Institution - Success")
    void testUpdateInstitution() throws Exception {
        Institution institution = new Institution("Updated Institution");
        institution.setId(1L);

        when(institutionService.update(any(Institution.class))).thenReturn(institution);

        mockMvc.perform(put("/api/institutions/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Updated Institution\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Updated Institution"));
    }

    @Test
    @DisplayName("Delete Institution - Success")
    void testDeleteInstitution() throws Exception {
        doNothing().when(institutionService).deleteById(anyLong());

        mockMvc.perform(delete("/api/institutions/1"))
                .andExpect(status().isNoContent());
    }
}