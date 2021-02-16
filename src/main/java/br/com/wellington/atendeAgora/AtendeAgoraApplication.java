package br.com.wellington.atendeAgora;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import arrumar.code.sistema.Sistema;

@SpringBootApplication
public class AtendeAgoraApplication {

	public static void main(String[] args) {
		// SpringApplication.run(AtendeAgoraApplication.class, args);
		new Sistema().iniciar();
	}

}
