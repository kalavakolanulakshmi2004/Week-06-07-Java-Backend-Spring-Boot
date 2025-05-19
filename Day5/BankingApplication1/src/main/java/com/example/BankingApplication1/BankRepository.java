package com.example.BankingApplication1;
import com.example.BankingApplication1.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
