package edu.miu.shoppingcartquery.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart
 *
 * @author Tushig Battumur
 **/

@Document("carts")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    @Id
    private String id;

    private List<CartItem> items = new ArrayList<>();

}
