<<<<<<< HEAD
package com.skc.mybatis.controller;
=======
package com.hkd.controller;
>>>>>>> develop

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
import com.skc.mybatis.domain.Student;
import com.skc.mybatis.service.StudentService;
=======
import com.hkd.domain.Student;
import com.hkd.service.StudentService;
>>>>>>> develop

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
<<<<<<< HEAD
@RequestMapping("/students/valid")
@RequiredArgsConstructor
public class StudentController_valid {

	private final StudentService studentService;

//	list화면: 전체 학생 목록
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
=======
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController_valid {
//	list화면: 전체 학생 목록
	private final StudentService studentService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students", studentService.AllStudent());
>>>>>>> develop

		return "student/list_validtest";
	}

//	등록폼:form화면: 새로운 학생 정보를 입력하기위한 빈화면.
	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/form_validtest";
	}

<<<<<<< HEAD
//	***** 등록폼ValidTest:form화면: 새로운 학생 정보를 입력하기위한 빈화면.
	@GetMapping("/new/valid")
	public String createFormValid(Model model) {
		model.addAttribute("student", new Student());
		return "student/form_validtest";
	}

=======
>>>>>>> develop
//	등록처리:학생정보 기록후 저장버튼 클릭을 하면, 학생정보를 insert
	@PostMapping
	public String create(@Valid @ModelAttribute Student student, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
//			결과에 에러가 있으면, 입력안하고, 입력창으로 돌아가기
			return "student/form_validtest";
		}
//		이미 학생 저장이 완료되요
<<<<<<< HEAD
		studentService.createStudent(student);
		return "redirect:/students/valid";
=======
		studentService.studentCreate(student);
		return "redirect:/list_validtest";
>>>>>>> develop
	}

//	http://localhost:8080/students/valid/11/edit
//	수정폼
	@GetMapping("/{id}/edit")
<<<<<<< HEAD
	public String updateForm(@PathVariable Long id, Model model) {
=======
	public String updateForm(@PathVariable int id, Model model) {
>>>>>>> develop
		model.addAttribute("student", studentService.getStudent(id));
		return "student/form_validtest";
	}

//	수정처리:수정처리가 되면 안되는뎅...ㅜㅜㅜ
	@PostMapping("/{id}")
<<<<<<< HEAD
	public String update(@PathVariable Long id, @Valid @ModelAttribute Student student, BindingResult bindingResult) {
=======
	public String update(@PathVariable int id, @Valid @ModelAttribute Student student, BindingResult bindingResult) {
>>>>>>> develop
		if (bindingResult.hasErrors()) {
//			결과에 에러가 있으면, 입력안하고, 입력창으로 돌아가기
			return "student/form_validtest";
		}
		student.setId(id);
<<<<<<< HEAD
		studentService.updateStudent(student);
		return "redirect:/students/valid";
=======
		studentService.studentUpdate(student);
		return "redirect:/list_validtest";
>>>>>>> develop

	}

//	http://localhost:8080/students/11/delete
	// 삭제 처리
	@PostMapping("/{id}/delete")
<<<<<<< HEAD
	public String delete(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students/valid";
	}

=======
	public String delete(@PathVariable int id) {
		studentService.studentDelete(id);
		return "redirect:/list_validtest";
	}
>>>>>>> develop
}
