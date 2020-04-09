package com.tutorials.repositories.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Integer id;
    @Column(name = "userId", nullable = false, unique = true, updatable = false)
    private String userId;
    @Column(name = "userName", nullable = false)
    private String userName;
    @Column(name = "userRole", nullable = false)
    private String userRole;
    @Column(name = "userEmail", nullable = false)
    private String userEmail;
    @Column(name = "userContact", nullable = false)
    private String userContact;
}
