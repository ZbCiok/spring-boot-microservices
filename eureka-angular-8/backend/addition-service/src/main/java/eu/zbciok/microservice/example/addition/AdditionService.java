package eu.zbciok.microservice.example.addition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan
public class AdditionService {
	public static void main(String[] args) {
		SpringApplication.run(AdditionService.class, args);
	}
}