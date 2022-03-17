package edu.miu.ecommerceclient;

import edu.miu.ecommerceclient.cart.AddProductDTO;
import edu.miu.ecommerceclient.cart.ShoppingCart;
import edu.miu.ecommerceclient.customer.Customer;
import edu.miu.ecommerceclient.order.Order;
import edu.miu.ecommerceclient.order.PlaceOrderDTO;
import edu.miu.ecommerceclient.product.Product;
import edu.miu.ecommerceclient.product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class ECommerceClientApplication {

    @Autowired
    private RestOperations restTemplate;

    @Bean
    RestOperations restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ECommerceClientApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomething() {
        String productURL = "http://localhost:8050/product/";
        String cartCommandURL = "http://localhost:8050/cart/command/";
        String cartQueryURL = "http://localhost:8050/cart/read/";
        String customerURL = "http://localhost:8050/customer/";
        String orderURL = "http://localhost:8050/order/";

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
//        1. Add a number of products in the product service
        try {
            System.out.println("ADDING NEW PRODUCTS---");
            product1 = restTemplate.postForObject(productURL, new ProductDTO("iPhone 13", "Apple iPhone", 700.0, 100), Product.class);
            product2 = restTemplate.postForObject(productURL, new ProductDTO("iPhone 13 Pro", "Apple iPhone", 1000.0, 100), Product.class);
            product3 = restTemplate.postForObject(productURL, new ProductDTO("iPhone 13 Pro Max", "Apple iPhone", 1100.0, 100), Product.class);

            System.out.println("new product---" + product1);
            System.out.println("new product---" + product2);
            System.out.println("new product---" + product3);
        } catch (HttpClientErrorException ex) {
            System.out.println("------" + ex.getMessage());
        }

//        2. Modify a product in the productservice
        try {
            System.out.println("UPDATING PRODUCTS---");
            restTemplate.put(productURL + product1.getProductNumber(), new ProductDTO("iPhone 13", "Apple iPhone", 700.0, 90));
            restTemplate.put(productURL + product2.getProductNumber(), new ProductDTO("iPhone 13 Pro", "Apple iPhone", 1000.0, 70));
            restTemplate.put(productURL + product3.getProductNumber(), new ProductDTO("iPhone 13 Pro Max", "Apple iPhone", 1100.0, 60));
        } catch (HttpClientErrorException ex) {
            System.out.println("------" + ex.getMessage());
        }

//        3. Retrieve one or more products and show these products (using System.out.println())
        try {
            System.out.println("FETCHING PRODUCTS---");

            ResponseEntity<Product[]> response = restTemplate.getForEntity(productURL, Product[].class);
            Arrays.stream(response.getBody()).forEach(System.out::println);
        } catch (HttpClientErrorException ex) {
            System.out.println("------" + ex.getMessage());
        }

//        4. Put some products in the shoppingcart
//        5. Retrieve and show the shoppingcart
//        6. Delete one product from the shoppingcart
//        7. Change the quantity of one of the products
//        8. Retrieve and show the shoppingcart
//        9. Checkout the shoppingcart
//        10. Add customer to order
//        11. Retrieve and show the order
//        12. Place the order
        try {
            System.out.println("CREATING SHOPPING CART---");
            ShoppingCart cart = restTemplate.getForObject(cartCommandURL + "create", ShoppingCart.class);
            System.out.println("shopping cart---" + cart);

            ResponseEntity<Product[]> response = restTemplate.getForEntity(productURL, Product[].class);

            for (Product product : response.getBody()) {
                System.out.println("ADDING PRODUCT ON CART---" + product);
                restTemplate.postForLocation(cartCommandURL + cart.getId(), new AddProductDTO(new edu.miu.ecommerceclient.cart.Product(product.getProductNumber(), product.getName(), product.getDescription(), product.getPrice()), 3));
            }

            cart = restTemplate.getForObject(cartQueryURL + cart.getId(), ShoppingCart.class);
            System.out.println("shopping cart---" + cart);

            System.out.println("DELETING 1 PRODUCT FROM CART---");
            restTemplate.delete(cartCommandURL + cart.getId() + "/" + response.getBody()[0].getProductNumber());
            cart = restTemplate.getForObject(cartQueryURL + cart.getId(), ShoppingCart.class);
            System.out.println("shopping cart---" + cart);

            System.out.println("CHANGING THE QUANTITY OF PRODUCT---");
            restTemplate.put(cartCommandURL + cart.getId() + "/" + response.getBody()[1].getProductNumber() + "/" + 1, null);

            cart = restTemplate.getForObject(cartQueryURL + cart.getId(), ShoppingCart.class);
            System.out.println("shopping cart---" + cart);

            System.out.println("CHECKING OUT SHOPPINGCART---");
            Order order = restTemplate.getForObject(cartCommandURL + "checkout/" + cart.getId(), Order.class);
            System.out.println("order---" + order);

            System.out.println("FETCHING CUSTOMERS---");
            ResponseEntity<Customer[]> customerResponse = restTemplate.getForEntity(customerURL, Customer[].class);
            for (Customer customer : customerResponse.getBody()) {
                System.out.println("customer---" + customer);
            }

            System.out.println("PLACING ORDER---");
            order = restTemplate.postForObject(orderURL + order.getId(), new PlaceOrderDTO(customerResponse.getBody()[0].getCustomerId()), Order.class);
            System.out.println("order---" + order);

            System.out.println("FETCHING PRODUCTS---");

            response = restTemplate.getForEntity(productURL, Product[].class);
            Arrays.stream(response.getBody()).forEach(System.out::println);

        } catch (HttpClientErrorException ex) {
            System.out.println("------" + ex.getMessage());
        }

    }

}
