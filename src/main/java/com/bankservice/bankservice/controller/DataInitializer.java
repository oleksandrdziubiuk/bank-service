package com.bankservice.bankservice.controller;

import com.bankservice.bankservice.model.Account;
import com.bankservice.bankservice.model.Currency;
import com.bankservice.bankservice.model.Role;
import com.bankservice.bankservice.model.User;
import com.bankservice.bankservice.service.AccountService;
import com.bankservice.bankservice.service.RoleService;
import com.bankservice.bankservice.service.UserService;
import java.time.LocalDate;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class DataInitializer {
    private final UserService userService;
    private RoleService roleService;
    private AccountService accountService;

    public DataInitializer(UserService userService, RoleService roleService,
                           AccountService accountService) {
        this.userService = userService;
        this.roleService = roleService;
        this.accountService = accountService;
    }

    @GetMapping
    public void inject() {
        Role userRole = new Role();
        userRole.setRoleName(Role.Roles.USER);
        roleService.save(userRole);

        User user = new User();
        user.setRoles(Set.of(userRole));
        user.setName("Bob");
        user.setPassword("1234");
        user.setPhoneNumber("12345678");
        LocalDate dateTime = LocalDate.of(1990, 01, 01);
        user.setDateOfBirth(dateTime);
        userService.save(user);

        Account userAccount = new Account();
        userAccount.setAccountNumber("1110111");
        userAccount.setBalance(1000D);
        userAccount.setActive(true);
        userAccount.setCurrency(Currency.UAH);
        userAccount.setUser(userService.getById(user.getId()));
        accountService.save(userAccount);
    }
}
