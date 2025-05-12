package com.stanislawidzior.sii.task.collectionboxes.repositories;

import com.stanislawidzior.sii.task.collectionboxes.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
