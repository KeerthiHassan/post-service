package com.maveric.postservice.services;

import com.maveric.postservice.dto.PostResponse;
import com.maveric.postservice.dto.Postdto;
import com.maveric.postservice.model.Post;

import java.util.List;

public interface PostService {
    List<PostResponse> getPosts();
    PostResponse createPost(Postdto postdto);
    PostResponse getPostDetails(String postId);
    PostResponse updatePost(String postId,Postdto updatePost);
    String deletePost(String postId);

}
