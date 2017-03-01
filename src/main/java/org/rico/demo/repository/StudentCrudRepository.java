package org.rico.demo.repository;

import org.rico.demo.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rico.Chen on 2017/2/23.
 */
@Repository
public interface StudentCrudRepository extends CrudRepository<Student, Long> {

    Iterable<Student> findAll();

    Page<Student> findAll(Pageable pageable);

    Student findByName(String name);

}
