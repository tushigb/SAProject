package edu.miu.shoppingcart.service;

import edu.miu.shoppingcart.dto.request.AddProductDTO;
import edu.miu.shoppingcart.entity.ShoppingCart;
import edu.miu.shoppingcart.exception.BusinessException;

import java.util.List;

/**
 * CartService
 *
 * @author Tushig Battumur
 **/

public interface CartService {

    ShoppingCart create();

    ShoppingCart addProduct(String id, AddProductDTO productDTO) throws BusinessException;

    ShoppingCart removeProduct(String id, String productNumber) throws BusinessException;

    List<ShoppingCart> getAll();

    ShoppingCart get(String id) throws BusinessException;

    ShoppingCart changeQuantity(String id, String productNumber, int quantity) throws BusinessException;

    void checkout(String id) throws BusinessException;

}
