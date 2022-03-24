package com.maveric.postservice.feign;

import com.maveric.postservice.model.Comment;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="comment-service",fallbackFactory = HystrixFallBackFactory.class)
public interface CommentFeign {
@LoadBalanced
    @GetMapping("/posts/{postId}/comments/count")
    public ResponseEntity<Integer>  getCommentsCount(@PathVariable ("postId") String postId);


}
