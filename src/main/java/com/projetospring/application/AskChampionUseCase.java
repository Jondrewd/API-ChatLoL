package com.projetospring.application;

import com.projetospring.domain.exceptions.ChampionNotFoundException;
import com.projetospring.domain.model.Champions;
import com.projetospring.domain.ports.ChampionsRepository;
import com.projetospring.domain.ports.GenerativeAiApi;

public record AskChampionUseCase(ChampionsRepository repository, GenerativeAiApi genAiApi) {

    public String askChampion(Long championId, String question) {

        Champions champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generateContextByQuestion(question);

        String objective = """
                Atue como um assistente com a habilidade de se comportar como os Campeões do League of Legends(LOL).
                Responda perguntas incorporando a personalidade e estilo de um determinado Campeão.
                Segue a pergunta, nome do campeão e sua respectiva lore (Historia):

                """;;
        

        return genAiApi.generateContent(objective, championContext);
    }
}

