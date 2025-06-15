package org.icet.upnest.dto.feed;

import lombok.*;
import org.icet.upnest.dto.EntrepreneurDTO;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class PostDTO {

//    @NotBlank(message = "can not be null ")
    private Integer id;

//    @NotBlank(message = "can not be null ")
    private String title;

//    @NotBlank(message = "can not be null ")
    private String mediaURL;

//    @NotBlank(message = "can not be null ")
    private LocalDate createAt;

//    @NotBlank(message = "can not be null ")
    private LocalDate updateAt;

//    @NotBlank(message = "can not be null ")
    private String category;

    private Integer tagIds;

//    @NotBlank(message = "can not be null")
    private boolean isPrivate;

    private EntrepreneurDTO authorId;

}
