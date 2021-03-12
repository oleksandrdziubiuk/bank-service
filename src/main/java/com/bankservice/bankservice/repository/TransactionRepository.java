package com.bankservice.bankservice.repository;

import com.bankservice.bankservice.model.Account;
import com.bankservice.bankservice.model.Transaction;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("FROM transactions t JOIN FETCH t.accountFrom "
            + "JOIN FETCH t.accountTo WHERE t.accountFrom = ?1 OR t.accountTo = ?1")
    List<Transaction> getAllTransactionByAccount(Account account, PageRequest pageable);
}
