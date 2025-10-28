package com.skc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SimpleRestController {

//	http://localhost:8080/article?title=스프링부트&content=완성하기
	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public String createArticle(@RequestParam("title") String title, @RequestParam("content") String content) {
		return String.format("title=%s / content=%s", title, content);
	}

}
