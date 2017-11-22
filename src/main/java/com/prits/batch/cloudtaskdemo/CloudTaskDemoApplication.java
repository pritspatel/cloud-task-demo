package com.prits.batch.cloudtaskdemo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
@EnableBatchProcessing
public class CloudTaskDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudTaskDemoApplication.class, args);
	}


}
