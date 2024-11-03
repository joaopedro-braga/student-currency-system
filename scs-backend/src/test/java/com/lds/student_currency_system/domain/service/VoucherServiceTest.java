package com.lds.student_currency_system.domain.service;

import com.lds.student_currency_system.infra.repositories.VoucherRepository;
import com.lds.student_currency_system.domain.model.Voucher;
import com.lds.student_currency_system.domain.service.impl.VoucherServiceImpl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

@ExtendWith(MockitoExtension.class)
class VoucherServiceTest {

    @Mock
    private VoucherRepository voucherRepository;

    @InjectMocks
    private VoucherServiceImpl voucherService;

    @Test
    @DisplayName("Should save a voucher")
    void save() {
        Voucher voucher = new Voucher();
        voucher.setId(1L);
        voucher.setCode("voucher-test");

        when(voucherRepository.save(any(Voucher.class))).thenReturn(voucher);

        Voucher savedVoucher = voucherService.save(voucher);

        assertNotNull(savedVoucher);
        assertEquals(voucher.getId(), savedVoucher.getId());
        assertEquals(voucher.getCode(), savedVoucher.getCode());

        verify(voucherRepository, times(1)).save(voucher);
    }

    @Test
    @DisplayName("Should find a voucher by id")
    void findById() {
        Long id = 1L;
        Voucher voucher = new Voucher();
        voucher.setId(id);
        voucher.setCode("voucher-test");

        when(voucherRepository.findById(id)).thenReturn(Optional.of(voucher));

        Optional<Voucher> foundVoucher = voucherService.findById(id);

        assertTrue(foundVoucher.isPresent());
        assertEquals(voucher.getId(), foundVoucher.get().getId());
        assertEquals(voucher.getCode(), foundVoucher.get().getCode());

        verify(voucherRepository, times(1)).findById(id);
    }

    @Test
    @DisplayName("Should find all vouchers")
    void findAll() {
        List<Voucher> voucherList = new ArrayList<>();

        Voucher voucher1 = new Voucher();
        voucher1.setId(1L);
        voucher1.setCode("voucher-test-1");

        Voucher voucher2 = new Voucher();
        voucher2.setId(2L);
        voucher2.setCode("voucher-test-2");


        voucherList.add(voucher1);
        voucherList.add(voucher2);

        when(voucherRepository.findAll()).thenReturn(voucherList);

        List<Voucher> foundVouchers = voucherService.findAll();

        assertNotNull(foundVouchers);
        assertEquals(2, foundVouchers.size());

        verify(voucherRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should delete a voucher by id")
    void deleteById() {
        Long id = 1L;

        doNothing().when(voucherRepository).deleteById(id);

        voucherService.deleteById(id);

        verify(voucherRepository, times(1)).deleteById(id);
    }

    @Test
    @DisplayName("Should update a voucher")
    void update() {
        Long id = 1L;
        Voucher voucher = new Voucher();
        voucher.setId(id);
        voucher.setCode("voucher-test-updated");

        when(voucherRepository.existsById(id)).thenReturn(true);
        when(voucherRepository.save(any(Voucher.class))).thenReturn(voucher);

        Voucher updatedVoucher = voucherService.update(voucher);

        assertNotNull(updatedVoucher);
        assertEquals(voucher.getId(), updatedVoucher.getId());
        assertEquals(voucher.getCode(), updatedVoucher.getCode());

        verify(voucherRepository, times(1)).existsById(id);
        verify(voucherRepository, times(1)).save(voucher);
    }

    @Test
    @DisplayName("Should throw exception when trying to update a voucher that does not exist")
    void updateNotFound() {
        Long id = 1L;
        Voucher voucher = new Voucher();
        voucher.setId(id);
        voucher.setCode("voucher-test-updated");

        when(voucherRepository.existsById(id)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> voucherService.update(voucher));

        verify(voucherRepository, times(1)).existsById(id);
        verify(voucherRepository, never()).save(voucher);
    }
}