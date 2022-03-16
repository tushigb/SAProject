package edu.miu.order.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Customer
 *
 * @author Tushig Battumur
 **/

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private String customerId;

    private String firstname, lastname;

    private String phone, email;

}
