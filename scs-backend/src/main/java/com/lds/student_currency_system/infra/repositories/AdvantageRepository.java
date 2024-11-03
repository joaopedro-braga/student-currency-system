package com.lds.student_currency_system.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lds.student_currency_system.domain.model.Advantage;

@Repository
public interface AdvantageRepository extends JpaRepository<Advantage, Long> {
}