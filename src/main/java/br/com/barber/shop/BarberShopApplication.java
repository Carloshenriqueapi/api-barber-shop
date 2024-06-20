package br.com.barber.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.barber.shop")
@EnableJpaRepositories(basePackages = "br.com.barber.shop.infrastructure.database.repository")
@EntityScan(basePackages = "br.com.barber.shop.infrastructure.database.entity")
public class BarberShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarberShopApplication.class, args);
	}

}
