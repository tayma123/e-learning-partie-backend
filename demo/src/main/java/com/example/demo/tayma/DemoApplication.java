package com.example.demo.tayma;

import com.example.demo.tayma.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		StorageProperties.class
})
public class DemoApplication {
	 public static void main(String[] args) {

		 SpringApplication.run(DemoApplication.class, args);

	 }
}
