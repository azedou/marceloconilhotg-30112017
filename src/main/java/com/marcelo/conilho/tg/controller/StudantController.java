package com.marcelo.conilho.tg.controller;

import com.marcelo.conilho.tg.model.Studant;
import com.marcelo.conilho.tg.repository.StudantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by marce on 05/04/2017.
 */
@RestController
public class StudantController {

    @Autowired
    StudantRepository studantRepository;

    @RequestMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Studant> getAll() {
        return studantRepository.findAll();
    }

    @RequestMapping(value="/one", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addOneStutent() {
        studantRepository.save(new Studant(123456, "Marcelo"));
        return "ta uma olhada lá";
    }

    @RequestMapping("{ra}")
    public Studant getStudant(@PathVariable("ra") String ra){
        return studantRepository.findOne(ra);
    }
}
