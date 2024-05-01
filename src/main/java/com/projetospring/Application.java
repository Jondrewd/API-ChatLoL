package com.projetospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.projetospring.application.AskChampionUseCase;
import com.projetospring.application.ListChampionsUseCase;
import com.projetospring.domain.ports.ChampionsRepository;
import com.projetospring.domain.ports.GenerativeAiApi;

@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository){
		return new ListChampionsUseCase(repository);
	}
	
	@Bean
	public AskChampionUseCase provideAskChampionUseCase(ChampionsRepository repository, GenerativeAiApi genAiService){
		return new AskChampionUseCase(repository, genAiService);
	}
}
