package org.rico.demo.Service;

import org.rico.demo.domain.Student;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Rico.Chen on 2017/2/23.
 */
public interface StudentService {

    public Student getStudent(Long id);

    public Page<Student> getStudents(int page, int size);

    public List<Student> allStudents();

    public void addStudent (Student st);

    public void delete(Long id);

    public void modefice(Long id,String name,int age);


}
