package com.sawlov2code.rmbackend.OpenAI.services;

import com.sawlov2code.rmbackend.OpenAI.model.Answer;
import com.sawlov2code.rmbackend.OpenAI.model.Question;
import reactor.core.publisher.Flux;

public interface OpenAIService {
    Answer getAnswer(Question question);
    String chat(String message);
    Flux<String> chatWithStream(String message);
}

