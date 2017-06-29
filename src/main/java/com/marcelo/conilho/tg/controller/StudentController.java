package com.marcelo.conilho.tg.controller;

import com.marcelo.conilho.tg.model.Student;
import com.marcelo.conilho.tg.repository.StudentRepository;
import com.marcelo.conilho.tg.service.GenerateAllStudentsDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by marce on 05/04/2017.
 */
@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    GenerateAllStudentsDocument generateAllStudentsDocument = new GenerateAllStudentsDocument();

    @RequestMapping(value="/allStudents", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @RequestMapping("/editDOCX")
    public String getStudant() throws Exception {
        generateAllStudentsDocument.replaceNameWithVelocity("Marcelo Conilho");
            return "deu bom ";
    }
}
