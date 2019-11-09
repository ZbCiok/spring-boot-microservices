package eu.zbciok.microservice.example.subtraction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan
public class SubtractionServer {
	public static void main(String[] args) {
		SpringApplication.run(SubtractionServer.class, args);
	}
}
