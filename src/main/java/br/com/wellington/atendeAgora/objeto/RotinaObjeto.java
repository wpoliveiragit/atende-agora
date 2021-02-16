package br.com.wellington.atendeAgora.objeto;

/**
 * Cria uma rotina para que seja executada.
 *
 * @author Wellington Pires de Oliveira.
 * @date 26/06/2018.
 */
public abstract class RotinaObjeto implements BaseRotinaObjeto {

	/* ATRIBUTOS ****************************************************************/
	private boolean loop;// Controle de repetição da thread.
	private final int tempo;

	/* CONSTRUTORES *************************************************************/
	/**
	 * Cria uma instância para executar a rotina de tempo em tempo.
	 *
	 * @param tempo O tempo em que a thread atualizará a base gráfica. Tempo < 1
	 *              indica que será atualizado sem delay.
	 */
	public RotinaObjeto(int tempo) {
		this.tempo = tempo;
	}

	/* MÉTODOS ******************************************************************/
	/**
	 * Rotina de execução da thread.
	 */
	abstract protected void rotina();

	/**
	 * Assim que for solicitada a finalização da rotina , será concluido o último
	 * processo, esse método será executado e a rotina será finalizada.
	 */
	abstract protected void rotinaFinalizar();

	@Override
	public void iniciar() {
		if (loop) {
			return;
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				loop = true;
				if (tempo < 1) {// Rotina sem tempo de atualização
					rotinaSemTempo();
				} else {// Rotina com tempo de atualização
					rotinaComTempo();
				}
				rotinaFinalizar();
			}

			/**
			 * Executa a rotina sem tempo de atualização
			 */
			private void rotinaComTempo() {
				while (loop) {
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
				while (loop) {
					rotina();
				}
			}
		}).start();
	}

	@Override
	public void finalizar() {
		loop = false;
	}

	/**
	 * Informa se a torina esta ativa.
	 *
	 * @return true para rotina ativada.
	 */
	public boolean isAtivo() {
		return loop;
	}

	/* TESTE DA CLASSE **********************************************************/
	public static void main(String[] args) {
		RotinaObjeto t = new RotinaObjeto(1000) {
			int x = 0;

			@Override
			public void rotina() {
				System.out.println(x++);
			}

			@Override
			protected void rotinaFinalizar() {
				System.out.println("Finalizando rotina");
			}
		};
		t.iniciar();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		t.finalizar();
	}

}
