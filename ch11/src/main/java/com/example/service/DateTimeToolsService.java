package com.example.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DateTimeToolsService {

	private ChatClient chatClient;
	
	public DateTimeToolsService(ChatClient.Builder chatClientBuilder) {
		this.chatClient = chatClientBuilder.build();
	}
	
	public String chat(String question) {
		
		String answer = this.chatClient
								.prompt()
								.user(question)
								.call()
								.content();
		return answer;
	}
	
}





