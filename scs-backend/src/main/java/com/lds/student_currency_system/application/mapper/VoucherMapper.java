package com.lds.student_currency_system.application.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.lds.student_currency_system.application.dto.VoucherResponse;
import com.lds.student_currency_system.domain.model.Voucher;

public class VoucherMapper {
    
    public static VoucherResponse toVoucherResponse(Voucher voucher) {
        if (voucher == null) {
            return null;
        }

        return new VoucherResponse(
            voucher.getAdvantage().getName(),
            voucher.getAdvantage().getDescription(),
            voucher.getAdvantage().getImage(),
            voucher.getCode(),
            voucher.getQrCode(),
            voucher.getAdvantage().getCompany().getName(),
            voucher.getValidity(),
            voucher.getStatus()
        );

    }

    public static List<VoucherResponse> toVoucherResponseList(List<Voucher> vouchers) {
        return vouchers.stream()
                .map(VoucherMapper::toVoucherResponse)
                .collect(Collectors.toList());
    }
}
