package com.maveric.postservice.repo;

import com.maveric.postservice.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepo extends MongoRepository<Post,String> {
    Post findBypostId(String postId);
}
