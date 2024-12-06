package com.lds.student_currency_system.domain.model;

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

import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
@Getter
@Setter
@NoArgsConstructor
public class Transfer {

    public Transfer(User sender, User receiver, float coinQuantity, String description) {
        this.date = LocalDateTime.now();
        this.sender = sender;
        this.receiver = receiver;
        this.coinQuantity = coinQuantity;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;

    @Column(name = "coin_quantity", nullable = false)
    private float coinQuantity;

    @Column(nullable = false)
    private String description;
}
