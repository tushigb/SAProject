package edu.miu.shoppingcartcommand.controller;

import edu.miu.shoppingcartcommand.dto.request.AddProductDTO;
import edu.miu.shoppingcartcommand.exception.BusinessException;
import edu.miu.shoppingcartcommand.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CartController
 *
 * @author Tushig Battumur
 **/

@RestController
public class CartController {

    @Autowired
    CartService service;

    @RequestMapping(value = "checkout/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> checkout(@PathVariable String id) throws BusinessException {
        return ResponseEntity.ok(service.checkout(id));
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public ResponseEntity<?> create() {
        return ResponseEntity.ok(service.create());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public ResponseEntity<?> addProduct(@PathVariable String id, @RequestBody AddProductDTO productDTO) throws BusinessException {
        return ResponseEntity.ok(service.addProduct(id, productDTO));
    }

    @RequestMapping(value = "{id}/{productNumber}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeProduct(@PathVariable String id, @PathVariable String productNumber) throws BusinessException {
        return ResponseEntity.ok(service.removeProduct(id, productNumber));
    }

    @RequestMapping(value = "{id}/{productNumber}/{quantity}", method = RequestMethod.PUT)
    public ResponseEntity<?> changeQuantity(
            @PathVariable String id,
            @PathVariable String productNumber,
            @PathVariable int quantity) throws BusinessException {
        return ResponseEntity.ok((service.changeQuantity(id, productNumber, quantity)));
    }

}
