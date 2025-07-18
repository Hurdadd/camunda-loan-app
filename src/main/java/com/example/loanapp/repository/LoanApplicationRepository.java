package com.example.loanapp.repository;


import com.example.loanapp.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication , Long> {
}
