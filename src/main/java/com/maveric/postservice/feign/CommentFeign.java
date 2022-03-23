package com.maveric.postservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="comment",fallbackFactory = HystrixFallBackFactory.class)
public interface CommentFeign {

    @GetMapping("/api/v1/posts/{postId}/comments/count")
    public ResponseEntity<Integer>  getCommentsCount(@PathVariable ("postId") String postId);


}
