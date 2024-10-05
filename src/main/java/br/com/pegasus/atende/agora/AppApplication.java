package br.com.pegasus.atende.agora;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.pegasus.atende.agora.ui.sistema.Sistema;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		// SpringApplication.run(AtendeAgoraApplication.class, args);
		new Sistema().iniciar();
	}

}
