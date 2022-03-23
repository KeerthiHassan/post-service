package com.maveric.postservice.services;

import com.maveric.postservice.dto.PostResponse;
import com.maveric.postservice.dto.UpdatePost;
import com.maveric.postservice.feign.CommentFeign;
import com.maveric.postservice.feign.LikeFeign;
import com.maveric.postservice.model.Post;
import com.maveric.postservice.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    
}
