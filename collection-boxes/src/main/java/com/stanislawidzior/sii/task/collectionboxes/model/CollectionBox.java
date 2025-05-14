package com.stanislawidzior.sii.task.collectionboxes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CollectionBox {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private boolean assigned = false;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;
    @OneToMany(mappedBy = "collectionBox", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MonetaryValue> monetaryValues = new ArrayList<>();


}
