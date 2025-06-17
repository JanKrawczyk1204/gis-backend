package com.template.productservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Kebab {
    private String uid;
    @Column(name = "kebab_name")
    private String name;
    private float locationX;
    private float locationY;
    private float rating;
    private String hours;
    private String address;

}
