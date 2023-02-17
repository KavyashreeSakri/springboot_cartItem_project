package spring_Cart_Item.annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "spring_Cart_Item.annotation" })
public class CartItemConfig {
	@Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	@Bean
	public Scanner getScanner() {
		return new Scanner(System.in);
	}

	@Bean
	public List<Item> getList() {
		return new ArrayList<Item>();
	}

}
