package edu.miu.shoppingcartcommand.feign;

import edu.miu.shoppingcartcommand.dto.response.OrderResponseDTO;
import edu.miu.shoppingcartcommand.entity.CartItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;

/**
 * OrderFeignClient
 *
 * @author Tushig Battumur
 **/

@FeignClient(name = "ORDER-SERVICE")
public interface OrderFeignClient {

    @RequestMapping(value = "", method = RequestMethod.POST)
    OrderResponseDTO createOrder(@RequestBody HashMap<String, List<CartItem>> items);

}
