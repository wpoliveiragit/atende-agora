package br.com.pegasus.atende.agora.ui.pessoa;

import br.com.pegasus.atende.agora.ticket.TicketImp;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 19/10/2018.
 */
public interface ClienteImp extends PessoaImp {

	public TicketImp getTicket();
}
