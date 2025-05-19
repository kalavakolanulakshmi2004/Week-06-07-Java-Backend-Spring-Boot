package com.example.BankingApplication1;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankingController {

    private final BankingService bankingService;

    public BankingController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @PostMapping("/nationalized")
    public Bank createNationalizedBank(@RequestParam String bankName, @RequestParam String branchName) {
        return bankingService.createBank(new NationalizedBank(bankName, branchName));
    }

    @PostMapping("/cooperative")
    public Bank createCooperativeBank(@RequestParam String bankName, @RequestParam String branchName) {
        return bankingService.createBank(new CooperativeBank(bankName, branchName));
    }

    @PostMapping("/{bankId}/accounts/savings")
    public Account openSavingsAccount(@PathVariable Long bankId,
                                      @RequestParam String accountNumber,
                                      @RequestParam String holderName,
                                      @RequestParam double balance) {
        return bankingService.openAccount(bankId, new SavingsAccount(accountNumber, holderName, balance));
    }

    @PostMapping("/{bankId}/accounts/current")
    public Account openCurrentAccount(@PathVariable Long bankId,
                                      @RequestParam String accountNumber,
                                      @RequestParam String holderName,
                                      @RequestParam double balance) {
        return bankingService.openAccount(bankId, new CurrentAccount(accountNumber, holderName, balance));
    }

    @GetMapping("/{bankId}/accounts")
    public List<Account> getAllAccounts(@PathVariable Long bankId) {
        return bankingService.getAllAccounts(bankId);
    }

    @PostMapping("/accounts/{accountNumber}/deposit")
    public Account deposit(@PathVariable String accountNumber, @RequestParam double amount) {
        return bankingService.deposit(accountNumber, amount);
    }

    @PostMapping("/accounts/{accountNumber}/withdraw")
    public Account withdraw(@PathVariable String accountNumber, @RequestParam double amount) {
        return bankingService.withdraw(accountNumber, amount);
    }

    @GetMapping("/accounts/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber) {
        return bankingService.getAccountByNumber(accountNumber);
    }
}
