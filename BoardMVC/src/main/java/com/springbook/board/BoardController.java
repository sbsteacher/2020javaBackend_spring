package com.springbook.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("list", service.getList());
		
		return "login";
	}
}
