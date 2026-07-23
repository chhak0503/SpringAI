package com.example.ch08.service;

import java.util.List;

import org.springframework.ai.embedding.Embedding;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.embedding.EmbeddingResponseMetadata;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ImageEmbeddingService {

	private JdbcTemplate jdbcTemplate;
	private WebClient webClient;
	
	public ImageEmbeddingService(WebClient.Builder webClientBuild, JdbcTemplate jdbcTemplate) {
		this.webClient = webClientBuild.build();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public float[] getFaceVector(MultipartFile mfile) {
		
		
		
		return null;
	}
	
	
}





