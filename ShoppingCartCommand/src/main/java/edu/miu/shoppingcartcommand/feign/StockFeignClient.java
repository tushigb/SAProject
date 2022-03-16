package edu.miu.shoppingcartcommand.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

/**
 * StockFeignClient
 *
 * @author Tushig Battumur
 **/

@FeignClient(name = "PRODUCT-SERVICE")
public interface StockFeignClient {

    @RequestMapping(value = "check/{productNumber}/{quantity}", method = RequestMethod.GET)
    HashMap<String, Boolean> isEnough(@PathVariable("productNumber") String productNumber, @PathVariable int quantity);

}
