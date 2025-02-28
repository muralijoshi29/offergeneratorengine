package com.org.offergeneratorengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@ComponentScan(basePackages = {"com"})
@EntityScan( basePackages = {"com.org.offergenerator.model"} )
@EnableAutoConfiguration
@SpringBootApplication
@EnableMongoRepositories("com.org.offergenerator.repository")
@EnableEurekaClient
public class OffergeneratorengineApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(OffergeneratorengineApplication.class, args);
	}

}
