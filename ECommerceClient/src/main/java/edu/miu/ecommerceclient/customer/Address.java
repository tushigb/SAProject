package edu.miu.ecommerceclient.customer;

import lombok.*;

/**
 * Address
 *
 * @author Tushig Battumur
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    private String street, city, zip;

}
