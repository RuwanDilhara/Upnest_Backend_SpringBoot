package org.icet.upnest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.icet.upnest.util.enums.JobType;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Job {
    private Integer id;
    private String jobTitle;
    private JobType jobType;
    private String location;
    private String projectName;
    private String salaryRange;
    private String description;
    private LocalDate createAt;
    private Integer userId;

}