package com.maveric.postservice.dto;

import com.maveric.postservice.model.Comment;
import com.maveric.postservice.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
      private String postId;
    private String post;
    private UserResponse postedBy;
    private Integer likesCount;
    private Integer commentsCount;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
