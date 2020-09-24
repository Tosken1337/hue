package de.tosken.proc.service;

import de.tosken.proc.service.job.JobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    private final ThreadPoolTaskExecutor executor;

    @Autowired
    public JobService(ThreadPoolTaskExecutor executor) {
        this.executor = executor;
    }

    @Async
    public void submitJob(final Runnable action) {
        action.run();
    }
}
