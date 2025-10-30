<<<<<<< HEAD
package com.skc.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.skc.mybatis.domain.Student;

@Mapper
public interface StudentMapper {

	List<Student> findAll();

	Student findById(Long id);
//	@Select("SELECT * FROM student WHERE id = #{id}")
//	Student findById(Long id);

	void insert(Student student);
//	@Insert("INSERT INTO student(NAME, email, age) \r\n"
//			+ "  	VALUES (#{name}, #{email}, #{age})")
//	@Options(useGeneratedKeys = true, keyProperty = "id")
//	void insert(Student student);

	void update(Student student);
//	@Update("UPDATE student\r\n"
//			+ "	SET NAME = #{name}, email = #{email}, age = #{age}\r\n"
//			+ "	WHERE id = #{id}")
//	void update(Student student);

	void delete(Long id);
//	@Delete("DELETE FROM student WHERE id = #{id}")
//	void delete(Long id);
=======
package com.hkd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hkd.domain.Student;

@Mapper
public interface StudentMapper {
	@Select("select * from student order by id desc")
	List<Student> getAllStudent();
	
	@Select("select * from student where id = #{id}")
	Student getStudent(int id);
	
	@Insert("insert into student (name, email, age, createdAt) values (#{name}, #{email}, #{age}, Now()) ")
	void createStudent(Student student);
	
	@Update("update student set name = #{name}, email = #{email}, age = #{age}, updatedAt = now() where id=#{id}")
	void updateStudent(Student student);
	
	@Delete("delete from student where id = #{id}")
	void deleteStudent(int id);
>>>>>>> develop
}
