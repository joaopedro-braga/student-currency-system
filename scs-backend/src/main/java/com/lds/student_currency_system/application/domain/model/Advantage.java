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
@Table(name = "advantages")
@Getter
@Setter
@NoArgsConstructor
public class Advantage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private float value;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date date;

    public Advantage(String name, String image, float value, Company company, String description, Date date) {
        this.name = name;
        this.image = image;
        this.value = value;
        this.company = company;
        this.description = description;
        this.date = date;
    }
}
