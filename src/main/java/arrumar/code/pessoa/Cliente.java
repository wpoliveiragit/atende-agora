package arrumar.code.pessoa;

import arrumar.code.ticket.Ticket;
import arrumar.code.ui.pessoa.ClienteImp;

/**
 * Representa um cliente do simulador.
 *
 * @author Wellington Pires de Oliveira.
 * @date 21/09/2018.
 */
public final class Cliente extends Pessoa implements ClienteImp {

	/**
	 * O problema que o cliente possui.
	 */
	private final Ticket problema;

	/**
	 * Cria um cliente do sistema.
	 */
	public Cliente() {
		super(-1);
		problema = new Ticket(PessoaStatic.gerarProblema());
	}

	/**
	 * Retorna o ticket que o cliente possui.
	 *
	 * @return O ticket que o cliente possui.
	 */
	@Override
	public Ticket getTicket() {
		return problema;
	}

	@Override
	public String getDados() {
		return null;
	}

}
