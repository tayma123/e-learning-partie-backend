package com.example.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
	 public static void main(String[] args) {

		 ConfigurableApplicationContext ctx=  SpringApplication.run(DemoApplication.class, args);
	ApprenantRepository apprenantRepository=ctx.getBean(ApprenantRepository.class);
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 try {
			 apprenantRepository.save(new Apprenant("tayma","benhmida",df.parse("1998-07-13")));
		   List<Apprenant> apps=apprenantRepository.findAll();
		 } catch (ParseException e) {
			 e.printStackTrace();
		 }


	 }

}
