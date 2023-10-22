package com.example.demo.dao;

import com.example.demo.entity.BaseResponse;

import java.util.Optional;
import java.util.List;

public interface BaseDAO<T> {
    T find(int id);
    List<T> findAll();
    List<T> findByName(String name);
    int delete(int id);
    int save(T t);
    T Update(int id, T c);
}
