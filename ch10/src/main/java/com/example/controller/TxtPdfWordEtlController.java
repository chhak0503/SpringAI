package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Controller
public class TxtPdfWordEtlController {

	@GetMapping("/ai/txt-pdf-word-etl")
	public String txtPdfWordEtl() {		
		return "/txt-pdf-word-etl";				
	}
	
	@PostMapping("/ai/txt-pdf-docx-etl")
	public void txtPdfDocxEtl(@RequestParam("title") String title, 
							  @RequestParam("author") String author, 
							  @RequestParam("attach") MultipartFile attach){
		
	}
	
}













