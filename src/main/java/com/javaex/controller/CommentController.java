package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list() {
		System.out.println("CommentController.list()");
		
		return "comment/list";
	}
}
