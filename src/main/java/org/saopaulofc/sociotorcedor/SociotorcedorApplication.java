package org.saopaulofc.sociotorcedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SociotorcedorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SociotorcedorApplication.class, args);
	}


}
