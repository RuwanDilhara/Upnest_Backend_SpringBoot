package org.icet.upnest.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.upnest.dto.Post;
import org.icet.upnest.entity.PostEntity;
import org.icet.upnest.repository.PostRepository;
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
    public List<Post> getAll() {
        return postRepository.findAll().stream().map(postEntity ->
                mapper.map(postEntity, Post.class)).toList();
    }

    @Override
    public Post getPostByPostId(Integer id) {
        return mapper.map(postRepository.findById(id), Post.class);
    }

    @Override
    public List<Post> getPostByUserId(Integer userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public List<Post> getPostByCreateDate(LocalDate date) {
        return List.of();
    }

    @Override
    public Post save(Post post) {
        return  mapper.map(postRepository.save(
                mapper.map(post, PostEntity.class)), Post.class);
    }

    @Override
    public Post updatePost(Post post) {
        return  mapper.map(postRepository.save(
                mapper.map(post, PostEntity.class)), Post.class);
    }

    @Override
    public void deletePostById(Integer id) {
        postRepository.deleteById(id);
    }
}
