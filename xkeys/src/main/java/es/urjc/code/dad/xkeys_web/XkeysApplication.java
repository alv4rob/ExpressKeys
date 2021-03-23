 package es.urjc.code.dad.xkeys_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class XkeysApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(XkeysApplication.class, args);
	}
}