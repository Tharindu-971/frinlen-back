package com.techscroll.frinlen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
public class SpringBootFinlenApplication {

	public static void main(String[] args) {
    SpringApplication.run(SpringBootFinlenApplication.class, args);
	}

}
