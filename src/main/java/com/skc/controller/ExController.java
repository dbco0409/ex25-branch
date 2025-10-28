package com.skc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skc.service.ExService;

@RestController
public class ExController {

	ExService exService;

	public ExController(ExService exService) {
		this.exService = exService;
	}

//	@GetMapping("/")
//	public String getMethodName() {
//		return "루트경로";
//	}

//	http://localhost:8080
//	@GetMapping("/")
//	public String getMethodName() {
////		return "안녕 좋은날";
//		return exService.sayHello("안녕");
//	}

//	http://localhost:8080/exInt
	@GetMapping("/exInt")
	public Integer getExInt() {
		return exService.exInt();
	}

//	http://localhost:8080/ex321
	@GetMapping("/ex321")
	public String getEx321() {
		return exService.ex321();
	}

//	http://localhost:8080/ex322
	@GetMapping("/ex322")
	public String getEx322() {
		return exService.ex322();
	}

	@GetMapping("/ex323")
	public String getEx323() {
		return exService.ex323();
	}

	@GetMapping("/ex324")
	public String getEx324() {
		return exService.ex324();
	}

}
