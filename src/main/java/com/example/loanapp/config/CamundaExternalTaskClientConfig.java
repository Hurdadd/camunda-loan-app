package com.example.loanapp.config;

import org.camunda.bpm.client.ExternalTaskClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaExternalTaskClientConfig {

    @Value("${camunda.bpm.client.base-url:http://localhost:8080/engine-rest}")
    private String baseUrl;

    @Value("${camunda.bpm.client.async-response-timeout:10000}")
    private Long asyncResponseTimeout;

    @Value("${camunda.bpm.client.lock-duration:10000}")
    private Long lockDuration;

    @Value("${camunda.bpm.client.worker-id:credit-check}")
    private String workerId;

    @Bean
    public ExternalTaskClient externalTaskClient() {
        return ExternalTaskClient.create()
                .baseUrl(baseUrl)
                .asyncResponseTimeout(asyncResponseTimeout)
                .lockDuration(lockDuration)
                .workerId(workerId)
                .build();
    }
}


