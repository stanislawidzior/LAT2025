package com.stanislawidzior.sii.task.collectionboxes.repositories;

import com.stanislawidzior.sii.task.collectionboxes.model.MonetaryValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonetaryValueRepository extends JpaRepository<MonetaryValue, Long> {
}
