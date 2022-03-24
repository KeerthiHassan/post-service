package com.maveric.postservice.controller;

import com.maveric.postservice.dto.PostResponse;
import com.maveric.postservice.dto.Postdto;
import com.maveric.postservice.model.Post;
import com.maveric.postservice.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponse>> getPosts(){
        return new ResponseEntity<List<PostResponse>> (postService.getPosts(), HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<PostResponse> createPost(@Valid  @RequestBody Postdto postdto){
        return new ResponseEntity<PostResponse>(postService.createPost(postdto),HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostResponse> getPostDetails(@PathVariable ("postId") String postId){
        return new ResponseEntity<PostResponse> (postService.getPostDetails(postId), HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable ("postId") String postId,@Valid @RequestBody Postdto updatePost){
        return new ResponseEntity<PostResponse>(postService.updatePost(postId,updatePost),HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable ("postId") String postId){
        return new ResponseEntity<String>(postService.deletePost(postId),HttpStatus.OK);
    }
}
