package com.maveric.postservice.services;

import com.maveric.postservice.dto.PostResponse;
import com.maveric.postservice.dto.UpdatePost;
import com.maveric.postservice.feign.CommentFeign;
import com.maveric.postservice.feign.LikeFeign;
import com.maveric.postservice.model.Post;
import com.maveric.postservice.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImplementation implements PostService{

    @Autowired
    PostRepo postRepo;
    @Autowired
    CommentFeign commentfeign;
    @Autowired
    LikeFeign likefeign;

    @Override
    public List<PostResponse> getPosts() {
        List<Post> postList=postRepo.findAll();
        List<PostResponse> postResponseList=new ArrayList<>();
        for(Post post:postList)
        {
        PostResponse postResponse=new PostResponse();
        Integer count =likefeign.getLikesCount(post.getPostId()).getBody();
        Integer counts=commentfeign.getCommentsCount(post.getPostId()).getBody();
            postResponse.setPostId(post.getPostId());
            postResponse.setPost(post.getPost());
            postResponse.setPostedBy(post.getPostedBy());
            postResponse.setLikesCount(count);
            postResponse.setCommentsCount(counts);
            postResponse.setCreatedAt(post.getCreatedAt());
            postResponse.setUpdatedAt(post.getUpdatedAt());
            postResponseList.add(postResponse);
        }
        return postResponseList;
    }



    @Override
    public PostResponse getPostDetails(String postId) {
        Post post=postRepo.findBypostId(postId);
        Integer count=likefeign.getLikesCount(postId).getBody();
        Integer counts=commentfeign.getCommentsCount(postId).getBody();
        PostResponse postResponse=new PostResponse();
        postResponse.setPostId(post.getPostId());
        postResponse.setPost(post.getPost());
        postResponse.setPostedBy(post.getPostedBy());
        postResponse.setLikesCount(count);
        postResponse.setCommentsCount(counts);
        postResponse.setCreatedAt(post.getCreatedAt());
        postResponse.setUpdatedAt(post.getUpdatedAt());
        return postResponse;
    }

    @Override
    public PostResponse createPost(Post post) {
        post.setCreatedAt(LocalDate.now());
        post.setUpdatedAt(LocalDate.now());
        Post posts=postRepo.save(post);
        PostResponse postResponse=new PostResponse();
        postResponse.setPostId(posts.getPostId());
        postResponse.setPost(posts.getPost());
        postResponse.setPostedBy(posts.getPostedBy());
        postResponse.setLikesCount(0);
        postResponse.setCommentsCount(0);
        postResponse.setCreatedAt(posts.getCreatedAt());
        postResponse.setUpdatedAt(posts.getUpdatedAt());
        return postResponse;
    }
    @Override
    public PostResponse updatePost(String postId, UpdatePost updatePost) {
        Post post=postRepo.findBypostId(postId);
        post.setUpdatedAt(LocalDate.now());
        post.setPostedBy(updatePost.getPostedBy());
        post.setPost(updatePost.getPost());
        Post posts=postRepo.save(post);
        Integer count=commentfeign.getCommentsCount(postId).getBody();
        Integer counts=commentfeign.getCommentsCount(postId).getBody();
        String s=posts.getPost();
        String s1=posts.getPostedBy();
        PostResponse postResponse=new PostResponse();
        postResponse.setPostId(posts.getPostId());
        postResponse.setPost(posts.getPost());
        postResponse.setPostedBy(posts.getPostedBy());
        postResponse.setLikesCount(count);
        postResponse.setCommentsCount(counts);
        postResponse.setCreatedAt(posts.getCreatedAt());
        postResponse.setUpdatedAt(posts.getUpdatedAt());
        return postResponse;

    }




}
