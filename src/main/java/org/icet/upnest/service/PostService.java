package org.icet.upnest.service;

import org.icet.upnest.dto.feed.PostDTO;

import java.time.LocalDate;
import java.util.List;

public interface PostService {
    List<PostDTO> getAll();
    PostDTO getPostByPostId(Integer id);
//    List<Post> getPostByUserId(Integer userId);
    List<PostDTO> getPostByCreateDate(LocalDate date);
    PostDTO save(PostDTO post);
    PostDTO updatePost(PostDTO post);
    boolean deletePostById(Integer id);
}
