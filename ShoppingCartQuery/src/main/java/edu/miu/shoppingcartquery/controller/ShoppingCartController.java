package edu.miu.shoppingcartquery.controller;

import edu.miu.shoppingcartquery.exception.BusinessException;
import edu.miu.shoppingcartquery.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ShoppingCartController
 *
 * @author Tushig Battumur
 **/

@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(service.getAll());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable String id) throws BusinessException {
        return ResponseEntity.ok(service.get(id));
    }

}
