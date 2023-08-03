package com.example.spring6r2dbc.repositories;

import com.example.spring6r2dbc.config.DatabaseConfig;
import com.example.spring6r2dbc.domain.Beer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;

@DataR2dbcTest
@Import(DatabaseConfig.class)
public class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testCreateJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(getTestBeer()));
    }

    @Test
    void testSaveNewBeer() {
        beerRepository.save(getTestBeer())
                .subscribe(beer -> {
                    System.out.println(beer.toString());
                });
    }

    public static Beer getTestBeer() {
        return Beer.builder()
                .beerName("Heineken")
                .beerStyle("Pils")
                .upc("123")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(12)
                .build();
    }
}