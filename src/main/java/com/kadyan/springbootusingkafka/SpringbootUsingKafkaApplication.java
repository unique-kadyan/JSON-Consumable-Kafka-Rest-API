package com.kadyan.springbootusingkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringbootUsingKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootUsingKafkaApplication.class, args);
	}

}