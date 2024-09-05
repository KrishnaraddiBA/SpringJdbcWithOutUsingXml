package com.krishnaraddi.CrudOperationWithOutUsingXml.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.krishnaraddi.CrudOperationWithOutUsingXml.entity.Student;

public class StudentDaoImpl implements StudentDao{
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int createData(Student student) {
		String query="insert into student(id,name,college) values(?,?,?)";
		int update = jdbcTemplate.update(query,student.getId(),student.getName(),student.getCollege());
		return update;
	}

	@Override
	public int deleteData(Student student) {

		String query="delete from student where id=?";
		int update = jdbcTemplate.update(query,student.getId());
		return update;
	}

	@Override
	public int updateData(Student student) {

		String query="update student set name=?,college=? where id=?";
		int update = jdbcTemplate.update(query,student.getName(),student.getCollege(),student.getId());
		
		return update;
	}

	@Override
	public Student getStudent(int id) {

		RowMapper<Student> rowMapper=new RowMapper<Student>() {
			
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

				Student student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCollege(rs.getString(3));
				
				return student;
			}
		};
		String query="select * from student where id=?";
		Student studen = jdbcTemplate.queryForObject(query, rowMapper,id);
		
		return studen;
	}

	@Override
	public List<Student> getAllStudent() {

		String query="select * from student";
		RowMapper<Student> rowMapper=new RowMapper<Student>() {
			
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCollege(rs.getString(3));
				return null;
			}
		};
		List<Student> query2 = jdbcTemplate.query(query,rowMapper);
		
		
		
		return query2;
	}


}
