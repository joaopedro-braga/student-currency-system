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
@Table(name = "transfers")
@Getter
@Setter
@NoArgsConstructor
public class Transfer {

    public Transfer(Date date, User transactor, float coinQuantity, String type, String description) {
        this.date = date;
        this.transactor = transactor;
        this.coinQuantity = coinQuantity;
        this.type = type;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "transactor_id", nullable = false)
    private User transactor;

    @Column(name = "coin_quantity", nullable = false)
    private float coinQuantity;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;
}
