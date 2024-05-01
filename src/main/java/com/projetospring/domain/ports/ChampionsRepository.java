package com.projetospring.domain.ports;

import java.util.List;
import java.util.Optional;

import com.projetospring.domain.model.Champions;

public interface ChampionsRepository {

    List<Champions> findAll();

    Optional<Champions> findById(Long championId);
}