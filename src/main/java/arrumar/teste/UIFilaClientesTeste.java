package arrumar.teste;

import arrumar.code.ui.fila.UIFilaClientes;
import arrumar.code.ui.frame.UIFrame;
import br.com.wellington.atendeAgora.fila.FilaClientes;

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
						if (25 > arrumar.code.utilitarios.Geral.RANDOM.nextInt(100)) {
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
