package com.marcelo.conilho.tg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by marce on 05/04/2017.
 */
@Document(collection = "students")
public class Student {

    @Id
    String ra;

    String name;

    public Student() {
    }

    public Student(String ra, String name) {
        this.ra = ra;
        this.name = name;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
