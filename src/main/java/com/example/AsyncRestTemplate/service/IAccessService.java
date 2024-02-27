package com.example.AsyncRestTemplate.service;

import com.example.AsyncRestTemplate.model.Person;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IAccessService {
    CompletableFuture<List<Person>> callService(Person person);
}
