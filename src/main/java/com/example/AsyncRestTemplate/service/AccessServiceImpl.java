package com.example.AsyncRestTemplate.service;

import com.example.AsyncRestTemplate.model.Person;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AccessServiceImpl implements IAccessService {

    private final RestTemplate restTemplate;
    String url = "http://localhost:8080";

    public AccessServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async
    public CompletableFuture<List<Person>> callService(Person person){
        restTemplate.postForLocation(url + "/contacts", person);
        Person[] people = restTemplate.getForObject(url + "/contacts", Person[].class);
        return CompletableFuture.completedFuture(Arrays.asList(people));

    }
}
