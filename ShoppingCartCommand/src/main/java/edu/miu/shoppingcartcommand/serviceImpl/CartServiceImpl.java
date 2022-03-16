package edu.miu.shoppingcartcommand.serviceImpl;

import edu.miu.shoppingcartcommand.dto.request.AddProductDTO;
import edu.miu.shoppingcartcommand.dto.response.OrderResponseDTO;
import edu.miu.shoppingcartcommand.entity.CartItem;
import edu.miu.shoppingcartcommand.entity.ShoppingCart;
import edu.miu.shoppingcartcommand.exception.BusinessException;
import edu.miu.shoppingcartcommand.feign.OrderFeignClient;
import edu.miu.shoppingcartcommand.feign.StockFeignClient;
import edu.miu.shoppingcartcommand.repository.CartRepository;
import edu.miu.shoppingcartcommand.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    OrderFeignClient orderFeignClient;

    @Autowired
    private KafkaTemplate<String, ShoppingCart> kafkaTemplate;

    public ShoppingCart create() {
        ShoppingCart cart = new ShoppingCart();
        repository.save(cart);
        kafkaTemplate.send("shopping_cart", cart);
        return cart;
    }

    public ShoppingCart addProduct(String id, AddProductDTO productDTO) throws BusinessException {
        if (stockFeignClient.isEnough(productDTO.getProduct().getProductNumber(), productDTO.getQuantity()).get("enough")) {
            ShoppingCart cart = repository.findById(id).orElseThrow(() -> new BusinessException("Shopping cart not found"));
            cart.addProduct(productDTO);
            repository.save(cart);
            kafkaTemplate.send("shopping_cart", get(id));
            return cart;
        }
        throw new BusinessException("Insufficient number of products");
    }

    public ShoppingCart removeProduct(String id, String productNumber) throws BusinessException {
        ShoppingCart cart = repository.findById(id).orElseThrow(() -> new BusinessException("Shopping cart not found"));
        cart.getItems().remove(cart.getItems().stream().filter(item -> item.getProduct().getProductNumber().equals(productNumber))
                .findFirst().orElseThrow(() -> new BusinessException("This product is not in the cart")));
        repository.save(cart);
        kafkaTemplate.send("shopping_cart", get(id));
        return cart;
    }

    public ShoppingCart changeQuantity(String id, String productNumber, int quantity) throws BusinessException {
        if (stockFeignClient.isEnough(productNumber, quantity).get("enough")) {
            ShoppingCart cart = get(id);
            cart.getItems().forEach(item -> {
                if (item.getProduct().getProductNumber().equals(productNumber))
                    item.setQuantity(quantity);
            });
            kafkaTemplate.send("shopping_cart", get(id));
            return cart;
        }
        throw new BusinessException("Insufficient number of products");
    }

    public ShoppingCart get(String id) throws BusinessException {
        return repository.findById(id).orElseThrow(() -> new BusinessException("Shopping cart not found"));
    }

    public OrderResponseDTO checkout(String id) throws BusinessException {
        HashMap<String, List<CartItem>> body = new HashMap<>();
        body.put("items", get(id).getItems());
        return orderFeignClient.createOrder(body);
    }

}
