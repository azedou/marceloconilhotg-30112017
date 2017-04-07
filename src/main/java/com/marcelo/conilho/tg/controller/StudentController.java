package com.marcelo.conilho.tg.controller;

import com.marcelo.conilho.tg.model.Student;
import com.marcelo.conilho.tg.repository.StudentRepository;
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
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value="/allStudents", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @RequestMapping(value="/addStudent{ra}{name}")
    @ResponseBody
    public String addOneStutent(@PathVariable("ra") String ra, @PathVariable("name") String name) {
        studentRepository.save(new Student(ra, name));
        return "ta uma olhada lá";
    }

    @RequestMapping("getStudent{ra}")
    public Student getStudant(@PathVariable("ra") String ra){
        return studentRepository.findOne(ra);
    }
}
