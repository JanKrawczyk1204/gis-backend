package com.template.productservice.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private String uuid;
    private String content;
    private float rating;
    private String kebabName;
    private String userLogin;
}
