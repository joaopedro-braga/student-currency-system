package com.lds.student_currency_system.application.api;

import com.lds.student_currency_system.domain.enums.UserRole;
import com.lds.student_currency_system.domain.model.User;
import com.lds.student_currency_system.domain.service.UserService;
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

class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    @DisplayName("Create User - Success")
    void testCreateUser() throws Exception {
        User user = new User("Test User", "test@example.com", "password", UserRole.STUDENT);
        user.setId(1L);

        when(userService.save(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Test User\", \"email\": \"test@example.com\", \"password\": \"password\", \"role\": \"STUDENT\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test User"));
    }

    @Test
    @DisplayName("Get User by ID - Success")
    void testGetUserById() throws Exception {
        User user = new User("Test User", "test@example.com", "password", UserRole.PROFESSOR);
        user.setId(1L);

        when(userService.findById(1L)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test User"));
    }

    @Test
    @DisplayName("Get User by ID - Not Found")
    void testGetUserByIdNotFound() throws Exception {
        when(userService.findById(anyLong())).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Get All Users - Success")
    void testGetAllUsers() throws Exception {
        User user1 = new User("Test User 1", "test1@example.com", "password", UserRole.STUDENT);
        user1.setId(1L);
        User user2 = new User("Test User 2", "test2@example.com", "password", UserRole.COMPANY);
        user2.setId(2L);


        List<User> users = Arrays.asList(user1, user2);
        when(userService.findAll()).thenReturn(users);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[1].id").value(2L));
    }



    @Test
    @DisplayName("Update User - Success")
    void testUpdateUser() throws Exception {
        User user = new User("Updated User", "updated@example.com", "new_password", UserRole.ADMIN);
        user.setId(1L);


        when(userService.update(any(User.class))).thenReturn(user);

        mockMvc.perform(put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Updated User\", \"email\": \"updated@example.com\", \"password\": \"new_password\", \"role\": \"ADMIN\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Updated User"));
    }


    @Test
    @DisplayName("Delete User - Success")
    void testDeleteUser() throws Exception {
        doNothing().when(userService).deleteById(anyLong());

        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent());
    }
}