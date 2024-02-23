package com.eazylearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoursesController {
    @RequestMapping(value="courses") 
	public String displayCoursesPage() {
		return "courses";
	}
}
