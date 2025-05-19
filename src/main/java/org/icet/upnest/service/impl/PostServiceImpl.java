package org.icet.upnest.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.upnest.dto.Post;
import org.icet.upnest.entity.PostEntity;
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
    public List<Post> getAll() {
        return postRepository.findAll().stream().map(postEntity ->
                mapper.map(postEntity, Post.class)).toList();
    }

    @Override
    public Post getPostByPostId(Integer id) {
        return mapper.map(postRepository.findById(id).orElse(null), Post.class);
    }

    @Override
    public List<Post> getPostByUserId(Integer userId) {
        return postRepository.findByUserId(userId).stream().map(postEntity ->
                mapper.map(postEntity,Post.class)).toList();
    }

    @Override
    public List<Post> getPostByCreateDate(LocalDate date) {
        return postRepository.findByCreateAt(date).stream().map(postEntity ->
                mapper.map(postEntity,Post.class)).toList();
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
    public boolean deletePostById(Integer id) {
        postRepository.deleteById(id);
        return getPostByPostId(id)==null;
    }
}
