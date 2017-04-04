package com.marcelo.conilho.tg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
