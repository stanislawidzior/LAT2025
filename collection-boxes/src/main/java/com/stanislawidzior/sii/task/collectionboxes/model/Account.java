package com.stanislawidzior.sii.task.collectionboxes.model;

import com.stanislawidzior.sii.task.collectionboxes.model.enums.Currencies;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "account")
    private Event event;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currencies currency;
    private BigDecimal balance;

}
