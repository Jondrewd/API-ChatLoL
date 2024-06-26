package com.projetospring.application;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projetospring.domain.model.Champions;

@SpringBootTest
public class ListChampionsUseCaseIntegrationTest {

    @Autowired
    private ListChampionsUseCase listChampionsUseCase;

    @Test
    public void testListChampions(){
        List<Champions> champions = listChampionsUseCase.findAll();

        Assertions.assertEquals(1, champions.size());
    }

}
