package org.icet.upnest.repository;

import org.icet.upnest.entity.JobEntity;
import org.icet.upnest.util.enums.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface JobRepository extends JpaRepository<JobEntity, Integer> {

    List<JobEntity> findByJobType(JobType type);
}