package edu.miu.shoppingcartcommand.repository;

import edu.miu.shoppingcartcommand.entity.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * CartRepository
 *
 * @author Tushig Battumur
 **/

public interface CartRepository extends MongoRepository<ShoppingCart, String> {
}
