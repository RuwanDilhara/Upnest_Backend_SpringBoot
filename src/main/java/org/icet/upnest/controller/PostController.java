package org.icet.upnest.controller;

import lombok.RequiredArgsConstructor;
import org.icet.upnest.dto.feed.PostDTO;
import org.icet.upnest.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("api/v1/feed/posts")
public class PostController {

    final PostService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> postList = service.getAll();
        if (postList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(postList);
    }

    @GetMapping("/getPostById/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer id) {
        PostDTO post = service.getPostByPostId(id);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/getPostByDate")
    public ResponseEntity<List<PostDTO>> getPostsByCreateDate(@RequestParam LocalDate date) {
        List<PostDTO> postList = service.getPostByCreateDate(date);
        if (postList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

//    @GetMapping("/getPostByUserId/{id}")
//    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Integer id) {
//        List<Post> postList = service.getPostByUserId(id);
//        if (postList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(postList, HttpStatus.OK);
//    }

    @PostMapping("/save")
    public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO post) {
        PostDTO savePost = service.save(post);
        if (savePost != null) {
            return new ResponseEntity<>(savePost, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Integer id, @RequestBody PostDTO post) {
        PostDTO existingPost = service.getPostByPostId(id);
        if (existingPost != null) {
            PostDTO updated =  service.updatePost(post);
            return new ResponseEntity<>(updated,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable Integer id) {
        PostDTO existingPost = service.getPostByPostId(id);
        if (existingPost != null) {
            boolean b = service.deletePostById(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}