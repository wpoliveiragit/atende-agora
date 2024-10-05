package br.com.pegasus.atende.agora.ui.pessoa;

import br.com.pegasus.atende.agora.ticket.TicketImp;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 04/10/2018.
 */
public class UICliente extends UIPessoa implements ClienteImp {

	private final ClienteImp cliente;

	public UICliente(ClienteImp cliente, int x, int y) {
		super(cliente, x, y);
		this.cliente = cliente;
	}

	/**
	 * Retorna o ticket do cliente.
	 *
	 * @return O ticket do cliente.
	 */
	@Override
	public TicketImp getTicket() {
		return cliente.getTicket();
	}

	@Override
	public String getDados() {
		return cliente.getDados();
	}

}
