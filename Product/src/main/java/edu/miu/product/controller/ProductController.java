package edu.miu.product.controller;

import edu.miu.product.dto.request.ProductDTO;
import edu.miu.product.exception.BusinessException;
import edu.miu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CustomerController
 *
 * @author Tushig Battumur
 **/

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @Autowired
    Environment env;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(service.add(productDTO));
    }

    @RequestMapping(value = "{productNumber}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remove(@PathVariable String productNumber) {
        service.remove(productNumber);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @RequestMapping(value = "{productNumber}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable String productNumber) throws BusinessException {
        return ResponseEntity.ok(service.get(productNumber));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        System.out.println("Running... " + env.getProperty("server.port"));
        return ResponseEntity.ok(service.getAll());
    }

    @RequestMapping(value = "{productNumber}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable String productNumber, @RequestBody ProductDTO productDTO) throws BusinessException {
        return ResponseEntity.ok(service.update(productNumber, productDTO));
    }

    @RequestMapping(value = "check/{productNumber}/{quantity}", method = RequestMethod.GET)
    public ResponseEntity<?> checkStock(@PathVariable String productNumber, @PathVariable int quantity) throws BusinessException {
        return ResponseEntity.ok(service.check(productNumber, quantity));
    }

    @RequestMapping(value = "decrease/{productNumber}/{quantity}", method = RequestMethod.PUT)
    public ResponseEntity<?> decreaseStock(@PathVariable String productNumber, @PathVariable int quantity) throws BusinessException {
        service.decreaseStock(productNumber, quantity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
