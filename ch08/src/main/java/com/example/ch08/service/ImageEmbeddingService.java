package com.example.ch08.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.ai.embedding.Embedding;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.embedding.EmbeddingResponseMetadata;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
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
	
	public float[] getFaceVector(MultipartFile mfile) throws IOException {
		
		MultipartBodyBuilder builder = new MultipartBodyBuilder();
		
		builder
			.part("file", mfile.getBytes())
			.filename(mfile.getOriginalFilename())
			.contentType(MediaType.valueOf(mfile.getContentType()));
		
		MultiValueMap<String, HttpEntity<?>> mutipartForm = builder.build();
		
		FaceEmbeddingResponse response = webClient
												.post()
												.uri("http://localhost:50001/get-face-vector")
												.body(BodyInserters.fromMultipartData(mutipartForm))
												.retrieve()
												.bodyToMono(FaceEmbeddingResponse.class)
												.block();
		
		return response.vector;
	}
	
	public void addFace(String personName, MultipartFile mfile) throws IOException {
		
		// 이미지 파일 임베딩 요청
		float[] vector = getFaceVector(mfile);
		
		// 벡터 저장소에 저장
		String strVector = Arrays.toString(vector).replace(" ", "");
		
		String sql = "INSERT INTO face_vector_store (content, embedding) VALUES (?, ?::vector)";
		jdbcTemplate.update(sql, personName, strVector);		
	}
	
	
	
	public record FaceEmbeddingResponse(float[] vector) {		
		
	}
	
	
}





