package com.tutorials.controllers;

import com.tutorials.models.CardModel;
import com.tutorials.models.ProductModel;
import com.tutorials.services.impls.CardServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"Card"}, description = "Card management services", value = "card")
@RequestMapping("/secure")
public class CardController {

    @Autowired
    private CardServiceImpl cardService;

    @GetMapping(value = "retrieve-card")
    @ApiOperation(value = "Card retrieve", response = CardModel.class, responseContainer = "Card", nickname = "retrieve-card")
    public ResponseEntity<List<CardModel>> retrieveAllCards() {
        return ResponseEntity.ok(cardService.retrieveAllCards());
    }

}
