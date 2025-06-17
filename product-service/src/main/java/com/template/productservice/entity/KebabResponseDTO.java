package com.template.productservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class KebabResponseDTO {
    private String name;
    private List<Float> location;
    private String hours;
    private float rating;
    private String address;
}

