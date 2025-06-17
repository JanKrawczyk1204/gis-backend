package com.template.productservice.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private String uuid;
    private String content;
    private float rating;
}
