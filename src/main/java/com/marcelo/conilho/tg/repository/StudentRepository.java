package com.marcelo.conilho.tg.repository;

import com.marcelo.conilho.tg.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by marce on 05/04/2017.
 */
public interface StudentRepository extends MongoRepository<Student, String>{

    @Override
    List<Student> findAll();

    @Override
    Student findOne(String ra);
}
