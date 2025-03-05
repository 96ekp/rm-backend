package com.sawlov2code.rmbackend.OpenAI.controller;


import com.sawlov2code.rmbackend.OpenAI.model.Answer;
import com.sawlov2code.rmbackend.OpenAI.model.Question;
import com.sawlov2code.rmbackend.OpenAI.services.OpenAIService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1/openai")
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

    @PostMapping("/chat")
    public String chat(@RequestParam String message) {
        return openAIService.chat(message);
    }

    @GetMapping("/stream")
    public Flux<String> chatWithStream(@RequestParam String message) {
        return openAIService.chatWithStream(message);
    }

}
