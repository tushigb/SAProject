package edu.miu.shoppingcartcommand.entity;

import edu.miu.shoppingcartcommand.dto.request.AddProductDTO;
import edu.miu.shoppingcartcommand.exception.BusinessException;
import edu.miu.shoppingcartcommand.model.Product;
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

    public void addProduct(AddProductDTO productDTO) throws BusinessException {
        for (CartItem item : items)
            if (item.getProduct().getProductNumber().equals(productDTO.getProduct().getProductNumber()))
                throw new BusinessException("This product already in cart items");

        CartItem item = new CartItem();
        item.fill(productDTO);
        items.add(item);
    }

}
