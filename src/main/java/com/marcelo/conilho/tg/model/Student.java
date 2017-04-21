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

    String email;

    String course;

    String cycle;

    String theme;

    String discipline;

    public Student() {
    }

    public Student(String ra, String name, String email, String course, String cycle, String theme, String discipline) {
        this.ra = ra;
        this.name = name;
        this.email = email;
        this.course = course;
        this.cycle = cycle;
        this.theme = theme;
        this.discipline = discipline;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
