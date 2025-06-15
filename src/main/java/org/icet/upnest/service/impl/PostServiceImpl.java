package org.icet.upnest.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.upnest.dto.feed.PostDTO;
import org.icet.upnest.entity.feed.Post;
import org.icet.upnest.repository.feed.PostRepository;
import org.icet.upnest.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    final PostRepository postRepository;
    final ModelMapper mapper;

    @Override
    public List<PostDTO> getAll() {
        return postRepository.findAll().stream().map(post ->
                mapper.map(post, PostDTO.class)).toList();
    }

    @Override
    public PostDTO getPostByPostId(Integer id) {
        return mapper.map(postRepository.findById(id).orElse(null), PostDTO.class);
    }

//    @Override
//    public List<Post> getPostByUserId(Integer userId) {
//        return postRepository.findByUserId(userId).stream().map(postEntity ->
//                mapper.map(postEntity,Post.class)).toList();
//    }

    @Override
    public List<PostDTO> getPostByCreateDate(LocalDate date) {
        return postRepository.findByCreateAt(date).stream().map(post ->
                mapper.map(post, PostDTO.class)).toList();
    }

    @Override
    public PostDTO save(PostDTO post) {
        return  mapper.map(postRepository.save(
                mapper.map(post, Post.class)), PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO post) {
        return  mapper.map(postRepository.save(
                mapper.map(post, Post.class)), PostDTO.class);
    }

    @Override
    public boolean deletePostById(Integer id) {
        postRepository.deleteById(id);
        return getPostByPostId(id)==null;
    }
}
