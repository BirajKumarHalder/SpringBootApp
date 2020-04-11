package com.tutorials.repositories.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cartId", length = 100, nullable = false, unique = true)
    private String cartId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cart_product",
            joinColumns = {@JoinColumn(name = "cartId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "productId", referencedColumnName = "id")})
    private List<ProductEntity> products;

    public CartEntity(String cartId, UserEntity user) {
        this.cartId = cartId;
        this.user = user;
    }

    public CartEntity(String cartId, UserEntity user, List<ProductEntity> products) {
        this.cartId = cartId;
        this.user = user;
        this.products = products;
    }

}
