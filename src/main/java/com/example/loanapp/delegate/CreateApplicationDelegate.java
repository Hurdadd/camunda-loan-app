package com.example.loanapp.delegate;



import com.example.loanapp.dto.request.LoanApplicationRequest;
import com.example.loanapp.dto.response.LoanApplicationResponse;
import com.example.loanapp.service.LoanApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("createApplicationDelegate")
@RequiredArgsConstructor
@Slf4j
public class CreateApplicationDelegate implements JavaDelegate {

    private final LoanApplicationService loanApplicationService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("DELEGATE: Executing Create Application Delegate for processInstanceId={}", execution.getProcessInstanceId());

        String customerName = (String) execution.getVariable("customerName");
        Double amount = (Double) execution.getVariable("amount");

        LoanApplicationRequest request = new LoanApplicationRequest();
        request.setCustomerName(customerName);
        request.setAmount(amount);

        LoanApplicationResponse response = loanApplicationService.createNewApplication(request);

        execution.setVariable("applicationId", response.getId());
        execution.setVariable("applicationStatus", response.getStatus());

        log.info("DELEGATE: Loan application created with ID: {}", response.getId());
    }
}