package edu.miu.ecommerceclient.order;

import lombok.*;

import java.util.List;

/**
 * Order
 *
 * @author Tushig Battumur
 **/

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;

    private String customerId;

    private List<OrderItem> items;

    private String status;

}
