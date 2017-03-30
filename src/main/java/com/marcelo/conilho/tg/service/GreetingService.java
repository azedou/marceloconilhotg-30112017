package com.marcelo.conilho.tg.service;

import com.marcelo.conilho.tg.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

/**
 * Created by marce on 18/03/2017.
 */

@Service
public class GreetingService {
    Hashtable<String, Greeting> greetings = new Hashtable<String, Greeting>();
    public GreetingService(){
        Greeting greeting =  new Greeting();
        greeting.setContent("greeting1");
        greeting.setId(1);
        greetings.put("1", greeting);

        greeting.setContent("greeting2");
        greeting.setId(2);
        greetings.put("2", greeting);
    }

    public Greeting getGreeting(String id){
        if(greetings.containsKey(id)){
            return greetings.get(id);
        }
        return null;
    }

    public Hashtable<String, Greeting> getAllGreetings() {
        return greetings;
    }
}
