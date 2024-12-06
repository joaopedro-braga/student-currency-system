// package com.lds.student_currency_system.domain.service;

// import com.lds.student_currency_system.infra.repositories.AdminRepository;
// import com.lds.student_currency_system.domain.model.Admin;
// import com.lds.student_currency_system.domain.service.impl.AdminServiceImpl;

// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.beans.factory.annotation.Autowired;

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
// class AdminServiceTest {

//     @Mock
//     private AdminRepository adminRepository;

//     @Autowired 
//     @InjectMocks
//     AdminServiceImpl adminService;

//     @Test
//     @DisplayName("Must save a new admin")
//     void save() {
//         Admin admin = new Admin();
//         admin.setId(1L);
//         admin.setName("Admin Teste");

//         when(adminRepository.save(any(Admin.class))).thenReturn(admin);

//         Admin savedAdmin = adminService.save(admin);

//         assertNotNull(savedAdmin);
//         assertEquals(admin.getId(), savedAdmin.getId());
//         assertEquals(admin.getName(), savedAdmin.getName());

//         verify(adminRepository, times(1)).save(admin);
//     }

//     @Test
//     @DisplayName("Must save an admin and find him by id")
//     void findById() {
//         Long id = 1L;
//         Admin admin = new Admin();
//         admin.setId(id);
//         admin.setName("Admin Teste");

//         when(adminRepository.findById(id)).thenReturn(Optional.of(admin));

//         Optional<Admin> foundAdmin = adminService.findById(id);

//         assertTrue(foundAdmin.isPresent());
//         assertEquals(admin.getId(), foundAdmin.get().getId());
//         assertEquals(admin.getName(), foundAdmin.get().getName());

//         verify(adminRepository, times(1)).findById(id);
//     }

//     @Test
//     @DisplayName("Must find all admins")
//     void findAll() {
//         List<Admin> adminList = new ArrayList<>();

//         Admin admin1 = new Admin();
//         admin1.setId(1L);
//         admin1.setName("Admin 1");

//         Admin admin2 = new Admin();
//         admin2.setId(2L);
//         admin2.setName("Admin 2");


//         adminList.add(admin1);
//         adminList.add(admin2);

//         when(adminRepository.findAll()).thenReturn(adminList);

//         List<Admin> foundAdmins = adminService.findAll();

//         assertNotNull(foundAdmins);
//         assertEquals(2, foundAdmins.size());

//         verify(adminRepository, times(1)).findAll();
//     }

//     @Test
//     @DisplayName("Must delete an admin by id")
//     void deleteById() {
//         Long id = 1L;

//         doNothing().when(adminRepository).deleteById(id);

//         adminService.deleteById(id);

//         verify(adminRepository, times(1)).deleteById(id);
//     }

//     @Test
//     @DisplayName("Must update an admin")
//     void update() {
//         Long id = 1L;
//         Admin admin = new Admin();
//         admin.setId(id);
//         admin.setName("Admin Atualizado");

//         when(adminRepository.existsById(id)).thenReturn(true);
//         when(adminRepository.save(any(Admin.class))).thenReturn(admin);

//         Admin updatedAdmin = adminService.update(admin);

//         assertNotNull(updatedAdmin);
//         assertEquals(admin.getId(), updatedAdmin.getId());
//         assertEquals(admin.getName(), updatedAdmin.getName());

//         verify(adminRepository, times(1)).existsById(id);
//         verify(adminRepository, times(1)).save(admin);
//     }

//     @Test
//     @DisplayName("Must throw exception when trying to update an admin that does not exist")
//     void updateNotFound() {
//         Long id = 1L;
//         Admin admin = new Admin();
//         admin.setId(id);

//         when(adminRepository.existsById(id)).thenReturn(false);

//         assertThrows(RuntimeException.class, () -> adminService.update(admin));

//         verify(adminRepository, times(1)).existsById(id);
//         verify(adminRepository, never()).save(admin);
//     }
// }