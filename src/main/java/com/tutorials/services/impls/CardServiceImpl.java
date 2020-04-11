package com.tutorials.services.impls;

import com.tutorials.models.CardModel;
import com.tutorials.repositories.CardRepository;
import com.tutorials.repositories.entities.CardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl {

    @Autowired
    private CardRepository cardRepository;

    public List<CardModel> retrieveAllCards() {
        List<CardEntity> cardEntities = cardRepository.findAll();
        List<CardModel> cardModels = cardEntities.parallelStream().map(cardEntity -> {
            CardModel cardModel = new CardModel();
            cardModel.setId(cardEntity.getId());
            cardModel.setCardId(cardEntity.getCardId());
            cardModel.setCardNumber(cardEntity.getCardNumber());
            cardModel.setCardType(cardEntity.getCardType());
            return cardModel;
        }).collect(Collectors.toList());
        return cardModels;
    }
}
