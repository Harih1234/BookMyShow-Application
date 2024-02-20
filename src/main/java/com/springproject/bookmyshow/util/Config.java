package com.springproject.bookmyshow.util;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
@Configuration
public class Config implements WebMvcConfigurer {

	@Bean
	public OpenAPI swaggerDocOpenApi()
	{
		Server devserver = new Server();
		devserver.setUrl("localhost:8080");
		devserver.setDescription("Development Server");
		
		Server testserver = new Server();
		testserver.setUrl("localhost:8081");
		testserver.setDescription("Development Server");
		
		Contact co = new Contact();
		co.setEmail("uhariharan1999@gamil.com");
		co.setName("HariName");
		co.setUrl("../https://github.com");
		
		License li = new License();
		li.setName("License");
		li.setUrl("license providers");
		
		Info in =new Info();
		in.setContact(co);
		in.setLicense(li);
		in.setDescription("BookMyShow: TicketBooking Project ");
		
		in.setTermsOfService("https://www.youtube.com/");
		in.setTitle("BookMyShow");
		in.setVersion("2.0");
		
		OpenAPI op = new OpenAPI();
		op.info(in);
		op.servers(Arrays.asList(devserver,testserver));
		return op;
	}
}
