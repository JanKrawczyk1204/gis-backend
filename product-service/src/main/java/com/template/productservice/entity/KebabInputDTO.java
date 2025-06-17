package com.template.productservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KebabInputDTO {
    private String name;
    private float locationX;
    private float locationY;
    private float rating;
    private String hours;
    private String address;
}
