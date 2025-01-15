package br.com.pegasus.atende.agora.ui.problema;

import java.util.ArrayList;
import java.util.List;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 25/09/2018.
 */
public class ControleProblemas {

	/**
	 * Guarda todos os problemas existentes
	 */
	public final static List<Problema> PROBLEMAS;

	static {
		PROBLEMAS = new ArrayList<>();
		PROBLEMAS.add(new Problema('A', 1000, 26));
		PROBLEMAS.add(new Problema('B', 1500, 28));
		PROBLEMAS.add(new Problema('C', 2000, 30));
		PROBLEMAS.add(new Problema('D', 2500, 32));
		PROBLEMAS.add(new Problema('E', 3000, 34));
		PROBLEMAS.add(new Problema('F', 3500, 36));
		PROBLEMAS.add(new Problema('G', 4000, 38));
		PROBLEMAS.add(new Problema('H', 4500, 40));
		PROBLEMAS.add(new Problema('I', 5000, 42));
	}

}
