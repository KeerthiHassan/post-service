package com.maveric.postservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Document(collection = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    private String postId;
    @NotEmpty(message = "Please provide Post to Upload")
    private String post;
    @NotEmpty(message = "Please provide UserId")
    private String postedBy;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
