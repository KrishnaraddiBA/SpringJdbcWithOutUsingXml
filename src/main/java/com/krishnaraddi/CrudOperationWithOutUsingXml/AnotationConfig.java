package com.krishnaraddi.CrudOperationWithOutUsingXml;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.krishnaraddi.CrudOperationWithOutUsingXml.service.StudentDao;
import com.krishnaraddi.CrudOperationWithOutUsingXml.service.StudentDaoImpl;

public class AnotationConfig {

	@Bean(name={"pb"})
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dr=new DriverManagerDataSource();
		dr.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dr.setUrl("jdbc:mysql://localhost:3306/testDb");
		dr.setUsername("root");
		dr.setPassword("test");
		return dr;
	}
	@Bean(name= {"jdbcTemplate"})
	public JdbcTemplate getTemplate() {
		
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}

	@Bean(name= {"studentDao"})
	public StudentDao getStudent() {
		StudentDaoImpl st= new StudentDaoImpl();
		st.setJdbcTemplate(getTemplate());
		return st;
	}
}
