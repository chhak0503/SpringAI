package com.example.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.example.tool.DateTimeTools;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class HeatingSystemToolsService {

	private ChatClient chatClient;	
	
	public HeatingSystemToolsService(ChatClient.Builder chatClientBuilder) {
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





