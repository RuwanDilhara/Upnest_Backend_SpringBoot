package org.icet.upnest.entity;

import jakarta.persistence.*;
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
@Table(name = "jobs")
@Entity
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String jobTitle;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String projectName;

    @Column(nullable = false)
    private String salaryRange;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate createAt;

    @Column(nullable = false)
    private Integer userId;
}
