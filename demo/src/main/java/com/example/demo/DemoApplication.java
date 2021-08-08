package com.example.demo;

import com.example.demo.tayma.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableWebMvc
@EnableConfigurationProperties({
		StorageProperties.class
})
public class DemoApplication {
	 public static void main(String[] args) {

		 SpringApplication.run(DemoApplication.class, args);

	 }
}
