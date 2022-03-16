package edu.miu.shoppingcartquery.entity;

import lombok.*;

/**
 * CartItem
 *
 * @author Tushig Battumur
 **/

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    private Product product;

    private int quantity;

}
