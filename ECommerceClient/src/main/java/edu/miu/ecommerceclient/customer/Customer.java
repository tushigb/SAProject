package edu.miu.ecommerceclient.customer;

import lombok.*;

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

    private String customerId;

    private String firstname, lastname;

    private String phone, email;

    private Address address;

}
