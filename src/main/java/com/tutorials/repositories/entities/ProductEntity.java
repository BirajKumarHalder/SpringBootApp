package com.tutorials.repositories.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "productId", length = 100, nullable = false, unique = true)
    private String productId;
    @Column(name = "productName", nullable = false)
    private String productName;
    @Column(name = "productPrice", nullable = false)
    private Long productPrice;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cart_product",
            joinColumns = {@JoinColumn(name = "productId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "cartId", referencedColumnName = "id")})
    private List<CartEntity> carts;

    public ProductEntity(String priductId, String productName, Long productPrice) {
        this.productId = priductId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

}
