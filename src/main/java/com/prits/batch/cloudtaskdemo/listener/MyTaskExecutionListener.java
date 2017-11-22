package com.prits.batch.cloudtaskdemo.listener;

import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.stereotype.Component;

@Component
public class MyTaskExecutionListener implements TaskExecutionListener {

    @Override
    public void onTaskStartup(TaskExecution taskExecution) {
        System.out.println("--------- Before Task ----------");
    }

    @Override
    public void onTaskEnd(TaskExecution taskExecution) {
        System.out.println("--------- After Task ------------");
    }

    @Override
    public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
        System.out.println("--------- Failed Task ------------");
    }
}
