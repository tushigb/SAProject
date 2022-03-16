package edu.miu.shoppingcartcommand.entity;

import edu.miu.shoppingcartcommand.dto.request.AddProductDTO;
import edu.miu.shoppingcartcommand.model.Product;
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

    public void fill(AddProductDTO productDTO) {
        setProduct(productDTO.getProduct());
        setQuantity(productDTO.getQuantity());
    }

}
