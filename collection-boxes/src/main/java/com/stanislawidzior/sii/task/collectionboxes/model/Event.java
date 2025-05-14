package com.stanislawidzior.sii.task.collectionboxes.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String title;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<CollectionBox> collectionBoxes;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="account_id",referencedColumnName = "id", nullable = false)
    private Account account;
}
