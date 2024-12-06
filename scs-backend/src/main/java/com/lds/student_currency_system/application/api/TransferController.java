package com.lds.student_currency_system.application.api;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lds.student_currency_system.application.dto.TransferResponse;
import com.lds.student_currency_system.domain.model.User;
import com.lds.student_currency_system.domain.service.TransferService;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @GetMapping("/{id}")
    public ResponseEntity<TransferResponse> getTransferById(@PathVariable Long id) {
        return transferService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<TransferResponse>> getAllTransfers(@AuthenticationPrincipal User user) {
        List<TransferResponse> transfers = transferService.findAllByTransactor(user);
        return ResponseEntity.ok(transfers);
    }
}