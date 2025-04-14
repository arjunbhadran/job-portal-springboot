package com.example.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> getAlljobs();
    Job getJobById(Long id);
    void createJob(Job job);
    String deleteJob(Long id);
    Job updateJob(Job job, Long id);
}
