package de.tosken.proc.service.job;

public interface JobInfo {
    int getProgress();

    boolean isComplete();

    String getName();
}
