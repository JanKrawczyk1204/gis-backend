package com.template.productservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
public class ReviewEntity extends Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private float rating;

    @OneToOne
    @JoinColumn(name = "kebab_id", unique = true)
    private KebabEntity kebab;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
