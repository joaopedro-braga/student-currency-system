package com.lds.student_currency_system.infra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lds.student_currency_system.domain.model.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findAllByReceiverIdOrSenderId(Long senderId, Long receiverId);
    
    @SuppressWarnings("null")
    List<Transfer> findAll();
}
