package edu.miu.shoppingcartcommand.dto.request;

import edu.miu.shoppingcartcommand.model.Product;
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
