package com.lds.student_currency_system.domain.service;

import com.lds.student_currency_system.infra.repositories.AdvantageRepository;
import com.lds.student_currency_system.domain.model.Advantage;
import com.lds.student_currency_system.domain.service.impl.AdvantageServiceImpl;

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
class AdvantageServiceTest {

    @Mock
    private AdvantageRepository advantageRepository;

    @InjectMocks
    private AdvantageServiceImpl advantageService;

    @Test
    @DisplayName("Must save a new advantage")
    void save() {
        Advantage advantage = new Advantage();
        advantage.setId(1L);
        advantage.setName("Advantage Test");
        advantage.setDescription("Description Test");

        when(advantageRepository.save(any(Advantage.class))).thenReturn(advantage);

        Advantage savedAdvantage = advantageService.save(advantage);

        assertNotNull(savedAdvantage);
        assertEquals(advantage.getId(), savedAdvantage.getId());
        assertEquals(advantage.getName(), savedAdvantage.getName());
        assertEquals(advantage.getDescription(), savedAdvantage.getDescription());

        verify(advantageRepository, times(1)).save(advantage);
    }

    @Test
    @DisplayName("Must find an advantage by id")
    void findById() {
        Long id = 1L;
        Advantage advantage = new Advantage();
        advantage.setId(id);
        advantage.setName("Advantage Test");
        advantage.setDescription("Description Test");

        when(advantageRepository.findById(id)).thenReturn(Optional.of(advantage));

        Optional<Advantage> foundAdvantage = advantageService.findById(id);

        assertTrue(foundAdvantage.isPresent());
        assertEquals(advantage.getId(), foundAdvantage.get().getId());
        assertEquals(advantage.getName(), foundAdvantage.get().getName());
        assertEquals(advantage.getDescription(), foundAdvantage.get().getDescription());

        verify(advantageRepository, times(1)).findById(id);
    }

    @Test
    @DisplayName("Must find all advantages")
    void findAll() {
        List<Advantage> advantageList = new ArrayList<>();

        Advantage advantage1 = new Advantage();
        advantage1.setId(1L);
        advantage1.setName("Advantage 1");
        advantage1.setDescription("Description 1");

        Advantage advantage2 = new Advantage();
        advantage2.setId(2L);
        advantage2.setName("Advantage 2");
        advantage2.setDescription("Description 2");

        advantageList.add(advantage1);
        advantageList.add(advantage2);

        when(advantageRepository.findAll()).thenReturn(advantageList);

        List<Advantage> foundAdvantages = advantageService.findAll();

        assertNotNull(foundAdvantages);
        assertEquals(2, foundAdvantages.size());

        verify(advantageRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Must delete an advantage by id")
    void deleteById() {
        Long id = 1L;

        doNothing().when(advantageRepository).deleteById(id);

        advantageService.deleteById(id);

        verify(advantageRepository, times(1)).deleteById(id);
    }

    @Test
    @DisplayName("Must update an advantage")
    void update() {
        Long id = 1L;
        Advantage advantage = new Advantage();
        advantage.setId(id);
        advantage.setName("Advantage Updated");
        advantage.setDescription("Description Updated");

        when(advantageRepository.existsById(id)).thenReturn(true);
        when(advantageRepository.save(any(Advantage.class))).thenReturn(advantage);

        Advantage updatedAdvantage = advantageService.update(advantage);

        assertNotNull(updatedAdvantage);
        assertEquals(advantage.getId(), updatedAdvantage.getId());
        assertEquals(advantage.getName(), updatedAdvantage.getName());
        assertEquals(advantage.getDescription(), updatedAdvantage.getDescription());

        verify(advantageRepository, times(1)).existsById(id);
        verify(advantageRepository, times(1)).save(advantage);
    }

    @Test
    @DisplayName("Must throw exception when trying to update an advantage that does not exist")
    void updateNotFound() {
        Long id = 1L;
        Advantage advantage = new Advantage();
        advantage.setId(id);

        when(advantageRepository.existsById(id)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> advantageService.update(advantage));

        verify(advantageRepository, times(1)).existsById(id);
        verify(advantageRepository, never()).save(advantage);
    }
}