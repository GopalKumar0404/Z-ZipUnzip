package com.gopal.Gzip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class GZipApplication {

	public static void main(String[] args) {
		SpringApplication.run(GZipApplication.class, args);
	}

}
