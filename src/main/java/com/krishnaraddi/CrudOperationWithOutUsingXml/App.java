package com.krishnaraddi.CrudOperationWithOutUsingXml;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.krishnaraddi.CrudOperationWithOutUsingXml.entity.Student;
import com.krishnaraddi.CrudOperationWithOutUsingXml.service.StudentDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner scan=new Scanner(System.in);
    	
    	ApplicationContext context=new AnnotationConfigApplicationContext(AnotationConfig.class);
    	StudentDao bean = context.getBean("studentDao",StudentDao.class);

    	App app=new App();
    	boolean flag=true;
    	while(flag) {
    		System.out.println("press 1 to insert an element");
    		System.out.println("press 2 to delete an element");
    		System.out.println("press 3 to update an element");
    		System.out.println("press 4 to fetch a student");
    		System.out.println("press 5 to fetch all students in a database");
    		Student stud=new Student();
    		int key=scan.nextInt();
    		switch (key) {
			case 1:
				
				System.out.println("enter the id to generate");
				int id=scan.nextInt();
				System.out.println("enter the name");
				String name=scan.next();
				System.out.println("enter the collge");
				String college=scan.next();
				
				stud.setId(id);
				stud.setName(name);
				stud.setCollege(college);
				
				bean.createData(stud);
				System.out.println("data created sucessfully!!");
				break;
			case 2:
				System.out.println("enter the id to delete an student");
				 id=scan.nextInt();
				 stud.setId(id);
				 bean.deleteData(stud);
				 System.out.println("data deleted sucessfully!!");
				break;
			case 3:
				System.out.println("enter the id need to be updated");
				id=scan.nextInt();
				System.out.println("enter the name");
				name=scan.next();
				System.out.println("enter the college");
				college=scan.next();
				
				bean.updateData(stud);
				break;
				
			case 4:
				System.out.println("enter the id need to fetch an element");
				id=scan.nextInt();
				Student student = bean.getStudent(id);
				System.out.println(student);
				break;
			case 5:
				List<Student> allStudent = bean.getAllStudent();

				for (Student student2 : allStudent) {
					System.out.println(student2);
				}
				break;

			default:
				System.out.println("u have pressed an invalid input please try to rerun the application again");
				flag=false;
				break;
			}
    		
    	}
    
    }
}
