package com.example.demo.dao;

import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.service.invoker.HttpServiceArgumentResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarDAOImpl implements BaseDAO<Car> {


    private EntityManager entityManager;

    @Autowired
    public CarDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public Car find(int id) {
        Optional<Car> c = Optional.ofNullable(entityManager.find(Car.class, id));
        if (c.isPresent()){
            Car car = c.get();
            return car;
        }
        return null;
    }

    @Override
    public List<Car> findAll() {
        TypedQuery<Car> q = entityManager.createQuery("FROM Car", Car.class);
        return  q.getResultList();

    }

    @Override
    public List<Car> findByName(String name) {
        TypedQuery<Car> q = entityManager.createQuery("From Car where name = :carName", Car.class);
        q.setParameter("carName", name);
        return q.getResultList();
    }

    @Override
    @Transactional
    public int delete(int id) {
        Optional<Car> c = Optional.ofNullable(entityManager.find(Car.class, id));
        if (c.isPresent()) {
            entityManager.remove(c.get());
            return 1;
        }
        return 0;
    }

    @Override
    @Transactional
    public int save(Car car) {
        entityManager.persist(car);
        return 1;
    }

    @Override
    @Transactional
    public Car Update(int id, Car car) {
        Optional<Car> cr = Optional.ofNullable(entityManager.find(Car.class, id));
        if (cr.isPresent()) {
            Car c = cr.get();
            car.setId(c.getId());
            if (car.getBrand() == null || car.getBrand().isBlank()) {
                car.setBrand(c.getBrand());
            } if (car.getName() == null ||car.getName().isBlank()) {
                car.setName(c.getName());
            }
            if (car.getYear() == null || car.getYear() == 0 || car.getYear() < 0) {
                car.setYear(c.getYear());
            }
            entityManager.merge(car);
            return car;
        }
        return null;

    }
}
