package com.example.loanapp.service.impl;

import com.example.loanapp.dto.request.LoanApplicationRequest;
import com.example.loanapp.dto.response.LoanApplicationResponse;
import com.example.loanapp.enums.LoanStatus;
import com.example.loanapp.mapper.LoanApplicationMapper;
import com.example.loanapp.model.LoanApplication;
import com.example.loanapp.repository.LoanApplicationRepository;
import com.example.loanapp.service.LoanApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class LoanApplicationServiceImpl implements LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;
    private final LoanApplicationMapper loanApplicationMapper;

    @Transactional
    @Override
    public LoanApplicationResponse createNewApplication(LoanApplicationRequest request) {
        LoanApplication loanApplication = loanApplicationMapper.toEntity(request);
        loanApplication.setStatus(LoanStatus.PENDING);
        LoanApplication savedLoanApplication = loanApplicationRepository.save(loanApplication);

        return loanApplicationMapper.toDto(savedLoanApplication);
    }
}
