package org.icet.upnest.repository;

import org.icet.upnest.dto.Post;
import org.icet.upnest.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity ,Integer> {
    List<Post> findByUserId(Integer userId);
}
