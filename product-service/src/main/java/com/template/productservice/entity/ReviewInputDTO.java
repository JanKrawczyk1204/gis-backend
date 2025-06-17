package com.template.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewInputDTO {
    private String content;
    private float rating;
    private String kebabUid;
    private String userUuid;
}

