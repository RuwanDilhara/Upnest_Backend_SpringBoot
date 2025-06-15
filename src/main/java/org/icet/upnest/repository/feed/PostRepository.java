package org.icet.upnest.repository.feed;

import org.icet.upnest.entity.feed.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
//    List<PostEntity> findByUserId(Integer userId);

    List<Post> findByCreateAt(LocalDate date);
}