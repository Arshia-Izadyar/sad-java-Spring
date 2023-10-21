package com.spring.app1.dao;
import com.spring.app1.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {

    void save(Student student);

    Student find(int id);
    List<Student> findAll();
    List<Student> find_by_name(String name);
    void update(Student student);
    void delete(int id);
}
