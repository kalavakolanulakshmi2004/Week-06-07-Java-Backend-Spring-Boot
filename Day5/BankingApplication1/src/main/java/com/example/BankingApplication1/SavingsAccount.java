package com.example.BankingApplication1;
import jakarta.persistence.Entity;

@Entity
public class SavingsAccount extends Account {

    public SavingsAccount() {}

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if(amount <= balance) balance -= amount;
        else System.out.println("Insufficient balance");
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void showAccountType() {
        System.out.println("Savings Account");
    }
}
