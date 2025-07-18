package com.example.loanapp;

import org.camunda.bpm.engine.ProcessEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WorkflowTest {

    @Autowired
    private ProcessEngine processEngine;

    @Test
    void contextLoads() {
        System.out.println("Process Engine found in test context: " + processEngine.getName());
        assertThat(processEngine).isNotNull();
    }
}