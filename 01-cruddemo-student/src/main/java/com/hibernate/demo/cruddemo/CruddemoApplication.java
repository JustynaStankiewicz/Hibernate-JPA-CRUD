package com.hibernate.demo.cruddemo;

import com.hibernate.demo.cruddemo.dao.StudentDAO;
import com.hibernate.demo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO ) {

		return runner->{
			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("Ann","Jaworska","annjawor@co.com");
		Student tempStudent2 = new Student("Krist","StanKhan","stankkhan@co.com");
		Student tempStudent3 = new Student("Robert","Kaput","kapitanbomba@co.com");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Jan","Kowalski","jkowal@co.com");
		studentDAO.save(tempStudent);
		System.out.println("Saved student. Generated id: "+ tempStudent.getId());

	}


}
