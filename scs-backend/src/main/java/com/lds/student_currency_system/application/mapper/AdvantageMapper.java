package com.lds.student_currency_system.application.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.lds.student_currency_system.application.dto.AdvantageRequest;
import com.lds.student_currency_system.application.dto.AdvantageResponse;
import com.lds.student_currency_system.domain.model.Advantage;
import com.lds.student_currency_system.domain.model.Company;

@Component
public class AdvantageMapper {

    public static Advantage toAdvantage(AdvantageRequest request, Company company) {
        if (request == null) {
            return null;
        }

        return new Advantage(request.name(), request.image(), request.price(), company,
                request.description());
    }

    public static AdvantageResponse toAdvantageResponse(Advantage advantage) {
        if (advantage == null) {
            return null;
        }

        return new AdvantageResponse(advantage.getId(), advantage.getName(), advantage.getImage(), advantage.getPrice(),
                advantage.getCompany().getName(), advantage.getDescription(), advantage.getDate());
    }

    public static List<AdvantageResponse> toAdvantageResponseList(List<Advantage> advantages) {
        return advantages.stream()
                .map(AdvantageMapper::toAdvantageResponse)
                .collect(Collectors.toList());
    }
}
