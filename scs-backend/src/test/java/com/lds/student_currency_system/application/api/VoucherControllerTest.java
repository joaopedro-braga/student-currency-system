package com.lds.student_currency_system.application.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lds.student_currency_system.domain.model.Voucher;
import com.lds.student_currency_system.domain.service.VoucherService;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class VoucherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private VoucherService voucherService;

    @InjectMocks
    private VoucherController voucherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(voucherController).build();
    }

    @Test
    @DisplayName("Checks if creating a voucher returns HTTP status 201 Created and if the JSON content contains the created voucher.")
    void testCreateVoucher() throws Exception {
        Voucher voucher = new Voucher();
        voucher.setId(1L);
        voucher.setCode("New Voucher");

        when(voucherService.save(any(Voucher.class))).thenReturn(voucher);

        mockMvc.perform(post("/api/vouchers")
                        .contentType("application/json")
                        .content("{\"code\":\"New Voucher\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.code").value("New Voucher"));
    }

    @Test
    @DisplayName("Checks the return of an existing voucher")
    void testGetVoucherById() throws Exception {
        Voucher voucher = new Voucher();
        voucher.setId(1L);
        voucher.setCode("Test Voucher");

        when(voucherService.findById(1L)).thenReturn(Optional.of(voucher));

        mockMvc.perform(get("/api/vouchers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.code").value("Test Voucher"));
    }

    @Test
    @DisplayName("Checks the return of a non-existent voucher")
    void testGetVoucherByIdNotFound() throws Exception {
        when(voucherService.findById(anyLong())).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/vouchers/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Checks that all vouchers are returned correctly")
    void testGetAllVouchers() throws Exception {
        Voucher voucher1 = new Voucher();
        voucher1.setId(1L);
        voucher1.setCode("Voucher 1");

        Voucher voucher2 = new Voucher();
        voucher2.setId(2L);
        voucher2.setCode("Voucher 2");

        when(voucherService.findAll()).thenReturn(Arrays.asList(voucher1, voucher2));

        mockMvc.perform(get("/api/vouchers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].code").value("Voucher 1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].code").value("Voucher 2"));
    }

    @Test
    @DisplayName("Checks whether a voucher update occurs correctly, returning the updated voucher")
    void testUpdateVoucher() throws Exception {
        Voucher voucher = new Voucher();
        voucher.setId(1L);
        voucher.setCode("Updated Voucher");

        when(voucherService.update(any(Voucher.class))).thenReturn(voucher);

        mockMvc.perform(put("/api/vouchers/1")
                        .contentType("application/json")
                        .content("{\"code\":\"Updated Voucher\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.code").value("Updated Voucher"));
    }

    @Test
    @DisplayName("Confirms that the voucher is deleted and the status 204 No Content is returned")
    void testDeleteVoucher() throws Exception {
        doNothing().when(voucherService).deleteById(anyLong());

        mockMvc.perform(delete("/api/vouchers/1"))
                .andExpect(status().isNoContent());
    }
}
