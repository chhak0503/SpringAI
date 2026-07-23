package com.example.ch08.service;

import java.util.List;
import java.util.Map;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.Embedding;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.embedding.EmbeddingResponseMetadata;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class SearchDocument1Service {

	
	private final EmbeddingModel embeddingModel;
	
	private final VectorStore vectorStore;
	
	
	public List<Document> searchDocument(String question) {
		
		// 유사도 검색
		List<Document> documentList = vectorStore.similaritySearch(
											SearchRequest.builder()
												.query(question)
												.topK(3)
												.similarityThreshold(0.5)
												.filterExpression("source == '헌법' && year >= 1987")
												.build()				
											);				
		
		return documentList;
	}
	
	
}





