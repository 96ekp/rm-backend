package com.sawlov2code.rmbackend.OpenAI.controller;


import com.sawlov2code.rmbackend.OpenAI.model.Answer;
import com.sawlov2code.rmbackend.OpenAI.model.Question;
import com.sawlov2code.rmbackend.OpenAI.services.OpenAIService;
import org.springframework.web.bind.annotation.*;

@RestController
public class OpenAIController {

    private final OpenAIService openAIService;

    public OpenAIController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }


    // Ask a question to the OpenAI API
    @PostMapping("/ask")
    public Answer ask(@RequestBody Question question) {
        return openAIService.getAnswer(question);
    }

    // Ask a question to the OpenAI API
    @PostMapping("/menu")
    public Answer askMenu(@RequestBody Question question) {
        return openAIService.getAnswer(question);
    }


}
