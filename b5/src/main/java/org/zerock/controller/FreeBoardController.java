package org.zerock.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.dto.PageDTO;
import org.zerock.persistence.FreeBoardRepository;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Controller
@RequestMapping("/boards/*")
@Log
@AllArgsConstructor
public class FreeBoardController {
	
	private FreeBoardRepository repository;
	
	
	@GetMapping("/list")
	public void list(PageDTO pageDTO, Model model) {
		log.info("list page");
		
		Page<Object[]> result = repository.listPage(pageDTO.makePageable(0, "bno"));
		
		
		model.addAttribute("result", result);
		
	}
	
	
}
