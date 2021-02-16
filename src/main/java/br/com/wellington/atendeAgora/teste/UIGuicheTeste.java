package br.com.wellington.atendeAgora.teste;

import br.com.wellington.atendeAgora.fila.FilaClientes;
import br.com.wellington.atendeAgora.guiche.Guiche;
import br.com.wellington.atendeAgora.ui.fila.ListaAtendentes;
import br.com.wellington.atendeAgora.ui.frame.UIFrame;
import br.com.wellington.atendeAgora.ui.guiche.UIListaGuiche;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 18/10/2018.
 */
public class UIGuicheTeste {

	// * TESTE ******************************************************************
	public static void main(String[] args) {
		ListaAtendentes lista = new ListaAtendentes();

		FilaClientes fila = new FilaClientes(1000, 15);
		fila.iniciar();

		Guiche g = new Guiche(lista, fila);
		g.iniciar();

		UIListaGuiche gui = new UIListaGuiche(g, 10, 10);

		new UIFrame(gui);
	}
}
