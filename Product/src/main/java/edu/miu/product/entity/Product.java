package edu.miu.product.entity;

import edu.miu.product.dto.request.ProductDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Product
 *
 * @author Tushig Battumur
 **/

@Document("products")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String productNumber;

    private String name, description;

    private double price;

    private int stock;

    public void fill(ProductDTO productDTO) {
        setName(productDTO.getName());
        setDescription(productDTO.getDescription());
        setPrice(productDTO.getPrice());
        setStock(productDTO.getStock());
    }

}
