package com.marcelo.conilho.tg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by marce on 05/04/2017.
 */
@Document(collection = "studants")
public class Studant {
    @Id
    private int ra;

    String name;

    public Studant() {
    }

    public Studant(int ra, String name) {
        this.ra = ra;
        this.name = name;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
