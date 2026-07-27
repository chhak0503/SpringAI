package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.InMemoryChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Controller
public class InMemoryChatController {
	
	private final InMemoryChatService service;

	@GetMapping("/ai/in-memory-chat")
	public String inMemoryChat() {
		return "/in-memory-chat";
	}
	
	@ResponseBody
	@PostMapping("/ai/in-memory-chat")
	public String inMemoryChat(@RequestParam("question") String question) {
		
		String answer = service.chat(question);
		
		return answer;
	}

}







