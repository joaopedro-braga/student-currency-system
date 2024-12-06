// package com.lds.student_currency_system.application.api;

// import com.lds.student_currency_system.domain.model.Advantage;
// import com.lds.student_currency_system.domain.model.Company;
// import com.lds.student_currency_system.domain.service.AdvantageService;
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
// import java.util.Date;
// import java.util.List;
// import java.util.Optional;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.anyLong;
// import static org.mockito.Mockito.doNothing;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// class AdvantageControllerTest {

//     private MockMvc mockMvc;

//     @Mock
//     private AdvantageService advantageService;

//     @InjectMocks
//     private AdvantageController advantageController;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//         mockMvc = MockMvcBuilders.standaloneSetup(advantageController).build();
//     }

//     @Test
//     @DisplayName("Create Advantage - Success")
//     void testCreateAdvantage() throws Exception {
//         Company company = new Company(); 
//         company.setId(1L);
//         Advantage advantage = new Advantage("Test Advantage", "image.jpg", 10.5f, company, "Test Description", new Date());
//         advantage.setId(1L);


//         when(advantageService.save(any(Advantage.class))).thenReturn(advantage);

//         mockMvc.perform(post("/api/advantages")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content("{\"name\": \"Test Advantage\", \"image\": \"image.jpg\", \"price\": 10.5, \"company\": {\"id\": 1}, \"description\": \"Test Description\", \"date\": \"2024-07-20T12:00:00.000+00:00\"}")) // Example date format
//                 .andExpect(status().isCreated())
//                 .andExpect(jsonPath("$.id").value(1L))
//                 .andExpect(jsonPath("$.name").value("Test Advantage"));
//     }

//     @Test
//     @DisplayName("Get Advantage by ID - Success")
//     void testGetAdvantageById() throws Exception {
//         Company company = new Company();
//         company.setId(1L);
//         Advantage advantage = new Advantage("Test Advantage", "image.jpg", 10.5f, company, "Test Description", new Date());
//         advantage.setId(1L);

//         when(advantageService.findById(1L)).thenReturn(Optional.of(advantage));

//         mockMvc.perform(get("/api/advantages/1"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.id").value(1L))
//                 .andExpect(jsonPath("$.name").value("Test Advantage"));
//     }

//     @Test
//     @DisplayName("Get Advantage by ID - Not Found")
//     void testGetAdvantageByIdNotFound() throws Exception {
//         when(advantageService.findById(anyLong())).thenReturn(Optional.empty());

//         mockMvc.perform(get("/api/advantages/1"))
//                 .andExpect(status().isNotFound());
//     }

//     @Test
//     @DisplayName("Get All Advantages - Success")
//     void testGetAllAdvantages() throws Exception {
//         Company company = new Company();
//         company.setId(1L);
//         Advantage advantage1 = new Advantage("Test Advantage 1", "image1.jpg", 10.5f, company, "Test Description 1", new Date());
//         advantage1.setId(1L);
//         Advantage advantage2 = new Advantage("Test Advantage 2", "image2.jpg", 12f, company, "Test Description 2", new Date());
//         advantage2.setId(2L);

//         List<Advantage> advantages = Arrays.asList(advantage1, advantage2);

//         when(advantageService.findAll()).thenReturn(advantages);

//         mockMvc.perform(get("/api/advantages"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$[0].id").value(1L))
//                 .andExpect(jsonPath("$[1].id").value(2L));


//     }

//     @Test
//     @DisplayName("Update Advantage - Success")
//     void testUpdateAdvantage() throws Exception {
//         Company company = new Company(); 
//         company.setId(1L);
//         Advantage advantage = new Advantage("Updated Advantage", "updated.jpg", 15f, company, "Updated Description", new Date());

//         advantage.setId(1L); 


//         when(advantageService.update(any(Advantage.class))).thenReturn(advantage);



//         mockMvc.perform(put("/api/advantages/1")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content("{\"name\": \"Updated Advantage\", \"image\": \"updated.jpg\", \"price\": 15.0, \"company\": {\"id\": 1}, \"description\": \"Updated Description\", \"date\": \"2024-07-21T12:00:00.000+00:00\"}"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.id").value(1L))
//                 .andExpect(jsonPath("$.name").value("Updated Advantage"));
//     }

//     @Test
//     @DisplayName("Delete Advantage - Success")
//     void testDeleteAdvantage() throws Exception {
//         doNothing().when(advantageService).deleteById(anyLong());


//         mockMvc.perform(delete("/api/advantages/1"))
//                 .andExpect(status().isNoContent());

//     }
// }