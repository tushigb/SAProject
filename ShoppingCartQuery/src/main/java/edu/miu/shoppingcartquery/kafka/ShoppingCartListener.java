package edu.miu.shoppingcartquery.kafka;

import edu.miu.shoppingcartquery.entity.ShoppingCart;
import edu.miu.shoppingcartquery.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * ShoppingCartListener
 *
 * @author Tushig Battumur
 **/

@Service
public class ShoppingCartListener {

    @Autowired
    ShoppingCartRepository repository;

    @KafkaListener(topics = {"shopping_cart"}, groupId = "gid2")
    public void receive(@Payload ShoppingCart cart) {
        System.out.println("Receiver received message= " + cart);
        repository.save(cart);
    }

}
