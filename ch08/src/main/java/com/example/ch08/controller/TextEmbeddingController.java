package com.example.ch08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Controller
public class TextEmbeddingController {
	
	@GetMapping("/ai/text-embedding")
	public String textEmbedding() {
		return "/text-embedding";
	}
	
	@PostMapping("/ai/text-embedding")
	public String textEmbedding(@RequestParam("question") String question) {
		
		
		return "";
	}

}








