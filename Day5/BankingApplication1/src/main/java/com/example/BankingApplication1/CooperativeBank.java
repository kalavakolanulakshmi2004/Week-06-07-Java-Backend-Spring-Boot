package com.example.BankingApplication1;
import jakarta.persistence.Entity;

@Entity
public class CooperativeBank extends Bank {

    public CooperativeBank() {}

    public CooperativeBank(String bankName, String branchName) {
        super(bankName, branchName);
    }

    @Override
    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("Account opened in Cooperative Bank");
    }

    @Override
    public void displayBankInfo() {
        System.out.println("--- Cooperative Bank Info ---");
        System.out.println("Bank: " + bankName);
        System.out.println("Branch: " + branchName);
        System.out.println("Total Accounts: " + accounts.size());
    }
}
