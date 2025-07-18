package com.example.loanapp.dto.response;

import com.example.loanapp.enums.LoanStatus;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class LoanApplicationResponse {
    private Long id;
    private String customerName;
    private Double amount;
    private LoanStatus status;
    private LocalDateTime creationDate;
}