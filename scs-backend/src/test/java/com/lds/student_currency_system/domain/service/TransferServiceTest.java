package com.lds.student_currency_system.domain.service;

import com.lds.student_currency_system.infra.repositories.TransferRepository;
import com.lds.student_currency_system.domain.model.Transfer;
import com.lds.student_currency_system.domain.service.impl.TransferServiceImpl;

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
class TransferServiceTest {

    @Mock
    private TransferRepository transferRepository;

    @InjectMocks
    private TransferServiceImpl transferService;

    @Test
    @DisplayName("Must save a new transfer")
    void save() {
        Transfer transfer = new Transfer();
        transfer.setId(1L);
        transfer.setCoinQuantity(50);

        when(transferRepository.save(any(Transfer.class))).thenReturn(transfer);

        Transfer savedTransfer = transferService.save(transfer);

        assertNotNull(savedTransfer);
        assertEquals(transfer.getId(), savedTransfer.getId());
        assertEquals(transfer.getCoinQuantity(), savedTransfer.getCoinQuantity());

        verify(transferRepository, times(1)).save(transfer);
    }

    @Test
    @DisplayName("Must find a transfer by id")
    void findById() {
        Long id = 1L;
        Transfer transfer = new Transfer();
        transfer.setId(id);
        transfer.setCoinQuantity(50);

        when(transferRepository.findById(id)).thenReturn(Optional.of(transfer));

        Optional<Transfer> foundTransfer = transferService.findById(id);

        assertTrue(foundTransfer.isPresent());
        assertEquals(transfer.getId(), foundTransfer.get().getId());
        assertEquals(transfer.getCoinQuantity(), foundTransfer.get().getCoinQuantity());

        verify(transferRepository, times(1)).findById(id);
    }

    @Test
    @DisplayName("Must find all transfers")
    void findAll() {
        List<Transfer> transferList = new ArrayList<>();

        Transfer transfer1 = new Transfer();
        transfer1.setId(1L);
        transfer1.setCoinQuantity(50);

        Transfer transfer2 = new Transfer();
        transfer2.setId(2L);
        transfer2.setCoinQuantity(100);

        transferList.add(transfer1);
        transferList.add(transfer2);

        when(transferRepository.findAll()).thenReturn(transferList);

        List<Transfer> foundTransfers = transferService.findAll();

        assertNotNull(foundTransfers);
        assertEquals(2, foundTransfers.size());

        verify(transferRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Must delete a transfer by id")
    void deleteById() {
        Long id = 1L;

        doNothing().when(transferRepository).deleteById(id);

        transferService.deleteById(id);

        verify(transferRepository, times(1)).deleteById(id);
    }

    @Test
    @DisplayName("Must update a transfer")
    void update() {
        Long id = 1L;
        Transfer transfer = new Transfer();
        transfer.setId(id);
        transfer.setCoinQuantity(100);

        when(transferRepository.existsById(id)).thenReturn(true);
        when(transferRepository.save(any(Transfer.class))).thenReturn(transfer);

        Transfer updatedTransfer = transferService.update(transfer);

        assertNotNull(updatedTransfer);
        assertEquals(transfer.getId(), updatedTransfer.getId());
        assertEquals(transfer.getCoinQuantity(), updatedTransfer.getCoinQuantity());

        verify(transferRepository, times(1)).existsById(id);
        verify(transferRepository, times(1)).save(transfer);
    }

    @Test
    @DisplayName("Must throw exception when trying to update a transfer that does not exist")
    void updateNotFound() {
        Long id = 1L;
        Transfer transfer = new Transfer();
        transfer.setId(id);

        when(transferRepository.existsById(id)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> transferService.update(transfer));

        verify(transferRepository, times(1)).existsById(id);
        verify(transferRepository, never()).save(transfer);
    }
}