package org.icet.upnest.controller;

import lombok.RequiredArgsConstructor;
import org.icet.upnest.dto.Post;
import org.icet.upnest.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("api/v1/posts")
public class PostController {

    final PostService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> postList = service.getAll();
        if (postList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping("/getPostById/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        Post post = service.getPostByPostId(id);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/getPostByDate")
    public ResponseEntity<List<Post>> getPostsByCreateDate(@RequestParam LocalDate date) {
        List<Post> postList = service.getPostByCreateDate(date);
        if (postList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping("/getPostByUserId/{id}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Integer id) {
        List<Post> postList = service.getPostByUserId(id);
        if (postList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @PostMapping("/post/save")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        Post savePost = service.save(post);
        if (savePost != null) {
            return new ResponseEntity<>(savePost, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/post/updateById/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody Post post) {
        Post existingPost = service.getPostByPostId(id);
        if (existingPost != null) {
            Post updated =  service.updatePost(post);
            return new ResponseEntity<>(updated,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/post/deleteById/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable Integer id) {
        Post existingPost = service.getPostByPostId(id);
        if (existingPost != null) {
            service.deletePostById(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}
