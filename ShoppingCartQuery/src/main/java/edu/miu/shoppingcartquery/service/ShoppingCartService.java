package edu.miu.shoppingcartquery.service;

import edu.miu.shoppingcartquery.entity.ShoppingCart;
import edu.miu.shoppingcartquery.exception.BusinessException;

import java.util.List;

/**
 * ShoppingCartService
 *
 * @author Tushig Battumur
 **/

public interface ShoppingCartService {

    ShoppingCart get(String id) throws BusinessException;

    List<ShoppingCart> getAll();

}
