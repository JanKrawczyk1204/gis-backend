package com.template.productservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid;

    @Column(name = "kebab_name", nullable = false)
    private String kebabName;

    @Column(name = "user_login", nullable = false)
    private String userLogin;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private float rating;
}
