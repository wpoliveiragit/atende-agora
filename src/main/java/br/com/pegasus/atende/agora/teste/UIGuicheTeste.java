package br.com.pegasus.atende.agora.teste;

import br.com.pegasus.atende.agora.fila.FilaClientes;
import br.com.pegasus.atende.agora.guiche.Guiche;
import br.com.pegasus.atende.agora.ui.fila.ListaAtendentes;
import br.com.pegasus.atende.agora.ui.frame.UIFrame;
import br.com.pegasus.atende.agora.ui.guiche.UIListaGuiche;

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
