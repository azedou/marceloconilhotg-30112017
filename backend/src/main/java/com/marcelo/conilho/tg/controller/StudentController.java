package com.marcelo.conilho.tg.controller;

import com.marcelo.conilho.tg.model.Student;
import com.marcelo.conilho.tg.repository.StudentRepository;
import com.marcelo.conilho.tg.service.GenerateAllStudentsDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
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
    public String addOneStutent(@RequestBody Student s) {
        System.out.println(s);
        studentRepository.save(s);
        return "da uma olhada lá " + s.toString();
    }

    @RequestMapping(value="/getStudent")
    public Student getStudant(@RequestParam("ra") String ra){
        return studentRepository.findOne(ra);
    }
    
    @DeleteMapping(value="/deleteStudent")
    public void deleteStudant(@RequestParam("ra") String ra){
        Student s = studentRepository.findOne(ra);
        try {
            studentRepository.delete(s);
        }catch(Exception err){
            System.out.println(err);
        }
    }

    @RequestMapping(value="/generateStudentCertificate", method = RequestMethod.GET)
    public ResponseEntity<byte[]> generateStudentCertificate( HttpServletRequest request) throws Exception {
        generateAllStudentsDocument.createPDFwithItext("Marcelo Conilho");
        byte[] contents = Files.readAllBytes(new File("TESTPDF.pdf").toPath());
       
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "output.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        return response;
    }
}
