package com.example.Hospital_Management.config;


import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public EmbeddingModel embeddingModel() {
        // Provide a dummy implementation if not in use
        return new EmbeddingModel() {
            @Override
            public EmbeddingResponse call(EmbeddingRequest request) {
                return null;
            }

            @Override
            public float[] embed(Document document) {
                return new float[0];
            }
            // Implement required methods here
        };
    }
}