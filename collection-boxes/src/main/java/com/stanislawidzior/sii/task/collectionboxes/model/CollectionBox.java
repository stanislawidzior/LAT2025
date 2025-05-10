package com.stanislawidzior.sii.task.collectionboxes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class CollectionBox {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    private boolean registered = false;
    @ManyToOne()
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "box_id")
    private List<AmountInCurrency> amountInCurrencies = new ArrayList<>();


}
