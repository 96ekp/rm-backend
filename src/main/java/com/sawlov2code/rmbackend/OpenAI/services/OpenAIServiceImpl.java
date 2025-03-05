package com.sawlov2code.rmbackend.OpenAI.services;
import com.sawlov2code.rmbackend.OpenAI.model.Answer;
import com.sawlov2code.rmbackend.OpenAI.model.Question;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;


@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final ChatModel chatModel;
    private final ChatClient chatClient;


    public OpenAIServiceImpl(ChatModel chatModel, ChatClient chatClient) {
        this.chatModel = chatModel;
        this.chatClient = chatClient;
    }

    @Override
    public Answer getAnswer(Question question) {
        PromptTemplate promptTemplate  = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatModel.call(prompt);
        return new Answer( response.getResult().getOutput().getContent());
    }

    @Override
    public String chat(String message) {
        return chatClient.prompt().user(message).call().content();
    }

    @Override
    public Flux<String> chatWithStream(String message) {
        return chatClient.prompt().user(message).stream().content();
    }


}
