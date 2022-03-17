package edu.miu.ecommerceclient.order;

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
public class OrderItem {

    private Product product;

    private int quantity;

}
