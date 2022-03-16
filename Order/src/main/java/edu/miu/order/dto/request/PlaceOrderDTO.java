package edu.miu.order.dto.request;

import lombok.*;

/**
 * PlaceOrderDTO
 *
 * @author Tushig Battumur
 **/

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderDTO {

    private String customerId;

}
