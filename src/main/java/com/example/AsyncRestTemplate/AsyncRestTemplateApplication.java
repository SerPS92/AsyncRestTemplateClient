package com.example.AsyncRestTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.SpringVersion;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@EnableAsync
@SpringBootApplication
public class AsyncRestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncRestTemplateApplication.class, args);
		System.out.println(SpringVersion.getVersion());
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public Executor executor(){
		return new ThreadPoolTaskExecutor();
	}

}
