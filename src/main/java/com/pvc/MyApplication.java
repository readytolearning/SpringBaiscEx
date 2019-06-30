package com.pvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author P.Venkatesh 
 *
 */
@SpringBootApplication
//@EnableScheduling
public class MyApplication {
	public static void main(String[] args) {
		
		SpringApplication.run(MyApplication.class, args);
		
	}
}