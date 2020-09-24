package de.tosken.proc.view;

import de.tosken.proc.data.model.User;
import de.tosken.proc.service.HueService;
import de.tosken.proc.service.JobService;
import de.tosken.proc.service.UserService;
import de.tosken.proc.service.job.DummyJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(scopeName = "session")
public class IndexPage {

    private final HueService hueService;

    private final JobService jobService;

    private final UserService userService;

    private final List<DummyJob> jobs = new ArrayList<>();

    @Autowired
    public IndexPage(HueService hueService, JobService jobService, UserService userService) {
        this.hueService = hueService;
        this.jobService = jobService;
        this.userService = userService;
    }

    public void onInit() {
        final List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);
    }

    public void addJob() {
        final DummyJob job = new DummyJob();
        jobs.add(job);

        jobService.submitJob(job);
    }


    public List<DummyJob> getJobs() {
        return jobs;
    }
}
