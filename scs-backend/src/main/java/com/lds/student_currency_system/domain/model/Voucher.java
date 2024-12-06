package com.lds.student_currency_system.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import com.lds.student_currency_system.domain.enums.VoucherStatus;

@Entity
@Table(name = "vouchers")
@Getter
@Setter
@NoArgsConstructor
public class Voucher {

    public Voucher(String code, String qrCode, Advantage advantage, Date validity, VoucherStatus status, Student student) {
        this.code = code;
        this.qrCode = qrCode;
        this.advantage = advantage;
        this.validity = validity;
        this.status = status;
        this.student = student;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "advantage_id", nullable = false)
    private Advantage advantage;

    @Column(nullable = false)
    private Date validity;

    @Column(nullable = false)
    private String qrCode;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VoucherStatus status;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
