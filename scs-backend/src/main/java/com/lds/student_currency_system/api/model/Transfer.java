package com.lds.student_currency_system.api.model;

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

    public Transfer(Date day, User transactor, float value, String type, String description) {
        this.day = day;
        this.transactor = transactor;
        this.value = value;
        this.type = type;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date day;

    @ManyToOne
    @JoinColumn(name = "transactor_id", nullable = false)
    private User transactor;

    @Column(nullable = false)
    private float value;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;
}
