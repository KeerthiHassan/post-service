package com.maveric.postservice.controller;

import com.maveric.postservice.dto.PostResponse;
import com.maveric.postservice.dto.UpdatePost;
import com.maveric.postservice.model.Post;
import com.maveric.postservice.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostResponse> getPostDetails(@PathVariable ("postId") String postId){
        return new ResponseEntity<PostResponse> (postService.getPostDetails(postId), HttpStatus.OK);
    }


}
