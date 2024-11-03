package com.lds.student_currency_system.application.api;

import com.lds.student_currency_system.domain.model.Transfer;
import com.lds.student_currency_system.domain.service.TransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class TransferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TransferService transferService;

    @InjectMocks
    private TransferController transferController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(transferController).build();
    }

    @Test
    @DisplayName("Checks if creating a transfer returns HTTP status 201 Created")
    void testCreateTransfer() throws Exception {
        Transfer transfer = new Transfer(new Date(), null, 10f, "CREDIT", "Test Description");
        transfer.setId(1L);

        when(transferService.save(any(Transfer.class))).thenReturn(transfer);

        mockMvc.perform(post("/api/transfers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"date\": \"2023-10-26T12:00:00.000+00:00\", \"coinQuantity\": 10.0, \"type\": \"CREDIT\", \"description\": \"Test Description\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.coinQuantity").value(10.0))
                .andExpect(jsonPath("$.type").value("CREDIT"))
                .andExpect(jsonPath("$.description").value("Test Description"));
    }

    @Test
    @DisplayName("Checks the return of an existing transfer")
    void testGetTransferById() throws Exception {
        Transfer transfer = new Transfer(new Date(), null, 10f, "CREDIT", "Test Description");
        transfer.setId(1L);


        when(transferService.findById(1L)).thenReturn(Optional.of(transfer));

        mockMvc.perform(get("/api/transfers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    @DisplayName("Checks the return of a non-existent transfer")
    void testGetTransferByIdNotFound() throws Exception {
        when(transferService.findById(anyLong())).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/transfers/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Checks that all transfers are returned correctly")
    void testGetAllTransfers() throws Exception {
        Transfer transfer1 = new Transfer(new Date(), null, 10f, "CREDIT", "Test Description 1");
        transfer1.setId(1L);
        Transfer transfer2 = new Transfer(new Date(), null, 20f, "DEBIT", "Test Description 2");
        transfer2.setId(2L);

        when(transferService.findAll()).thenReturn(Arrays.asList(transfer1, transfer2));

        mockMvc.perform(get("/api/transfers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[1].id").value(2L));
    }

    @Test
    @DisplayName("Checks whether a transfer update occurs correctly")
    void testUpdateTransfer() throws Exception {
        Transfer transfer = new Transfer(new Date(), null, 15f, "DEBIT", "Updated Description");
        transfer.setId(1L);


        when(transferService.update(any(Transfer.class))).thenReturn(transfer);

        mockMvc.perform(put("/api/transfers/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"date\": \"2023-10-26T13:00:00.000+00:00\", \"coinQuantity\": 15.0, \"type\": \"DEBIT\", \"description\": \"Updated Description\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.coinQuantity").value(15.0))
                .andExpect(jsonPath("$.type").value("DEBIT"))
                .andExpect(jsonPath("$.description").value("Updated Description"));
    }

    @Test
    @DisplayName("Confirms that the transfer is deleted")
    void testDeleteTransfer() throws Exception {
        doNothing().when(transferService).deleteById(anyLong());

        mockMvc.perform(delete("/api/transfers/1"))
                .andExpect(status().isNoContent());
    }
}