package com.template.cart.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemAddDTO {
    private String product;
    private long quantity;
}
