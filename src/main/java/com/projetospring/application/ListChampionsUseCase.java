package com.projetospring.application;

import java.util.List;

import com.projetospring.domain.model.Champions;
import com.projetospring.domain.ports.ChampionsRepository;

public record ListChampionsUseCase(ChampionsRepository repository) {

    public List<Champions> findAll(){
        return repository.findAll();
    }
}
