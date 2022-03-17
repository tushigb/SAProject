package edu.miu.ecommerceclient.product;

import lombok.*;

/**
 * ProductDTO
 *
 * @author Tushig Battumur
 **/

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name, description;

    private double price;

    private int stock;

}
