package edu.miu.order.feign;

import edu.miu.order.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * CustomerFeignClient
 *
 * @author Tushig Battumur
 **/

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerFeignClient {

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    Customer getCustomer(@PathVariable("customerId") String customerId);

    @RequestMapping(value = "email/send/{customerId}/{orderId}", method = RequestMethod.GET)
    void sendEmail(@PathVariable("customerId") String customerId, @PathVariable("orderId") String orderId);

}
