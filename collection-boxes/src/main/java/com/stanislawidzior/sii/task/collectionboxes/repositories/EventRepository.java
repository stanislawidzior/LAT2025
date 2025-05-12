package com.stanislawidzior.sii.task.collectionboxes.repositories;

import com.stanislawidzior.sii.task.collectionboxes.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
