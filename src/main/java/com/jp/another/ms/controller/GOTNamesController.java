package com.jp.another.ms.controller;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/got/names")
public class GOTNamesController {

    private final Faker faker = new Faker();
    private final List<String> gameOfTronesList = new ArrayList<>();

    @PostConstruct
    public void init() {
        for (int i = 0; i < 20; i++) {
            gameOfTronesList.add(faker.dragonBall().character());
        }
    }

    @GetMapping
    public ResponseEntity<List<String>> getFakerName() {


        return ResponseEntity.ok(gameOfTronesList);

    }
}
