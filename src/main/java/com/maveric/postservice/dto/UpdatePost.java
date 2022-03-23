package com.maveric.postservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePost {
    private String post;
    private String postedBy;
    private LocalDate updatedAt;
}
