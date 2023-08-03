package com.example.spring6r2dbc.repositories;

import com.example.spring6r2dbc.config.DatabaseConfig;
import com.example.spring6r2dbc.domain.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataR2dbcTest
@Import(DatabaseConfig.class)
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveNewBeer() {
        beerRepository.save(getTestBeer())
                .subscribe(beer -> {
                    System.out.println(beer.toString());
                });
    }

    Beer getTestBeer() {
        return Beer.builder()
                .beerName("Heineken")
                .beerStyle("Pils")
                .upc("123")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(12)
                .build();
    }
}