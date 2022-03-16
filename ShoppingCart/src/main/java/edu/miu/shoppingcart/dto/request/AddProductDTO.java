package edu.miu.shoppingcart.dto.request;

import edu.miu.shoppingcart.model.Product;
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
