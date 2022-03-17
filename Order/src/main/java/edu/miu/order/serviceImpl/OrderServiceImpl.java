package edu.miu.order.serviceImpl;

import edu.miu.order.constant.OrderStatus;
import edu.miu.order.dto.request.CreateOrderDTO;
import edu.miu.order.dto.request.PlaceOrderDTO;
import edu.miu.order.entity.Order;
import edu.miu.order.exception.BusinessException;
import edu.miu.order.feign.CustomerFeignClient;
import edu.miu.order.feign.StockFeignClient;
import edu.miu.order.repository.OrderRepository;
import edu.miu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * OrderServiceImpl
 *
 * @author Tushig Battumur
 **/

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;

    @Autowired
    StockFeignClient stockFeignClient;

    @Autowired
    CustomerFeignClient customerFeignClient;

    public Order create(CreateOrderDTO orderDTO) {
        Order order = new Order();
        order.setItems(orderDTO.getItems());
        order.setStatus(OrderStatus.PENDING.value());
        repository.save(order);
        return order;
    }

    public Order place(String id, PlaceOrderDTO placeOrderDTO) throws BusinessException {
        try {
//            Customer customer = customerFeignClient.getCustomer(placeOrderDTO.getCustomerId());
            Order order = repository.findById(id).orElseThrow(() -> new BusinessException("Order not found"));
            HashMap<String, String> reasons = new HashMap<>();
            order.getItems().forEach(item -> {
                if (!stockFeignClient.isEnough(item.getProduct().getProductNumber(), item.getQuantity()).get("enough"))
                    reasons.put("reason", "Insufficient number of product: " + item.getProduct().getName());
            });
            if (reasons.size() > 0) {
                order.setCustomerId(placeOrderDTO.getCustomerId());
                order.setStatus(OrderStatus.FAILED.value());
                repository.save(order);
                throw new BusinessException("Sorry cannot place order", reasons);
            }
            order.getItems().forEach(item -> stockFeignClient.decreaseStock(item.getProduct().getProductNumber(), item.getQuantity()));
            order.setCustomerId(placeOrderDTO.getCustomerId());
            order.setStatus(OrderStatus.SUCCESS.value());
            customerFeignClient.sendEmail(placeOrderDTO.getCustomerId(), order.getCustomerId());
            repository.save(order);
            return order;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
