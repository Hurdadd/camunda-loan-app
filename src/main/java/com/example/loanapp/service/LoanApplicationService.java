package com.example.loanapp.service;

import com.example.loanapp.dto.request.LoanApplicationRequest;
import com.example.loanapp.dto.response.LoanApplicationResponse;

public interface LoanApplicationService {
    LoanApplicationResponse createNewApplication(LoanApplicationRequest request);
}