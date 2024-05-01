package com.projetospring.adapters.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;

import com.projetospring.domain.ports.GenerativeAiApi;

import feign.FeignException;
import feign.RequestInterceptor;

@FeignClient(name = "geminiApi", url = "${gemini.base-url}", configuration = GoogleGeminiService.Config.class)
public interface GoogleGeminiService extends GenerativeAiApi{

    @PostMapping("/v1beta/models/gemini-pro:generateContent")
    GoogleGeminiResp textOnlyInput(GoogleGeminiReq req);
    
    @Override
    default String generateContent(String objective, String context) {
        String prompt = """
                %s
                %s
                """.formatted(objective, context);

            GoogleGeminiReq req= new GoogleGeminiReq(
                List.of(new Content(List.of(new Part(prompt))))
            );

            try{
            GoogleGeminiResp resp = textOnlyInput(req);
            return resp.candidates().getFirst().content().parts().getFirst().text();
            }
            catch(FeignException httpEroors){
                return "Foi mal! Erro de comunicação com a Api do Google Gemini.";
            }
            catch (Exception unexpectedError){
                return "Foi mal! O retorno da Api do Google Gemini não contem os dados esperados.";
            }
    }

    record  GoogleGeminiReq(List<Content> contents){}
    record Content(List<Part> parts){}
    record Part(String text){}

    record GoogleGeminiResp(List<Candidates> candidates){}
    record Candidates(Content content){}


    class Config{
        @Bean
        public RequestInterceptor apiKeyRequestInterceptor(@Value("${gemini.api-key}") String apiKey){
            return requestTemplate -> requestTemplate.query("key", apiKey);
        }
    }

}
