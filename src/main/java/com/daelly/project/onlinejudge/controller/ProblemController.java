package com.daelly.project.onlinejudge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.daelly.project.onlinejudge.domain.TblSubject;
import com.daelly.project.onlinejudge.service.TblSubjectService;
import com.daelly.project.onlinejudge.utils.RefResultVo;

@Controller
public class ProblemController {
	
	@Autowired
	TblSubjectService service;

	@RequestMapping("/problems")
	public ModelAndView list() {
		Iterable<TblSubject> problems = service.findAll();
		return new ModelAndView("problem/list", "problems", problems);
	}
	
	@RequestMapping("/problem/{id}")
	public ModelAndView detail(@PathVariable Integer id) {
		TblSubject problem = service.findOne(id);
		return new ModelAndView("problem/detail", "problem", problem);
	}
	
	@RequestMapping("/problem/submit")
	@ResponseBody
	public RefResultVo submit(String problemId,Integer language,String source) {
		
		return null;
	}
}
