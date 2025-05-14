package com.stanislawidzior.sii.task.collectionboxes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String title;
    @OneToMany(mappedBy = "event")
    private List<CollectionBox> collectionBoxes;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="account_id",referencedColumnName = "id", nullable = false)
    private Account account;
}
