package edu.miu.shoppingcart.controller;

import edu.miu.shoppingcart.dto.request.AddProductDTO;
import edu.miu.shoppingcart.exception.BusinessException;
import edu.miu.shoppingcart.service.CartService;
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
        service.checkout(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable String id) throws BusinessException {
        return ResponseEntity.ok(service.get(id));
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
