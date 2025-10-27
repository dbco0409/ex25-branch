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
	public List<Student> StudentAllList(){
		return studentMapper.studentAllList();
	}
	
	public Student getStudent(int id){
		return studentMapper.getStudent(id);
	}
	
	public int getCountStudent(){
		return studentMapper.studentCount();
	}
	
	public void StudentCreate(Student stu) {
		stu.setName(stu.getName());
		stu.setEmail(stu.getEmail());
		stu.setAge(stu.getAge());
		studentMapper.studentCreate(stu);;
	}
	
	public void StudentUpdate(Student stu) {
		stu.setId(stu.getId());
		stu.setName(stu.getName());
		stu.setEmail(stu.getEmail());
		stu.setAge(stu.getAge());
		studentMapper.studentUpdate(stu);
	}
	
	public void studentDelete(int id) {
		studentMapper.studentDelete(id);
	}
	
	
}
