package br.com.petz.clientepet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
public class ClientePetApplication {

	public static void main(String[] args) {

		SpringApplication.run(ClientePetApplication.class, args);
	}

}
