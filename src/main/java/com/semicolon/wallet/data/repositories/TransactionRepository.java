package com.semicolon.wallet.data.repositories;

import com.semicolon.wallet.data.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
