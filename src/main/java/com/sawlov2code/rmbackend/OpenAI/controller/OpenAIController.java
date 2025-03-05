package com.sawlov2code.rmbackend.OpenAI.controller;

import com.sawlov2code.rmbackend.OpenAI.services.ChatService;
import com.sawlov2code.rmbackend.OpenAI.services.RecipeService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/openai")
public class OpenAIController {

    private final RecipeService recipeService;
    private final ChatService chatService;

    public OpenAIController(RecipeService recipeService, ChatService chatService) {
        this.recipeService = recipeService;
        this.chatService = chatService;
    }

    @GetMapping("/ask")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }



    @GetMapping("/recipe-creator")
    public String recipeCreator(@RequestParam String ingredients,
                                @RequestParam(defaultValue = "any") String cuisine,
                                @RequestParam(defaultValue = "") String dietaryRestriction) {
        return recipeService.createRecipe(ingredients, cuisine, dietaryRestriction);
    }


}
