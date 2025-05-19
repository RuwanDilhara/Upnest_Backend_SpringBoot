package org.icet.upnest.controller;

import lombok.RequiredArgsConstructor;
import org.icet.upnest.dto.Job;
import org.icet.upnest.service.JobService;
import org.icet.upnest.util.enums.JobType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/v1/job-market/jobs")
public class JobController {

    final JobService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/getJobById/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getJobById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Job> saveJob(@RequestBody Job job) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(job));
    }

    @PutMapping("/update")
    public ResponseEntity<Job> updateJob(@RequestBody Job job) {
        return ResponseEntity.ok(service.update(job));
    }

    @DeleteMapping("/deleteJobById{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Integer id) {
        return Boolean.TRUE.equals(service.delete(id)) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/getJobsByJobType/{type}")
    public ResponseEntity<List<Job>> getJobsByType(@PathVariable JobType type) {
        return ResponseEntity.ok(service.getJobsByType(type));
    }

    @GetMapping("/getJobsByUser/{id}")
    public ResponseEntity<List<Job>> getJobsByUser(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getJobsByUserId(id));
    }
}