package com.hkd.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hkd.domain.Student;
import com.hkd.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
	private final StudentService studentService;
	
	@GetMapping()
	public String list(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "5") int size, Model model) {
	    PageHelper.startPage(page, size);
	    List<Student> students = studentService.AllStudent();
	    PageInfo<Student> pageInfo = new PageInfo<>(students);

	    model.addAttribute("students", students);
	    model.addAttribute("pageInfo", pageInfo);

	    return "student/list";
	}
	
	@GetMapping("/new")
	public String studentCreate(Model model) {
		Student stu = new Student();
		model.addAttribute("student", stu);
		return "student/form";
	}
	
	@PostMapping()
	public String studentCreate(@ModelAttribute Student student) {
		studentService.studentCreate(student);
		return "redirect:/students";
	}
	
	@GetMapping("/{id}/edit")
	public String studentUpdate(@PathVariable int id, Model model) {
		Student stu = studentService.getStudent(id);
		model.addAttribute("student", stu);
		return "student/form";
	}
	
	@PostMapping("/{id}")
	public String studentUpdatePost(@ModelAttribute Student student) {
		studentService.studentUpdate(student);
		return "redirect:/students";
	}
	
	@PostMapping("/{id}/delete")
	public String studentDelete(@PathVariable int id) {
		studentService.studentDelete(id);
		return "redirect:/students";
	}
	
}
