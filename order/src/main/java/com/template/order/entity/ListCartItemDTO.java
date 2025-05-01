package com.template.order.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListCartItemDTO {
    private List<CartItemDTO> cartProducts;
    private double summaryPrice;
}
