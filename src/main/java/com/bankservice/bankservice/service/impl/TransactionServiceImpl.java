package com.bankservice.bankservice.service.impl;

import com.bankservice.bankservice.exception.DataProcessingException;
import com.bankservice.bankservice.model.Account;
import com.bankservice.bankservice.model.Transaction;
import com.bankservice.bankservice.repository.TransactionRepository;
import com.bankservice.bankservice.service.TransactionService;
import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void transfer(Account accountFrom, Account accountTo, double amount) {
        if (accountFrom == null || accountTo == null || amount <= 0) {
            throw new DataProcessingException("You don't have enough money to process the payment");
        }

        Transaction transactionIn = new Transaction();
        transactionIn.setAccountFrom(accountFrom);
        transactionIn.setAccountTo(accountTo);
        transactionIn.setAmount(amount);
        transactionIn.setType(Transaction.Type.INCOMING);
        transactionIn.setDateTime(LocalDateTime.now());
        accountTo.setBalance(amount + accountTo.getBalance());
        repository.save(transactionIn);

        Transaction transactionOut = new Transaction();
        transactionOut.setAccountFrom(accountFrom);
        transactionOut.setAccountTo(accountTo);
        transactionOut.setAmount(amount);
        transactionOut.setType(Transaction.Type.OUTGOING);
        transactionOut.setDateTime(LocalDateTime.now());
        accountTo.setBalance(amount - accountTo.getBalance());
        repository.save(transactionOut);
    }

    @Override
    public List<Transaction> getAllTransactionsByAccount(int page, int size, Account account) {
        Sort sort = Sort.by("dateTime").descending();
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return repository.getAllTransactionByAccount(account,pageRequest);
    }
}
