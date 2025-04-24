package org.icet.upnest.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    private Integer id;

    @NotBlank(message = "cant not be null ")
    private String title;

    @NotBlank(message = "cant not be null ")
    private String mediaURL;

    @NotBlank(message = "cant not be null ")
    private LocalDate createAt;

    private User user;
}
