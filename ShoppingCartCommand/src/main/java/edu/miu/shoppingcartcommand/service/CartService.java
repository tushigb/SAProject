package edu.miu.shoppingcartcommand.service;

import edu.miu.shoppingcartcommand.dto.request.AddProductDTO;
import edu.miu.shoppingcartcommand.dto.response.OrderResponseDTO;
import edu.miu.shoppingcartcommand.entity.ShoppingCart;
import edu.miu.shoppingcartcommand.exception.BusinessException;

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

    ShoppingCart get(String id) throws BusinessException;

    ShoppingCart changeQuantity(String id, String productNumber, int quantity) throws BusinessException;

    OrderResponseDTO checkout(String id) throws BusinessException;

}
