package com.lds.student_currency_system.application.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "vouchers")
@Getter
@Setter
@NoArgsConstructor
public class Voucher {

    public Voucher(String code, Advantage advantage, Date validity, String type, Student student) {
        this.code = code;
        this.advantage = advantage;
        this.validity = validity;
        this.type = type;
        this.student = student;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "advantage_id", nullable = false)
    private Advantage advantage;

    @Column(nullable = false)
    private Date validity;

    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
