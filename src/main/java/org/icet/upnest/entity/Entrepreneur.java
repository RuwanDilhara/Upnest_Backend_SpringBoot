package org.icet.upnest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.icet.upnest.entity.feed.Post;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Entrepreneurs")
public class Entrepreneur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;
    private String email;
    private String phoneNumber;
    private String profilePictureURL;
    private String bio;
    private String industry;
    private Integer experienceYears;
    private List<String> skills;
    private List<Entrepreneur> followers;
    private List<Entrepreneur> following;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private boolean isActive;
    private boolean isVerified;
    private String location;
    private List<String> interests;

    @OneToMany(mappedBy = "author" ,cascade = CascadeType.ALL)
    private List<Post> postDTOList;
}
