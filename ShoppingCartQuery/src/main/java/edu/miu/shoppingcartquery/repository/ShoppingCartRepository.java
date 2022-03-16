package edu.miu.shoppingcartquery.repository;

import edu.miu.shoppingcartquery.entity.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ShoppingCartRepository
 *
 * @author Tushig Battumur
 **/

public interface ShoppingCartRepository  extends MongoRepository<ShoppingCart, String> {
}
