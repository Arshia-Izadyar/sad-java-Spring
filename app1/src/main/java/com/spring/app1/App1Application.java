package com.spring.app1;

import com.spring.app1.dao.StudentDAO;
import com.spring.app1.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication(scanBasePackages = {"lmao", "com.spring.app1"})
public class App1Application {

	public static void main(String... args) {
		SpringApplication.run(App1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
			crudTasks(studentDAO);
		};
	}

	private void crudTasks(StudentDAO studentDAO) {
//		Student s1 = new Student("arshia2", "izad2", "email2@gmail.com");
//		Student s2 = new Student("arshia3", "izad3", "email3@gmail.com");
//		Student s3 = new Student("arshia4", "izad4", "email4@gmail.com");

		// create user
//		studentDAO.save(s1);
//		studentDAO.save(s2);
//		studentDAO.save(s3);
//

		// get by id
//		System.out.println("Student id := "+s1.getId());
//		System.out.println("Student id := "+s2.getId());
//		System.out.println("Student id := "+s3.getId());
//		Student s = studentDAO.find(1);
//		Student s3 = studentDAO.find(3);
//		System.out.println(s);
//		System.out.println(s3);


		// find by name and find all
//		List<Student> sList = studentDAO.find_by_name("izasssd");
//		List<Student> sList2 = studentDAO.findAll();
//		System.out.println(sList2);
//		System.out.println(sList);

		// update
		Student s = studentDAO.find(1);
		s.setFirstName("konkesh");
		studentDAO.update(s);
		Student s2 = studentDAO.find(1);
		System.out.println(s2);
		Student s33 = studentDAO.find(3);
		System.out.println(s33);
//		studentDAO.delete(3);
		Optional<Student> s331 = Optional.ofNullable(studentDAO.find(3));
		if (s331.isPresent()){
			System.out.println(s331);

		} else {
			System.out.println("not found");
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		Student s = new Student("arshia", "izad", "email@gmail.com");

		studentDAO.save(s);

		System.out.println("Student id := "+s.getId());

	}

}
