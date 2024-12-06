// package com.lds.student_currency_system.application.api;

// import com.lds.student_currency_system.domain.model.Institution;
// import com.lds.student_currency_system.domain.model.Student;
// import com.lds.student_currency_system.domain.service.StudentService;
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

// class StudentControllerTest {

//     private MockMvc mockMvc;

//     @Mock
//     private StudentService studentService;

//     @InjectMocks
//     private StudentController studentController;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//         mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
//     }

//     @Test
//     @DisplayName("Create Student - Success")
//     void testCreateStudent() throws Exception {
//         Institution institution = new Institution("Test Institution");
//         institution.setId(1L);
//         Student student = new Student("Test Student", "test@example.com", "password", "12345678901", "Test Address", institution, "Test Course", 100.0f);
//         student.setId(1L);


//         when(studentService.save(any(Student.class))).thenReturn(student);

//         mockMvc.perform(post("/api/students")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content("{\"name\": \"Test Student\", \"email\": \"test@example.com\", \"password\": \"password\", \"cpf\": \"12345678901\", \"address\": \"Test Address\", \"institution\": {\"id\": 1}, \"course\": \"Test Course\", \"balance\": 100.0}"))
//                 .andExpect(status().isCreated())
//                 .andExpect(jsonPath("$.id").value(1L))
//                 .andExpect(jsonPath("$.name").value("Test Student"));
//     }


//     @Test
//     @DisplayName("Get Student by ID - Success")
//     void testGetStudentById() throws Exception {
//         Institution institution = new Institution("Test Institution");
//         institution.setId(1L);
//         Student student = new Student("Test Student", "test@example.com", "password", "12345678901", "Test Address", institution, "Test Course", 100.0f);
//         student.setId(1L);

//         when(studentService.findById(1L)).thenReturn(Optional.of(student));

//         mockMvc.perform(get("/api/students/1"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.id").value(1L))
//                 .andExpect(jsonPath("$.name").value("Test Student")); 
//     }


//     @Test
//     @DisplayName("Get Student by ID - Not Found")
//     void testGetStudentByIdNotFound() throws Exception {
//         when(studentService.findById(anyLong())).thenReturn(Optional.empty());

//         mockMvc.perform(get("/api/students/1"))
//                 .andExpect(status().isNotFound());
//     }

//     @Test
//     @DisplayName("Get All Students - Success")
//     void testGetAllStudents() throws Exception {
//         Institution institution = new Institution("Test Institution");
//         institution.setId(1L);
//         Student student1 = new Student("Test Student 1", "test1@example.com", "password", "12345678901", "Test Address 1", institution, "Test Course 1", 100.0f);
//         student1.setId(1L);

//         Student student2 = new Student("Test Student 2", "test2@example.com", "password", "12345678902", "Test Address 2", institution, "Test Course 2", 150.0f);
//         student2.setId(2L);

//         List<Student> students = Arrays.asList(student1, student2);
//         when(studentService.findAll()).thenReturn(students);


//         mockMvc.perform(get("/api/students"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$[0].id").value(1L))
//                 .andExpect(jsonPath("$[1].id").value(2L)); 
//     }


//     @Test
//     @DisplayName("Update Student - Success")
//     void testUpdateStudent() throws Exception {
//         Institution institution = new Institution("Test Institution");
//         institution.setId(1L);
//         Student student = new Student("Updated Student", "updated@example.com", "newpassword", "12345678901", "Updated Address", institution, "Updated Course", 200.0f);
//         student.setId(1L);

//         when(studentService.update(any(Student.class))).thenReturn(student);

//         mockMvc.perform(put("/api/students/1")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content("{\"name\": \"Updated Student\", \"email\": \"updated@example.com\", \"password\": \"newpassword\", \"cpf\": \"12345678901\", \"address\": \"Updated Address\",  \"institution\": {\"id\": 1}, \"course\": \"Updated Course\", \"balance\": 200.0}"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.name").value("Updated Student")); // Add more assertions as needed
//     }


//     @Test
//     @DisplayName("Delete Student - Success")
//     void testDeleteStudent() throws Exception {

//         doNothing().when(studentService).deleteById(anyLong());

//         mockMvc.perform(delete("/api/students/1"))
//                 .andExpect(status().isNoContent());
//     }
// }