package com.example.BankingApplication1;
import com.example.BankingApplication1.Account;
import com.example.BankingApplication1.Bank;
import com.example.BankingApplication1.AccountRepository;
import com.example.BankingApplication1.BankRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankingService {

    private final BankRepository bankRepository;
    private final AccountRepository accountRepository;

    public BankingService(BankRepository bankRepository, AccountRepository accountRepository) {
        this.bankRepository = bankRepository;
        this.accountRepository = accountRepository;
    }

    public Bank createBank(Bank bank) {
        return bankRepository.save(bank);
    }

    public Account openAccount(Long bankId, Account account) {
        Optional<Bank> bankOpt = bankRepository.findById(bankId);
        if(bankOpt.isPresent()) {
            Bank bank = bankOpt.get();
            bank.openAccount(account);
            accountRepository.save(account);
            bankRepository.save(bank);
            return account;
        }
        return null;
    }

    public List<Account> getAllAccounts(Long bankId) {
        Optional<Bank> bankOpt = bankRepository.findById(bankId);
        return bankOpt.map(Bank::getAccounts).orElse(null);
    }

    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber).orElse(null);
    }

    public Account deposit(String accountNumber, double amount) {
        Account account = getAccountByNumber(accountNumber);
        if (account != null) {
            account.deposit(amount);
            return accountRepository.save(account);
        }
        return null;
    }

    public Account withdraw(String accountNumber, double amount) {
        Account account = getAccountByNumber(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            return accountRepository.save(account);
        }
        return null;
    }
}
