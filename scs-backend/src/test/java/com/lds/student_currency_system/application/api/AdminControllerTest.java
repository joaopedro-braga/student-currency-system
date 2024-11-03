package com.lds.student_currency_system.application.api;

import com.lds.student_currency_system.domain.model.Admin;
import com.lds.student_currency_system.domain.service.AdminService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AdminControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AdminService adminService;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    @DisplayName("POST /api/admins - Create Admin")
    void testCreateAdmin() throws Exception {
        Admin admin = new Admin("Test Admin", "admin@example.com", "password");
        admin.setId(1L);

        when(adminService.save(any(Admin.class))).thenReturn(admin);

        mockMvc.perform(post("/api/admins")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Test Admin\", \"email\": \"admin@example.com\", \"password\": \"password\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test Admin"));
    }

    @Test
    @DisplayName("GET /api/admins/{id} - Get Admin by ID - Success")
    void testGetAdminById() throws Exception {
        Admin admin = new Admin("Test Admin", "admin@example.com", "password");
        admin.setId(1L);
        when(adminService.findById(1L)).thenReturn(Optional.of(admin));

        mockMvc.perform(get("/api/admins/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test Admin"));
    }

    @Test
    @DisplayName("GET /api/admins/{id} - Get Admin by ID - Not Found")
    void testGetAdminByIdNotFound() throws Exception {
        when(adminService.findById(anyLong())).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/admins/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("GET /api/admins - Get All Admins")
    void testGetAllAdmins() throws Exception {
        Admin admin1 = new Admin("Test Admin 1", "admin1@example.com", "password");
        admin1.setId(1L);

        Admin admin2 = new Admin("Test Admin 2", "admin2@example.com", "password");
        admin2.setId(2L);

        List<Admin> admins = Arrays.asList(admin1, admin2);
        when(adminService.findAll()).thenReturn(admins);

        mockMvc.perform(get("/api/admins"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[1].id").value(2L));
    }



    @Test
    @DisplayName("PUT /api/admins/{id} - Update Admin")
    void testUpdateAdmin() throws Exception {
        Admin admin = new Admin("Updated Admin", "updated@example.com", "new_password");
        admin.setId(1L);


        when(adminService.update(any(Admin.class))).thenReturn(admin);

        mockMvc.perform(put("/api/admins/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Updated Admin\", \"email\": \"updated@example.com\", \"password\": \"new_password\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Updated Admin"));
    }
}