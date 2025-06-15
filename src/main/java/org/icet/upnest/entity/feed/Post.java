package org.icet.upnest.entity.feed;

import jakarta.persistence.*;
import lombok.*;
import org.icet.upnest.entity.Entrepreneur;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "posts")
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String mediaURL;

    private LocalDate createAt;

    private LocalDate updateAt;

    private String category;

    private Integer tagIds;

    private boolean isPrivate;

    private List<Like> likes;

    private List<Comments> comments;

    @ManyToOne
    @JoinColumn(name = "entrepreneur_id")
    private Entrepreneur author;


}
