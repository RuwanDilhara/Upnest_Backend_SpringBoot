package org.icet.upnest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Post {

    @NotBlank(message = "can not be null ")
    private Integer id;

    @NotBlank(message = "can not be null ")
    private String title;

    @NotBlank(message = "can not be null ")
    private String mediaURL;

    @NotBlank(message = "can not be null ")
    private LocalDate createAt;

    @NotBlank(message = "can not be null ")
    private String category;

    @NotBlank(message = "can not be null")
    private boolean isPrivate;

}
