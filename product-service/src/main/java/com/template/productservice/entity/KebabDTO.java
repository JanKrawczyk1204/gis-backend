package com.template.productservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class KebabDTO {
    private String uid;
    private String name;
    private float locationX;
    private float locationY;
    private float rating;
    private String hours;
    private String address;
}
