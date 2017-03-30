package com.marcelo.conilho.tg.controller;

import com.marcelo.conilho.tg.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;

/**
 * Created by marce on 30/03/2017.
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "INDEX";
    }

}
