package com.tutorials.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "userId", length = 100, nullable = false, unique = true)
    private String userId;
    @Column(name = "userName", nullable = false)
    private String userName;
    @Column(name = "userRole", length = 10, nullable = false)
    private String userRole;
    @Column(name = "userEmail", nullable = false)
    private String userEmail;
    @Column(name = "userContact", length = 20, nullable = false)
    private String userContact;

    @OneToOne(mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY)
    private CartEntity cart;

    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CardEntity> cards;

    public UserEntity(String userId, String userName, String userRole, String userEmail, String userContact) {
        this.userId = userId;
        this.userName = userName;
        this.userRole = userRole;
        this.userEmail = userEmail;
        this.userContact = userContact;
    }

}
