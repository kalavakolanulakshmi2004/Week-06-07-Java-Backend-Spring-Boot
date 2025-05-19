package com.example.BankingApplication1;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected String bankName;
    protected String branchName;

    public static final String BANK_CODE_PREFIX = "BANK-";

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected List<Account> accounts = new ArrayList<>();

    protected static int bankCounter = 1;

    public Bank() {}

    public Bank(String bankName, String branchName) {
        this.bankName = bankName;
        this.branchName = branchName;
    }

    public abstract void openAccount(Account account);

    public abstract void displayBankInfo();

    public String generateBankCode() {
        return BANK_CODE_PREFIX + String.format("%03d", bankCounter++);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public static int getBankCounter() {
        return bankCounter;
    }

    public static void setBankCounter(int bankCounter) {
        Bank.bankCounter = bankCounter;
    }

    // Getters and setters
    // ...
}
