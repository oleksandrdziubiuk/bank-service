package com.bankservice.bankservice.service.impl;

import com.bankservice.bankservice.exception.DataProcessingException;
import com.bankservice.bankservice.model.Account;
import com.bankservice.bankservice.repository.AccountRepository;
import com.bankservice.bankservice.service.AccountService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findAccountByAccountNumber(String accountNumber) {
        return accountRepository.findAccountByAccountNumber(accountNumber).orElseThrow(
                () -> new DataProcessingException("Can't find account by account number "
                        + accountNumber));
    }

    @Override
    public List<Account> getAllAccountByUserPhoneNumber(String phoneNumber) {
        return accountRepository.findAllByUser_PhoneNumber(phoneNumber);
    }
}
