package edu.miu.order.service;

import edu.miu.order.dto.request.CreateOrderDTO;
import edu.miu.order.dto.request.PlaceOrderDTO;
import edu.miu.order.entity.Order;
import edu.miu.order.exception.BusinessException;

/**
 * OrderService
 *
 * @author Tushig Battumur
 **/

public interface OrderService {

    Order create(CreateOrderDTO orderDTO);

    Order place(String id, PlaceOrderDTO placeOrderDTO) throws BusinessException;

}
