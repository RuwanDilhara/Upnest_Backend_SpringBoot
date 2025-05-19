package org.icet.upnest.service;

import org.icet.upnest.dto.Job;
import org.icet.upnest.util.enums.JobType;

import java.util.List;

public interface JobService {
    List<Job> getAll();
    Job getJobById(Integer id);
    Job save(Job job);
    Job update(Job job);
    Boolean delete(Integer id);
    List<Job> getJobsByType(JobType type);
    List<Job> getJobsByUserId(Integer id);
}