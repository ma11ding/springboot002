package org.rico.demo.Service;

import lombok.Data;
import org.rico.demo.domain.Student;
import org.rico.demo.repository.StudentCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rico.Chen on 2017/2/23.
 */
@Service
@Transactional
@Data
public class StudentServiceImpl implements  StudentService {

    @Autowired
   private StudentCrudRepository studentGrudRepository;

    @Override
    public Student getStudent(Long id) {
        return  this.studentGrudRepository.findOne(id);
    }

    /**
     *
     * @param page 第几页
     * @param size 每页多少人
     * @return
     */
    @Override
    public Page<Student> getStudents(int page, int size) {
        return this.studentGrudRepository.findAll(new PageRequest(page-1,size));

    }

    @Override
    public List<Student> allStudents() {
        List<Student> list=(List<Student>) this.studentGrudRepository.findAll();

        return list;
    }

    @Override
    public void addStudent(Student student) {
        this.studentGrudRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        this.studentGrudRepository.delete(id);
    }

    @Override
    public void modefice(Long id,String name, int age) {
        Student stu=new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        Student student=this.studentGrudRepository.findOne(id);
        if(student!=null){
            this.studentGrudRepository.save(stu);
        }else{
            //报错
        }
    }




//    @Autowired
//    private StudentRepository studentRepository;

  /*
    @Autowired
    private StudentCrudRepository studentCrudRepository;

    @Override
    public Student getStudent(Long id) {
//        return this.studentRepository.findStudent(id);
        return this.studentCrudRepository.findOne(id);
    }

    public void createStudent(String name, Integer age) {
        Student student = new Student(name, age);
        this.studentCrudRepository.save(student);
    }

    public void modifyStudent(String newName, Integer newAge, Long id) {
        if(this.studentCrudRepository.exists(id)) {
            Student student = this.studentCrudRepository.findOne(id);
            student.setName(newName);
            student.setAge(newAge);
            this.studentCrudRepository.save(student);
        } else {
            throw new RuntimeException("无[id=" + id + "]的Item.");
        }
    }

    public void removeStudent(Long id) {
        if(this.studentCrudRepository.exists(id)) {
            Student student = this.studentCrudRepository.findOne(id);
            this.studentCrudRepository.delete(student);
        } else {
            throw new RuntimeException("无[id=" + id + "]的Item.");
        }
    }

    public Iterable<Student> getStudents() {
        return this.studentCrudRepository.findAll();
    }

    *//**
     *
     * @param page 第几页
     * @param size 每页多少人
     * @return
     *//*
    public Page<Student> getStudents(int page, int size) {


        //this.studentCrudRepository



        *//**
         * page 0 = 第一页
         * page 1 = 第二页
         * .....
         *//*
        return this.studentCrudRepository.findAll(new PageRequest(page - 1, size));

    }*/


}
