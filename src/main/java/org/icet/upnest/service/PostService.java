package org.icet.upnest.service;

import org.icet.upnest.dto.Post;

import java.time.LocalDate;
import java.util.List;

public interface PostService {
    List<Post> getAll();
    Post getPostByPostId(Integer id);
//    List<Post> getPostByUserId(Integer userId);
    List<Post> getPostByCreateDate(LocalDate date);
    Post save(Post post);
    Post updatePost(Post post);
    boolean deletePostById(Integer id);
}
