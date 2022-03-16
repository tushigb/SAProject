package edu.miu.customer.controller;

import edu.miu.customer.dto.request.CustomerDTO;
import edu.miu.customer.exception.BusinessException;
import edu.miu.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CustomerController
 *
 * @author Tushig Battumur
 **/

@RestController
public class CustomerController {

    @Autowired
    CustomerService service;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(service.add(customerDTO));
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remove(@PathVariable String customerId) {
        service.remove(customerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable String customerId) throws BusinessException {
        return ResponseEntity.ok(service.get(customerId));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable String customerId, @RequestBody CustomerDTO customerDTO) throws BusinessException {
        return ResponseEntity.ok(service.update(customerId, customerDTO));
    }

}
