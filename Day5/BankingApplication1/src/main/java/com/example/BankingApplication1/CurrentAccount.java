package com.example.BankingApplication1;
import jakarta.persistence.Entity;

@Entity
public class CurrentAccount extends Account {

    public CurrentAccount() {}

    public CurrentAccount(String accountNumber, String holderName, double balance) {
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
        System.out.println("Current Account");
    }
}
