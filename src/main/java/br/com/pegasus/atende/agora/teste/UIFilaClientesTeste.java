package br.com.pegasus.atende.agora.teste;

import br.com.pegasus.atende.agora.fila.FilaClientes;
import br.com.pegasus.atende.agora.ui.fila.UIFilaClientes;
import br.com.pegasus.atende.agora.ui.frame.UIFrame;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 18/10/2018.
 */
public class UIFilaClientesTeste {

	public static void main(String[] args) {
		FilaClientes f = new FilaClientes(1000, 15);
		f.iniciar();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						if (25 > br.com.pegasus.atende.agora.utilitarios.Geral.RANDOM.nextInt(100)) {
							f.remove();
						}
						Thread.sleep(400);
					} catch (InterruptedException ex) {

					}
				}
			}
		}).start();

		new UIFrame(new UIFilaClientes(f));

	}
}
