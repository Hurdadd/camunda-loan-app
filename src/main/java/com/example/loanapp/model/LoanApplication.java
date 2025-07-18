package com.example.loanapp.model;


import com.example.loanapp.enums.LoanStatus;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loan-applications")
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private Double amount;

    private String processInstanceId;
    private LocalDateTime creationDate;
    @PrePersist
    protected void onCreate() {
         creationDate=LocalDateTime.now();
    }


}
