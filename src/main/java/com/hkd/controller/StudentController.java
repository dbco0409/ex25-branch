<<<<<<< HEAD
package com.skc.mybatis.controller;
=======
package com.hkd.controller;

import java.util.List;
>>>>>>> develop

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;

import com.skc.mybatis.domain.Student;
import com.skc.mybatis.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hkd.domain.Student;
import com.hkd.service.StudentService;

import lombok.RequiredArgsConstructor;
>>>>>>> develop

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
<<<<<<< HEAD

	private final StudentService studentService;

//	list화면: 전체 학생 목록
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students", studentService.getAllStudents());

		return "student/list";
	}

//	등록폼:form화면: 새로운 학생 정보를 입력하기위한 빈화면.
	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/form";
	}

//	등록처리:학생정보 기록후 저장버튼 클릭을 하면, 학생정보를 insert
	@PostMapping
	public String create(@ModelAttribute Student student) {
//		이미 학생 저장이 완료되요
		studentService.createStudent(student);
		return "redirect:/students";
	}

//	http://localhost:8080/students/11/edit
//	수정폼
	@GetMapping("/{id}/edit")
	public String updateForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "student/form";
	}

//	수정처리:
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, @ModelAttribute Student student) {
		student.setId(id);
		studentService.updateStudent(student);
		return "redirect:/students";
	}

//	http://localhost:8080/students/11/delete
	// 삭제 처리
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}

=======
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
	
>>>>>>> develop
}
