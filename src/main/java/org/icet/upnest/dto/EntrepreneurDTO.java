package org.icet.upnest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.icet.upnest.dto.feed.PostDTO;
import org.icet.upnest.entity.Entrepreneur;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EntrepreneurDTO {
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

    private List<PostDTO> postDTOList;
}