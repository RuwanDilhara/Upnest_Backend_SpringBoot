package org.icet.upnest.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.upnest.dto.Job;
import org.icet.upnest.entity.JobEntity;
import org.icet.upnest.repository.JobRepository;
import org.icet.upnest.service.JobService;
import org.icet.upnest.util.enums.JobType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    final JobRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Job> getAll() {
        return repository.findAll().stream().map(jobEntity ->
                mapper.map(jobEntity,Job.class)).toList();
    }

    @Override
    public Job getJobById(Integer id) {
        return mapper.map(repository.findById(id).orElse(null), Job.class);
    }

    @Override
    public Job save(Job job) {
        return mapper.map(repository.save(
                mapper.map(job, JobEntity.class)), Job.class);
    }

    @Override
    public Job update(Job job) {
        return mapper.map(repository.save(
                mapper.map(job, JobEntity.class)), Job.class);
    }

    @Override
    public Boolean delete(Integer id) {
        return repository.findById(id).map(jobEntity -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public List<Job> getJobsByType(JobType type) {
        return repository.findByJobType(type).stream().map(jobEntity ->
                mapper.map(jobEntity, Job.class)).toList();
    }

    @Override
    public List<Job> getJobsByUserId(Integer id) {
        return repository.findAll().stream().filter(jobEntity -> jobEntity.getUserId().equals(id)).map(jobEntity ->
                mapper.map(jobEntity, Job.class)).toList();
    }
}
