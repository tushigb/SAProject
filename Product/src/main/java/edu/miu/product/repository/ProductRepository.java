package edu.miu.product.repository;

import edu.miu.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ProductRepository
 *
 * @author Tushig Battumur
 **/

public interface ProductRepository extends MongoRepository<Product, String> {
}
