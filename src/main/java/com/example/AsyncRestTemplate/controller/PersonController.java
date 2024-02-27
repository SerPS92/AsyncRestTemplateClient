package com.example.AsyncRestTemplate.controller;


import com.example.AsyncRestTemplate.model.Person;
import com.example.AsyncRestTemplate.service.IAccessService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class PersonController {

    private final IAccessService accessService;

    public PersonController(IAccessService accessService) {
        this.accessService = accessService;
    }

    @GetMapping(value = "/people/{name}/{email}/{age}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> addPerson(@PathVariable(name = "name")String name,
                                  @PathVariable(name = "email")String email,
                                  @PathVariable(name = "age") int age) {
        Person person = new Person(name, email, age);
        CompletableFuture<List<Person>> result =  accessService.callService(person);

        for(int i = 0; i<10; i++){
            System.out.println("Waiting...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }

        try {
            return result.get();
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
            return null;
        }
    }
}
