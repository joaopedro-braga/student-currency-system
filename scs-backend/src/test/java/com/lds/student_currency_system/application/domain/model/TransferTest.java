package com.lds.student_currency_system.application.domain.model;

import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransferTest {

    @Test
    void testTransferCreation() {
        Professor professor = new Professor("Professor Name", "prof@example.com", "profpass", "12345678901", "Department", new Institution("Institution name"), 100.0f);
        Date date = new Date();
        Transfer transfer = new Transfer(date, professor, 50.0f, "Donation", "Test transfer");
        assertEquals(date, transfer.getDate());
        assertEquals(professor, transfer.getTransactor());
        assertEquals(50.0f, transfer.getCoinQuantity());
        assertEquals("Donation", transfer.getType());
        assertEquals("Test transfer", transfer.getDescription());
    }
}