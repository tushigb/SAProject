package edu.miu.customer.service;

import edu.miu.customer.dto.request.CustomerDTO;
import edu.miu.customer.entity.Customer;
import edu.miu.customer.exception.BusinessException;

import java.util.List;

/**
 * CustomerService
 *
 * @author Tushig Battumur
 **/

public interface CustomerService {

    Customer add(CustomerDTO customerDTO);

    void remove(String customerId);

    Customer get(String customerId) throws BusinessException;

    List<Customer> getAll();

    Customer update(String customerId, CustomerDTO customerDTO) throws BusinessException;

}
