package com.maveric.postservice.feign;

import org.springframework.cloud.openfeign.FallbackFactory;

public class HystrixFallBackFactory implements FallbackFactory<CommentFeign> {
    @Override
    public CommentFeign create(Throwable cause) {

        return null;

    }
}
