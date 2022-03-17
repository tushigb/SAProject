package edu.miu.customer.service;

import edu.miu.customer.exception.BusinessException;

/**
 * EmailService
 *
 * @author Tushig Battumur
 **/

public interface EmailService {

    void sendEmail(String customerId, String orderId) throws BusinessException;

}
