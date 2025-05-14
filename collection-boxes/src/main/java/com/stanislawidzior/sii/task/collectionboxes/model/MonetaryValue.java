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
public class MonetaryValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currencies currency;
    @Column(nullable = false)
    private BigDecimal amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="box_id", referencedColumnName = "id", nullable = false)
    private CollectionBox collectionBox;



}
