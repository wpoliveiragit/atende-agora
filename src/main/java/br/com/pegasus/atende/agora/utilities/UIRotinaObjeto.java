package br.com.pegasus.atende.agora.utilities;

/**
 * Cria uma rotina para que seja executada dentro de uma thread.
 *
 * Existe um método de inicilização de atributos que pode sofrer sobreposição
 * com o cabeçalho 'protected void inicializador()'
 *
 * @author Wellington Pires de Oliveira.
 * @date 26/06/2018.
 */
public abstract class UIRotinaObjeto {

	private final int tempo;

	/**
	 * Cria uma instância para executar a rotina de tempo em tempo.
	 *
	 * @param tempo O tempo em que a thread atualizará a base gráfica. Tempo < 1
	 *              indica que será atualizado sem delay.
	 */
	public UIRotinaObjeto(int tempo) {
		this.tempo = tempo;
	}

	/**
	 * Rotina de execução da thread.
	 */
	abstract protected void rotina();

	public void iniciar() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				if (tempo < 1) {// Rotina sem tempo de atualização
					rotinaSemTempo();
				} else {// Rotina com tempo de atualização
					rotinaComTempo();
				}
			}

			/**
			 * Executa a rotina sem tempo de atualização
			 */
			private void rotinaComTempo() {
				while (true) {
					try {
						rotina();
						Thread.sleep(tempo);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			}

			/**
			 * Executa a rotina sem um tempo de atualização.
			 */
			private void rotinaSemTempo() {
				while (true) {
					rotina();
				}
			}
		}).start();
	}

	/* TESTE DA CLASSE **********************************************************/
	public static void main(String[] args) {
		UIRotinaObjeto t = new UIRotinaObjeto(1000) {
			int x = 0;

			@Override
			public void rotina() {
				System.out.println(x++);
			}

		};
		t.iniciar();
	}

}
