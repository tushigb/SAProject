package edu.miu.customer.serviceImpl;

import edu.miu.customer.entity.Customer;
import edu.miu.customer.exception.BusinessException;
import edu.miu.customer.service.CustomerService;
import edu.miu.customer.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmailServiceImpl
 *
 * @author Tushig Battumur
 **/

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    CustomerService service;

    public void sendEmail(String customerId, String orderId) throws BusinessException {
        Customer customer = service.get(customerId);
        System.out.println("Your order is confirmed. Order id: " + orderId);
    }

}
