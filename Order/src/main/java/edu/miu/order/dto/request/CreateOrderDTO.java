package edu.miu.order.dto.request;

import edu.miu.order.model.OrderItem;
import lombok.*;

import java.util.List;

/**
 * CreateOrderDTO
 *
 * @author Tushig Battumur
 **/

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDTO {

    private List<OrderItem> items;

}
