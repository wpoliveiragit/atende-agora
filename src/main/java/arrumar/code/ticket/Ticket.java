
package arrumar.code.ticket;

import arrumar.code.problema.Problema;
import arrumar.code.ui.ticket.TicketImp;

/**
 * Ticket que o cliente recebe ao ser criado onde define o problema que ele
 * possui.
 *
 * @author Wellington Pires de Oliveira.
 * @date 28/09/2018.
 */
public class Ticket implements TicketImp {

	/**
	 * Representa o problema que o cliente possui.
	 */
	private final Problema problema;
	/**
	 * Guarda o tempo em que o cliente passou sendo atendido.
	 */
	private int tempo;

	/**
	 * Define o estado de resolução do problema.
	 */
	private boolean resolvido;

	/**
	 * Cria o ticket do cliente.
	 *
	 * @param problema O problema que ele possui.
	 */
	public Ticket(Problema problema) {
		this.problema = problema;
		tempo = 0;
		resolvido = false;
	}

	/**
	 * Retorna o problema.
	 *
	 * @return O problema.
	 */
	public Problema getProblema() {
		return problema;
	}

	/**
	 * Configura o tempo que o cliente levou para ser atendimento no guiche.
	 *
	 * @param tempo O tempo que o cliente levou para ser atendimento no guiche.
	 */
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	/**
	 * Retorna o tempo que o cliente levou para ser atendimento no guiche
	 *
	 * @return O tempo que o cliente levou para ser atendimento no guiche
	 */
	@Override
	public int getTempo() {
		return tempo;
	}

	/**
	 * Informa o estado de resolução do problema.
	 *
	 * @return true para resolvido.
	 */
	@Override
	public boolean isResolvido() {
		return resolvido;
	}

	/**
	 * Configura um novo estado de resolução para o problema do cliente.
	 *
	 * @param resolvido O estado de resolução do problema.
	 */
	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}

	@Override
	public char getTipo() {
		return problema.getNome();
	}

}
