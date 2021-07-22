package com.example.demo;

import com.example.demo.storage.StorageProperties;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({
		StorageProperties.class
})
public class DemoApplication {
	 public static void main(String[] args) {

		 SpringApplication.run(DemoApplication.class, args);

	 }
}
