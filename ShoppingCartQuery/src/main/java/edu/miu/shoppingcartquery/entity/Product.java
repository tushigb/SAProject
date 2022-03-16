package edu.miu.shoppingcartquery.entity;

import lombok.*;

/**
 * Product
 *
 * @author Tushig Battumur
 **/

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String productNumber;

    private String name, description;

    private double price;

}
