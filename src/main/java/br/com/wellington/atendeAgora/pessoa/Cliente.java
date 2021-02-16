package br.com.wellington.atendeAgora.pessoa;

import br.com.wellington.atendeAgora.ui.pessoa.ClienteImp;
import br.com.wellington.atendeAgora.ui.ticket.Ticket;

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
