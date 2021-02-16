package br.com.wellington.atendeAgora;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.wellington.atendeAgora.ui.sistema.Sistema;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		// SpringApplication.run(AtendeAgoraApplication.class, args);
		new Sistema().iniciar();
	}

}
