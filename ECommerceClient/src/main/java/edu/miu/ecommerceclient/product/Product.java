package edu.miu.ecommerceclient.product;

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

    private int stock;

}
