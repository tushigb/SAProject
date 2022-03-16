package edu.miu.customer.serviceImpl;

import edu.miu.customer.dto.request.CustomerDTO;
import edu.miu.customer.entity.Customer;
import edu.miu.customer.exception.BusinessException;
import edu.miu.customer.repository.CustomerRepository;
import edu.miu.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CustomerServiceImpl
 *
 * @author Tushig Battumur
 **/

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    public Customer add(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.fill(customerDTO);
        repository.save(customer);
        return customer;
    }

    public void remove(String customerId) {
        repository.deleteById(customerId);
    }

    public Customer get(String customerId) throws BusinessException {
        return repository.findById(customerId).orElseThrow(() -> new BusinessException("Customer not found"));
    }

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public Customer update(String customerId, CustomerDTO customerDTO) throws BusinessException {
        Customer customer = repository.findById(customerId).orElseThrow(() -> new BusinessException("Customer not found"));
        customer.fill(customerDTO);
        repository.save(customer);
        return customer;
    }

}
