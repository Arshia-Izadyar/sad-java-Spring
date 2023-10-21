package com.spring.app1.dao;

import com.spring.app1.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student find(int id){
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> q = entityManager.createQuery("FROM Student", Student.class);
        return q.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student){
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student s = entityManager.find(Student.class, id);
        entityManager.remove(s);
    }

    @Override
    public List<Student> find_by_name(String name) {
        TypedQuery<Student> q = entityManager.createQuery("FROM Student WHERE lastName=:lastname", Student.class);
        q.setParameter("lastname", name);
        return q.getResultList();
    }


}
