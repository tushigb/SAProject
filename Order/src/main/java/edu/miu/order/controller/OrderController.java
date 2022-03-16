package edu.miu.order.controller;

import edu.miu.order.dto.request.CreateOrderDTO;
import edu.miu.order.dto.request.PlaceOrderDTO;
import edu.miu.order.exception.BusinessException;
import edu.miu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * OrderController
 *
 * @author Tushig Battumur
 **/

@RestController
public class OrderController {

    @Autowired
    OrderService service;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody CreateOrderDTO orderDTO) {
        return ResponseEntity.ok(service.create(orderDTO));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public ResponseEntity<?> place(@PathVariable String id, @RequestBody PlaceOrderDTO placeOrderDTO) throws BusinessException {
        return ResponseEntity.ok(service.place(id, placeOrderDTO));
    }

}
