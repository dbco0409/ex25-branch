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
	public String studentAllList(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "5") int size, Model model) {
		PageHelper.startPage(page, size);
		List<Student> students = studentService.StudentAllList();
	    PageInfo<Student> pageInfo = new PageInfo<>(students);
	    int stuCnt = studentService.getCountStudent();
	    
		model.addAttribute("students", students);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("pageSize", stuCnt);
		
		return "student/list";
	}
	
	@GetMapping("/new")
	public String registStudent(Model model) {
		Student stu = new Student();
		model.addAttribute("student", stu);
		return "student/form";
	}
	
	@PostMapping("/")
	public String registStudent(@ModelAttribute Student student) {
		studentService.StudentCreate(student);
		return "redirect:/students";
	}
	
	@GetMapping("/{id}/edit")
	public String updateStudent(@PathVariable int id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "student/form";
	}
	
	@PostMapping("/{id}")
	public String updateStudentPost(@ModelAttribute Student student, Model model) {
		studentService.StudentUpdate(student);
		return "redirect:/students";
	}
	
	@PostMapping("/{id}/delete")
	public String deleteStudent(@PathVariable int id) {
		studentService.studentDelete(id);
		return "redirect:/students";
	}
}
