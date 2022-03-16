package edu.miu.order.entity;

import edu.miu.order.model.OrderItem;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Order
 *
 * @author Tushig Battumur
 **/

@Document("orders")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private String id;

    private String customerId;

    private List<OrderItem> items;

    private String status;

}
