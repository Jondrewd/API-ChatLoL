package com.projetospring.adapters.in;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import com.projetospring.application.AskChampionUseCase;




@Tag(name = "Campeões")
@RestController
@RequestMapping("/champions")
public record AskChampionRestController(AskChampionUseCase useCase) {
    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampion(
        @PathVariable("championId") Long championId,
        @RequestBody AskChampionRequest request) {
        String answer = useCase.askChampion(championId, request.question());
        return new AskChampionResponse(answer);
    }
    public record AskChampionRequest(String question) { }
    public record AskChampionResponse(String answer) { }
    
}