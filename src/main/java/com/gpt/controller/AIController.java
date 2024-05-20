package com.gpt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class AIController {

	private OllamaChatClient client;

	public AIController(OllamaChatClient client) {
		this.client = client;
	}
	
//	String r = "what is java";
	
	@GetMapping("/ai")
	public Flux<String> getResponse(@RequestParam("request") String request){
		Flux<String> Response = client.stream(request);
		return Response;
	}
	
//	  @GetMapping("/ai")
//	    public List<String> getResponse(@RequestParam("request") String request) {
//	        Flux<String> responseFlux = client.stream(request);
//	        return responseFlux.collectList().block(); // Collect the Flux into a List synchronously
//	    }

	
}
