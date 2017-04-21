package com.marcelo.conilho.tg.controller;

import com.marcelo.conilho.tg.model.Course;
import com.marcelo.conilho.tg.model.Student;
import com.marcelo.conilho.tg.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/addStudent", method = RequestMethod.POST)
    public String addOneStutent(@ModelAttribute Student s) {
        System.out.println(s.toString());
        studentRepository.save(s);
        return "da uma olhada lá" + s.toString();
    }

    @RequestMapping("/getStudent")
    public Student getStudant(@RequestParam("ra") String ra){
        return studentRepository.findOne(ra);
    }
}
