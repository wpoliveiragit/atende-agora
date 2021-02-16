package arrumar.teste;

import arrumar.code.guiche.Guiche;
import arrumar.code.ui.fila.ListaAtendentes;
import arrumar.code.ui.frame.UIFrame;
import arrumar.code.ui.guiche.UIListaGuiche;
import br.com.wellington.atendeAgora.fila.FilaClientes;

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
