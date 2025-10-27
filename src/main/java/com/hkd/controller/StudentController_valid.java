package com.hkd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkd.domain.Student;
import com.hkd.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController_valid {
//	list화면: 전체 학생 목록
	private final StudentService studentService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students", studentService.AllStudent());

		return "student/list_validtest";
	}

//	등록폼:form화면: 새로운 학생 정보를 입력하기위한 빈화면.
	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/form_validtest";
	}

//	등록처리:학생정보 기록후 저장버튼 클릭을 하면, 학생정보를 insert
	@PostMapping
	public String create(@Valid @ModelAttribute Student student, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
//			결과에 에러가 있으면, 입력안하고, 입력창으로 돌아가기
			return "student/form_validtest";
		}
//		이미 학생 저장이 완료되요
		studentService.studentCreate(student);
		return "redirect:/list_validtest";
	}

//	http://localhost:8080/students/valid/11/edit
//	수정폼
	@GetMapping("/{id}/edit")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "student/form_validtest";
	}

//	수정처리:수정처리가 되면 안되는뎅...ㅜㅜㅜ
	@PostMapping("/{id}")
	public String update(@PathVariable int id, @Valid @ModelAttribute Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
//			결과에 에러가 있으면, 입력안하고, 입력창으로 돌아가기
			return "student/form_validtest";
		}
		student.setId(id);
		studentService.studentUpdate(student);
		return "redirect:/list_validtest";

	}

//	http://localhost:8080/students/11/delete
	// 삭제 처리
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable int id) {
		studentService.studentDelete(id);
		return "redirect:/list_validtest";
	}
}
