package edu.miu.ecommerceclient.cart;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart
 *
 * @author Tushig Battumur
 **/

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    private String id;

    private List<CartItem> items = new ArrayList<>();

}
