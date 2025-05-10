package com.stanislawidzior.sii.task.collectionboxes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Currency;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "account")
    private Event event;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private Double balance;


}
