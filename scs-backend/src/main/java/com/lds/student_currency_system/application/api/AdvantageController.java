package com.lds.student_currency_system.application.api;

import com.lds.student_currency_system.application.domain.model.Advantage;
import com.lds.student_currency_system.application.domain.service.AdvantageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/advantages")
@RequiredArgsConstructor
public class AdvantageController {

    private final AdvantageService advantageService;

    @PostMapping
    public ResponseEntity<Advantage> createAdvantage(@RequestBody Advantage advantage) {
        Advantage savedAdvantage = advantageService.save(advantage);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdvantage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advantage> getAdvantageById(@PathVariable Long id) {
        return advantageService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Advantage>> getAllAdvantages() {
        List<Advantage> advantages = advantageService.findAll();
        return ResponseEntity.ok(advantages);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Advantage> updateAdvantage(@PathVariable Long id, @RequestBody Advantage advantage) {
        advantage.setId(id);
        Advantage updatedAdvantage = advantageService.update(advantage);
        return ResponseEntity.ok(updatedAdvantage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvantage(@PathVariable Long id) {
        advantageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}