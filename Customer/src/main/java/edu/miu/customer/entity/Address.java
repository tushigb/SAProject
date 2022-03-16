package edu.miu.customer.entity;

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
