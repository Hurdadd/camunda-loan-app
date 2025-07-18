package com.example.loanapp.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class LoanApplicationRequest {
    private String customerName;
    private Double amount;
}