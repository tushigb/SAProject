package edu.miu.shoppingcart.entity;

import edu.miu.shoppingcart.dto.request.AddProductDTO;
import edu.miu.shoppingcart.model.Product;
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
