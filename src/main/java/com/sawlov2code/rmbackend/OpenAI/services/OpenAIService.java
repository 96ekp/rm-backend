package com.sawlov2code.rmbackend.OpenAI.services;

import com.sawlov2code.rmbackend.OpenAI.model.Answer;
import com.sawlov2code.rmbackend.OpenAI.model.Question;

public interface OpenAIService {
    Answer getAnswer(Question question);
}

