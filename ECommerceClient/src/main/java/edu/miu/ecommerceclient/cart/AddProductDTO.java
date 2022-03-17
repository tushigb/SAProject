package edu.miu.ecommerceclient.cart;

import lombok.*;

/**
 * AddProductDTO
 *
 * @author Tushig Battumur
 **/

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddProductDTO {

    private Product product;

    private int quantity;

}
