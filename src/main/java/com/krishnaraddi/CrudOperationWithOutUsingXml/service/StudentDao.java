package com.krishnaraddi.CrudOperationWithOutUsingXml.service;

import java.util.List;

import com.krishnaraddi.CrudOperationWithOutUsingXml.entity.Student;

public interface StudentDao {
	public int createData(Student student);
	public int deleteData(Student student);
	public int updateData(Student student);
	public Student getStudent(int id);
	public List<Student> getAllStudent();

}
