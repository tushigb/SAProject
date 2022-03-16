package edu.miu.order.service;

import edu.miu.order.entity.Order;
import edu.miu.order.model.Customer;

/**
 * EmailSenderService
 *
 * @author Tushig Battumur
 **/

public interface EmailSenderService {

    void sendEmail(Customer customer, Order order);

}
