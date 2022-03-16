package edu.miu.order.repository;

import edu.miu.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * OrderRepository
 *
 * @author Tushig Battumur
 **/

public interface OrderRepository  extends MongoRepository<Order, String> {
}
