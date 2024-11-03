package com.lds.student_currency_system.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lds.student_currency_system.infra.repositories.UserRepository;
import com.lds.student_currency_system.domain.enums.UserRole;
import com.lds.student_currency_system.domain.model.User;
import com.lds.student_currency_system.domain.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("Should save a user")
    void save() {
        User user = new User("Test User", "test@email.com", "password", UserRole.STUDENT) {};
        user.setId(1L);

        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.save(user);

        assertNotNull(savedUser);
        assertEquals(user.getId(), savedUser.getId());
        assertEquals(user.getName(), savedUser.getName());
        assertEquals(user.getEmail(), savedUser.getEmail());
        assertEquals(user.getPassword(), savedUser.getPassword());

        verify(userRepository, times(1)).save(user);
    }

    @Test
    @DisplayName("Should find a user by id")
    void findById() {
        Long id = 1L;
        User user = new User("Test User", "test@email.com", "password", UserRole.STUDENT) {};
        user.setId(id);

        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.findById(id);

        assertTrue(foundUser.isPresent());
        assertEquals(user.getId(), foundUser.get().getId());
        assertEquals(user.getName(), foundUser.get().getName());
        assertEquals(user.getEmail(), foundUser.get().getEmail());
        assertEquals(user.getPassword(), foundUser.get().getPassword());

        verify(userRepository, times(1)).findById(id);
    }

    @Test
    @DisplayName("Should find a user by email")
    void findByEmail() {
        String email = "test@email.com";
        User user = new User("Test User", email, "password", UserRole.STUDENT) {};
        user.setId(1L);

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.findByEmail(email);

        assertTrue(foundUser.isPresent());
        assertEquals(user.getId(), foundUser.get().getId());
        assertEquals(user.getName(), foundUser.get().getName());
        assertEquals(user.getEmail(), foundUser.get().getEmail());
        assertEquals(user.getPassword(), foundUser.get().getPassword());

        verify(userRepository, times(1)).findByEmail(email);
    }

    @Test
    @DisplayName("Should find all users")
    void findAll() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Test User 1", "test1@email.com", "password", UserRole.STUDENT) {});
        userList.add(new User("Test User 2", "test2@email.com", "password", UserRole.STUDENT) {});

        when(userRepository.findAll()).thenReturn(userList);

        List<User> foundUsers = userService.findAll();

        assertNotNull(foundUsers);
        assertEquals(2, foundUsers.size());

        verify(userRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should delete a user by id")
    void deleteById() {
        Long id = 1L;

        doNothing().when(userRepository).deleteById(id);

        userService.deleteById(id);

        verify(userRepository, times(1)).deleteById(id);
    }

    @Test
    @DisplayName("Should update a user")
    void update() {
        Long id = 1L;
        User user = new User("Test User Updated", "test@email.com", "password", UserRole.STUDENT) {};
        user.setId(id);

        when(userRepository.existsById(id)).thenReturn(true);
        when(userRepository.save(any(User.class))).thenReturn(user);

        User updatedUser = userService.update(user);

        assertNotNull(updatedUser);
        assertEquals(user.getId(), updatedUser.getId());
        assertEquals(user.getName(), updatedUser.getName());
        assertEquals(user.getEmail(), updatedUser.getEmail());
        assertEquals(user.getPassword(), updatedUser.getPassword());

        verify(userRepository, times(1)).existsById(id);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    @DisplayName("Should throw exception when trying to update a user that does not exist")
    void updateNotFound() {
        Long id = 1L;
        User user = new User("Test User Updated", "test@email.com", "password", UserRole.STUDENT) {};
        user.setId(id);

        when(userRepository.existsById(id)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> userService.update(user));

        verify(userRepository, times(1)).existsById(id);
        verify(userRepository, never()).save(user);
    }
}