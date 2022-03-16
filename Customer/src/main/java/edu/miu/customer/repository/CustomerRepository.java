package edu.miu.customer.repository;

import edu.miu.customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * CustomerRepository
 *
 * @author Tushig Battumur
 **/

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
