package edu.miu.shoppingcartcommand.dto.response;

import edu.miu.shoppingcartcommand.entity.CartItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * OrderResponseDTO
 *
 * @author Tushig Battumur
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderResponseDTO {

    private String id;

    private String customerId;

    private String status;

    private List<CartItem> items;

}
