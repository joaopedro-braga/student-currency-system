package com.lds.student_currency_system.infra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lds.student_currency_system.domain.model.Advantage;
import com.lds.student_currency_system.domain.model.Company;

@Repository
public interface AdvantageRepository extends JpaRepository<Advantage, Long> {

    List<Advantage> findAllByCompany(Company company);
}