package com.tutorials;

import com.tutorials.repositories.CardRepository;
import com.tutorials.repositories.CartRepository;
import com.tutorials.repositories.ProductRepository;
import com.tutorials.repositories.UserRepository;
import com.tutorials.repositories.entities.CardEntity;
import com.tutorials.repositories.entities.CartEntity;
import com.tutorials.repositories.entities.ProductEntity;
import com.tutorials.repositories.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootApp implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cartRepository.deleteAll();
        userRepository.deleteAll();
        cardRepository.deleteAll();
        productRepository.deleteAll();
        UserEntity userEntity = new UserEntity("user0", "Super User", "Admin", "superUser@email.com", "9876543210");
        userRepository.save(userEntity);
        System.out.println("running queries----------> 1");
        UserEntity userEntity1 = new UserEntity("user1", "Biraj", "Admin", "biraj@email.com", "9876543210");
        userEntity1 = userRepository.save(userEntity1);
        System.out.println("running queries----------> 2");
        UserEntity userEntity2 = new UserEntity("user2", "Amit", "Admin", "amit@email.com", "9876543210");
        userEntity2 = userRepository.save(userEntity2);
        System.out.println("running queries----------> 3");
        CartEntity cartEntity1 = new CartEntity("cart1", userEntity1);
        cartEntity1 = cartRepository.save(cartEntity1);
        System.out.println("running queries----------> 4");
        CartEntity cartEntity2 = new CartEntity("cart2", userEntity2);
        cartEntity2 = cartRepository.save(cartEntity2);
        System.out.println("running queries----------> 5");
        CardEntity cardEntity1 = new CardEntity("card1", "123456789", "Debit", userEntity1);
        cardRepository.save(cardEntity1);
        System.out.println("running queries----------> 6");
        CardEntity cardEntity2 = new CardEntity("card2", "123456789", "Credit", userEntity1);
        cardRepository.save(cardEntity2);
        System.out.println("running queries----------> 7");
        CardEntity cardEntity3 = new CardEntity("card3", "123456789", "Debit", userEntity2);
        cardRepository.save(cardEntity3);
        System.out.println("running queries----------> 8");
        CardEntity cardEntity4 = new CardEntity("card4", "123456789", "Credit", userEntity2);
        cardRepository.save(cardEntity4);
        System.out.println("running queries----------> 9");
        ProductEntity productEntity1 = new ProductEntity("product1", "Product 1", 100L);
        productRepository.save(productEntity1);
        System.out.println("running queries----------> 10");
        ProductEntity productEntity2 = new ProductEntity("product2", "Product 2", 100L);
        productRepository.save(productEntity2);
        System.out.println("running queries----------> 11");
        ProductEntity productEntity3 = new ProductEntity("product3", "Product 3", 100L);
        productRepository.save(productEntity3);
        System.out.println("running queries----------> 12");
        List<ProductEntity> productsForCart1 = Arrays.asList(productEntity1, productEntity2, productEntity3);
        cartEntity1.setProducts(productsForCart1);
        cartRepository.save(cartEntity1);
        System.out.println("running queries----------> 13");
        List<ProductEntity> productsForCart2 = Arrays.asList(productEntity2);
        cartEntity2.setProducts(productsForCart2);
        cartRepository.save(cartEntity2);
        System.out.println("running queries----------> 14");
        List<ProductEntity> productsForCart3 = Arrays.asList(productEntity3);
        cartEntity2.setProducts(productsForCart3);
        cartRepository.save(cartEntity2);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}