package com.example.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class InMemoryChatService {
	
	private ChatClient chatClient;
	
	public InMemoryChatService(ChatClient.Builder chatClientBuilder) {
		this.chatClient = chatClientBuilder
				.defaultAdvisors(
					new SimpleLoggerAdvisor(Ordered.LOWEST_PRECEDENCE - 1)
				)				
				.build();
	}
	
	public String chat(String question) {
		
		String answer = chatClient.prompt()
							.user(question)
							.call()
							.content();
		
		return answer;		
	}

}






