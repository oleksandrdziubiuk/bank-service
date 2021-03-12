package com.bankservice.bankservice.service;

import com.bankservice.bankservice.model.Account;
import java.util.List;

public interface AccountService {
    Account save(Account account);

    Account findAccountByAccountNumber(String accountNumber);

    List<Account> getAllAccountByUserPhoneNumber(String phoneNumber);
}
