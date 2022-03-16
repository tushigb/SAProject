package edu.miu.shoppingcart.repository;

import edu.miu.shoppingcart.entity.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * CartRepository
 *
 * @author Tushig Battumur
 **/

public interface CartRepository extends MongoRepository<ShoppingCart, String> {
}
