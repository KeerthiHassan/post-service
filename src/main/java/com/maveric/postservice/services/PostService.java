package com.maveric.postservice.services;

import com.maveric.postservice.dto.PostResponse;
import com.maveric.postservice.dto.UpdatePost;
import com.maveric.postservice.model.Post;

import java.util.List;

public interface PostService {
    List<PostResponse> getPosts();
    PostResponse createPost(Post post);
    PostResponse updatePost(String postId,UpdatePost updatePost);
    PostResponse getPostDetails(String postId);
    String deletePost(String postId);
}
