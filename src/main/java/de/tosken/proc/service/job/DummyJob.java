package de.tosken.proc.service.job;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DummyJob implements Runnable, JobInfo {

    private AtomicInteger progress = new AtomicInteger(0);

    private AtomicBoolean done = new AtomicBoolean(false);

    private String name;

    @Override
    public int getProgress() {
        return progress.get();
    }

    @Override
    public boolean isComplete() {
        return done.get();
    }

    @Override
    public String getName() {
        return name;
    }

    @SneakyThrows
    @Override
    public void run() {
        name = Thread.currentThread().getName();

        final int steps = RandomUtils.nextInt(5, 60);
        final long sleepTime = RandomUtils.nextLong(200, 3000);

        for (int i = 1; i <= steps; i++) {
            progress.set((int) (((double) i / steps) * 100.0));
            System.out.println("Processing in " + Thread.currentThread().getName() + ": " + i + " / " + steps);
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        }

        done.set(true);
    }
}
