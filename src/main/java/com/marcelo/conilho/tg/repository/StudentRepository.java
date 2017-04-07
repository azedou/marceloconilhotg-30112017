package com.marcelo.conilho.tg.repository;

import com.marcelo.conilho.tg.model.Studant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by marce on 05/04/2017.
 */
public interface StudantRepository extends MongoRepository<Studant, String>{

    @Override
    List<Studant> findAll();

    @Override
    Studant findOne(String ra);
}
