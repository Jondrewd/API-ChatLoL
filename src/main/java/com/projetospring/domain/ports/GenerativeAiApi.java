package com.projetospring.domain.ports;

public interface GenerativeAiApi {
    String generateContent(String objective, String context);
}
