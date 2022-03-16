package edu.miu.shoppingcart.serviceImpl;

import edu.miu.shoppingcart.dto.request.AddProductDTO;
import edu.miu.shoppingcart.entity.CartItem;
import edu.miu.shoppingcart.entity.ShoppingCart;
import edu.miu.shoppingcart.exception.BusinessException;
import edu.miu.shoppingcart.feign.StockFeignClient;
import edu.miu.shoppingcart.model.Product;
import edu.miu.shoppingcart.repository.CartRepository;
import edu.miu.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CartServiceImpl
 *
 * @author Tushig Battumur
 **/

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository repository;

    @Autowired
    StockFeignClient stockFeignClient;

    @Autowired
    private KafkaTemplate<String, ShoppingCart> kafkaTemplate;

    public ShoppingCart create() {
        ShoppingCart cart = new ShoppingCart();
        repository.save(cart);
        return cart;
    }

    public ShoppingCart addProduct(String id, AddProductDTO productDTO) throws BusinessException {
        if (stockFeignClient.isEnough(productDTO.getProduct().getProductNumber(), productDTO.getQuantity()).get("enough")) {
            ShoppingCart cart = repository.findById(id).orElseThrow(() -> new BusinessException("Shopping cart not found"));
            cart.addProduct(productDTO);
            repository.save(cart);
            return cart;
        }
        throw new BusinessException("Insufficient number of products");
    }

    public ShoppingCart removeProduct(String id, String productNumber) throws BusinessException {
        ShoppingCart cart = repository.findById(id).orElseThrow(() -> new BusinessException("Shopping cart not found"));
        cart.getItems().remove(cart.getItems().stream().filter(item -> item.getProduct().getProductNumber().equals(productNumber))
                .findFirst().orElseThrow(() -> new BusinessException("This product is not in the cart")));
        repository.save(cart);
        return cart;
    }

    public List<ShoppingCart> getAll() {
        return repository.findAll();
    }

    public ShoppingCart get(String id) throws BusinessException {
        return repository.findById(id).orElseThrow(() -> new BusinessException("Shopping cart not found"));
    }

    public ShoppingCart changeQuantity(String id, String productNumber, int quantity) throws BusinessException {
        if (stockFeignClient.isEnough(productNumber, quantity).get("enough")) {
            ShoppingCart cart = get(id);
            cart.getItems().forEach(item -> {
                if (item.getProduct().getProductNumber().equals(productNumber))
                    item.setQuantity(quantity);
            });
            return cart;
        }
        throw new BusinessException("Insufficient number of products");
    }

    public void checkout(String id) throws BusinessException {
        kafkaTemplate.send("order", get(id));
    }

}
