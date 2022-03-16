package edu.miu.order.serviceImpl;

import edu.miu.order.entity.Order;
import edu.miu.order.model.Customer;
import edu.miu.order.service.EmailSenderService;
import org.springframework.stereotype.Service;

/**
 * EmailSenderServiceImpl
 *
 * @author Tushig Battumur
 **/

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    public void sendEmail(Customer customer, Order order) {
        System.out.println("Email sent to " + customer.getEmail() + ". Order: " + order);
    }

}
