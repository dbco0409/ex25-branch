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
	List<Student> studentAllList();
	
	@Select("select * from student where id = #{id}")
	Student getStudent(int id);
	
	@Select("select count(*) as cnt from student order by id desc")
	int studentCount();
	
	@Insert("insert into student (name, email, age, createdAt) values (#{name}, #{email}, #{age}, now())")
	void studentCreate(Student student);
	
	@Update("update student set name = #{name}, email = #{email}, age = #{age}, updatedAt = now() where id = #{id}")
	void studentUpdate(Student student);
	
	@Delete("delete from student where id = #{id}")
	void studentDelete(int id);
	
}
