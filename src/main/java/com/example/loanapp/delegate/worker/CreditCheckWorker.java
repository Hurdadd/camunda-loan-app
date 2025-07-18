package com.example.loanapp.delegate.worker;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.Random;

@Component
@ExternalTaskSubscription("credit-check")
@Slf4j
public class CreditCheckWorker implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        log.info("WORKER: Executing Credit Check for processInstanceId={}", externalTask.getProcessInstanceId());

        Long applicationId = externalTask.getVariable("applicationId");
        log.info("WORKER: Checking credit for applicationId: {}", applicationId);

        try {
            log.info("WORKER: Calling external credit bureau... this might take a few seconds.");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        int creditScore = new Random().nextInt(300, 850);
        log.info("WORKER: Credit score received: {}", creditScore);


        Map<String, Object> results = Map.of("creditScore", creditScore);


        externalTaskService.complete(externalTask, results);

        log.info("WORKER: Credit Check task completed successfully.");
    }
}