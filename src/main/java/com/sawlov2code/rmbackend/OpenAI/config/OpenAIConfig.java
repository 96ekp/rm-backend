package com.sawlov2code.rmbackend.OpenAI.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {
    @Bean
    public ChatClient chatClient() {
        return new ChatClient() {
            @Override
            public ChatClientRequestSpec prompt() {
                return null;
            }

            @Override
            public ChatClientRequestSpec prompt(String content) {
                return null;
            }

            @Override
            public ChatClientRequestSpec prompt(Prompt prompt) {
                return null;
            }

            @Override
            public Builder mutate() {
                return null;
            }
        }; // Adjust this to your actual ChatClient instantiation
    }
}
