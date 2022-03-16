package edu.miu.shoppingcartquery.serviceImpl;

import edu.miu.shoppingcartquery.entity.ShoppingCart;
import edu.miu.shoppingcartquery.exception.BusinessException;
import edu.miu.shoppingcartquery.repository.ShoppingCartRepository;
import edu.miu.shoppingcartquery.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ShoppingCartServiceImpl
 *
 * @author Tushig Battumur
 **/

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartRepository repository;

    public ShoppingCart get(String id) throws BusinessException {
        return repository.findById(id).orElseThrow(() -> new BusinessException("Shopping cart not found"));
    }

    public List<ShoppingCart> getAll() {
        return repository.findAll();
    }

}
