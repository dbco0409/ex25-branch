<<<<<<< HEAD
package com.skc.mybatis.service;
=======
package com.hkd.service;
>>>>>>> develop

import java.util.List;

import org.springframework.stereotype.Service;
<<<<<<< HEAD
import org.springframework.transaction.annotation.Transactional;

import com.skc.mybatis.domain.Student;
import com.skc.mybatis.mapper.StudentMapper;
=======

import com.hkd.domain.Student;
import com.hkd.mapper.StudentMapper;
>>>>>>> develop

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
<<<<<<< HEAD
@Transactional(readOnly = true)
public class StudentService {

	private final StudentMapper studentMapper;

	public List<Student> getAllStudents() {

		return studentMapper.findAll();
//		List<Student> studens = new ArrayList<>();
//		studens.add(new Student() {{setId(1L); setName("홍길동");}});
//		studens.add(new Student() {{setId(2L); setName("이몽룡");}});
//		studens.add(new Student() {{setId(3L); setName("성춘향");}});
//		return studens;
	}

	public Student getStudent(Long id) {
		return studentMapper.findById(id);
	}

	@Transactional
	public void createStudent(Student student) {
		studentMapper.insert(student);

	}

	@Transactional
	public void updateStudent(Student student) {
		studentMapper.update(student);
	}

	@Transactional
	public void deleteStudent(Long id) {
		studentMapper.delete(id);
	}

=======
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
>>>>>>> develop
}
