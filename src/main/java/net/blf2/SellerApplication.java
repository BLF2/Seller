package net.blf2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "net.blf2.dao")
public class SellerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SellerApplication.class, args);
	}
}
