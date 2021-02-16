package br.com.wellington.atendeAgora.ui.pessoa;

import br.com.wellington.atendeAgora.ticket.TicketImp;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 19/10/2018.
 */
public interface ClienteImp extends PessoaImp {

	public TicketImp getTicket();
}
