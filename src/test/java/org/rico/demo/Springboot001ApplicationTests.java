package org.rico.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rico.demo.Service.StudentService;
import org.rico.demo.domain.Student;
import org.rico.demo.repository.StudentCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot001ApplicationTests {

//	@Autowired
//	private StudentService studentService;

	@Autowired
	private StudentCrudRepository studentCrudRepository;

	@Test
	public void contextLoads() {

//		Page<Student> students = this.studentService.getStudents(1, 3);
//	 	Page<Student> students =  this.studentCrudRepository.findAll(new PageRequest(1, 3));
//		for(Student student : students.getContent()) {
//			log.info(student.toString());
//		}

		Student student = this.studentCrudRepository.findOne(1l);
		log.info(student.toString());

	}
	@Test
	public void pageStudents(){
		Page<Student> students=this.studentCrudRepository.findAll(new PageRequest(1, 3));
		log.info(students.toString());
	}
	@Test
	public  void delete(){
		this.studentCrudRepository.delete(1l);
		log.info("--成功--");
	}
	@Test
	public void save(){
		Student s=new Student();
		s.setAge(22);
		s.setName("我在");
		this.studentCrudRepository.save(s);
	}

	@Test
	public void findAll(){
		List<Student> list=(List<Student>) this.studentCrudRepository.findAll();
		log.info(list.toString());
	}

}
