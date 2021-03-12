package com.bankservice.bankservice.service;

import com.bankservice.bankservice.model.Account;
import com.bankservice.bankservice.model.Transaction;
import java.util.List;

public interface TransactionService {
    void transfer(Account accountFrom, Account accountTo, double amount);

    List<Transaction> getAllTransactionsByAccount(int page, int size, Account account);
}
