package com.tutorials.repositories.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cardId", length = 100, nullable = false, unique = true)
    private String cardId;
    @Column(name = "cardNumber", nullable = false)
    private String cardNumber;
    @Column(name = "cardType", length = 10, nullable = false)
    private String cardType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;

    public CardEntity(String cardId, String cardNumber, String cardType, UserEntity user) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.user = user;
    }

}
