package com.example.Hotel.Mangement.Config;

import com.example.Hotel.Mangement.Model.Menu;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddingModelConfig {
    @Bean
    public EmbeddingModel embeddingModel() {
        // Replace this with an actual implementation of EmbeddingModel
        return new EmbeddingModel() {
            @Override
            public EmbeddingResponse call(EmbeddingRequest request) {
                return null;
            }

            @Override
            public float[] embed(Document document) {
                return new float[0];
            }
        };
    }
}


