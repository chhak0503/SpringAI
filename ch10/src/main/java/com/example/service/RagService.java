package com.example.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.Ordered;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class RagService {
	
	private ChatClient chatClient;	
	private VectorStore vectorStore;
	private JdbcTemplate jdbcTemplate;
	
	public RagService(ChatClient.Builder chatClientBuilder, 
					  VectorStore vectorStore, 
					  JdbcTemplate jdbcTemplate) {
		
		this.chatClient = chatClientBuilder
							.defaultAdvisors(
								new SimpleLoggerAdvisor(Ordered.HIGHEST_PRECEDENCE - 1)
							)							
							.build();
		
		this.vectorStore = vectorStore;
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void clearVectorStore() {
		jdbcTemplate.update("TRUNCATE TABLE vector_store");	
	}

}











