package com.hkd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hkd.domain.Student;
import com.hkd.mapper.StudentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	private final StudentMapper studentMapper;
	
	public List<Student> AllStudent(){
		return studentMapper.getAllStudent();
	}
	
	public Student getStudent(int id) {
		return studentMapper.getStudent(id);
	}
	
	public void studentCreate(Student stu) {
		stu.setName(stu.getName());
		stu.setEmail(stu.getEmail());
		stu.setAge(stu.getAge());
		studentMapper.createStudent(stu);
	}
	
	public void studentUpdate(Student stu) {
		stu.setName(stu.getName());
		stu.setEmail(stu.getEmail());
		stu.setAge(stu.getAge());
		studentMapper.updateStudent(stu);
	}
	
	public void studentDelete(int id) {
		studentMapper.deleteStudent(id);
	}
}
