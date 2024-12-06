// package com.lds.student_currency_system.application.api;

// import com.lds.student_currency_system.domain.model.Company;
// import com.lds.student_currency_system.domain.service.CompanyService;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.anyLong;
// import static org.mockito.Mockito.doNothing;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// class CompanyControllerTest {

//     private MockMvc mockMvc;

//     @Mock
//     private CompanyService companyService;

//     @InjectMocks
//     private CompanyController companyController;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//         mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();
//     }

//     @Test
//     @DisplayName("Create Company - Success")
//     void testCreateCompany() throws Exception {
//         Company company = new Company("Test Company", "company@example.com", "password", "12345678901234", "Test Address");
//         company.setId(1L);

//         when(companyService.save(any(Company.class))).thenReturn(company);

//         mockMvc.perform(post("/api/companies")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content("{\"name\": \"Test Company\", \"email\": \"company@example.com\", \"password\": \"password\", \"cnpj\": \"12345678901234\", \"address\": \"Test Address\"}"))
//                 .andExpect(status().isCreated())
//                 .andExpect(jsonPath("$.id").value(1L))
//                 .andExpect(jsonPath("$.name").value("Test Company"));
//     }

//     @Test
//     @DisplayName("Get Company by ID - Success")
//     void testGetCompanyById() throws Exception {
//         Company company = new Company("Test Company", "company@example.com", "password", "12345678901234", "Test Address");
//         company.setId(1L);


//         when(companyService.findById(1L)).thenReturn(Optional.of(company));

//         mockMvc.perform(get("/api/companies/1"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.id").value(1L))
//                 .andExpect(jsonPath("$.name").value("Test Company"));
//     }

//     @Test
//     @DisplayName("Get Company by ID - Not Found")
//     void testGetCompanyByIdNotFound() throws Exception {
//         when(companyService.findById(anyLong())).thenReturn(Optional.empty());

//         mockMvc.perform(get("/api/companies/1"))
//                 .andExpect(status().isNotFound());
//     }


//     @Test
//     @DisplayName("Get All Companies - Success")
//     void testGetAllCompanies() throws Exception {
//         Company company1 = new Company("Test Company 1", "company1@example.com", "password", "12345678901234", "Test Address 1");
//         company1.setId(1L);

//         Company company2 = new Company("Test Company 2", "company2@example.com", "password", "98765432100000", "Test Address 2");

//         company2.setId(2L);
//         List<Company> companies = Arrays.asList(company1, company2);

//         when(companyService.findAll()).thenReturn(companies);


//         mockMvc.perform(get("/api/companies"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$[0].id").value(1L))
//                 .andExpect(jsonPath("$[1].id").value(2L));


//     }

//     @Test
//     @DisplayName("Update Company - Success")
//     void testUpdateCompany() throws Exception {
//         Company company = new Company("Updated Company", "updated@example.com", "new_password", "11111111111111", "Updated Address");
//         company.setId(1L);

//         when(companyService.update(any(Company.class))).thenReturn(company);



//         mockMvc.perform(put("/api/companies/1")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content("{\"name\": \"Updated Company\", \"email\": \"updated@example.com\", \"password\": \"new_password\", \"cnpj\": \"11111111111111\", \"address\": \"Updated Address\"}"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.id").value(1L))
//                 .andExpect(jsonPath("$.name").value("Updated Company"));
//     }


//     @Test
//     @DisplayName("Delete Company - Success")
//     void testDeleteCompany() throws Exception {
//         doNothing().when(companyService).deleteById(anyLong());

//         mockMvc.perform(delete("/api/companies/1"))
//                 .andExpect(status().isNoContent());

//     }
// }