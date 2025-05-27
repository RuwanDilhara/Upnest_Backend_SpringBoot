package org.icet.upnest.repository.feed;

import org.icet.upnest.dto.Post;
import org.icet.upnest.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<PostEntity ,Integer> {
//    List<PostEntity> findByUserId(Integer userId);

    List<PostEntity> findByCreateAt(LocalDate date);
}