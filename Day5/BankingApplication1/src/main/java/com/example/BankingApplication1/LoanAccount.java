package com.example.BankingApplication1;
import jakarta.persistence.Entity;

@Entity
public class LoanAccount extends Account {

    public LoanAccount() {}

    public LoanAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void deposit(double amount) {
        this.balance -= amount; // Paying loan reduces balance (debt)
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdraw not allowed on loan accounts");
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void showAccountType() {
        System.out.println("Loan Account");
    }
}
