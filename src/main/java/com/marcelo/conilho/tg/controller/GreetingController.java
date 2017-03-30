package com.marcelo.conilho.tg.controller;

import com.marcelo.conilho.tg.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marcelo.conilho.tg.service.GreetingService;

import java.util.Hashtable;

@RestController
public class GreetingController {

    @Autowired
    GreetingService gs;

    @RequestMapping("/all")
    public Hashtable<String, Greeting> getAll() {
        return gs.getAllGreetings();
    }

    @RequestMapping("{id}")
    public Greeting getGreeting(@PathVariable("id") String id){
        return gs.getGreeting(id);
    }
}