package arrumar.code.guiche;

import static arrumar.code.utilitarios.Geral.threadSleep;

import arrumar.code.objeto.BaseRotinaObjeto;
import arrumar.code.objeto.RotinaObjeto;
import arrumar.code.pessoa.Atendente;
import arrumar.code.pessoa.Cliente;
import arrumar.code.ui.fila.ListaAtendentes;
import arrumar.code.ui.guiche.GuicheImp;
import br.com.wellington.atendeAgora.fila.FilaClientes;

/**
 * Definição de um Guiche do simulador.
 *
 * @author Wellington Pires de Oliveira.
 * @date 20/09/2018.
 */
public class Guiche implements BaseRotinaObjeto, GuicheImp {

	// * ATRIBUTOS **************************************************************
	/**
	 * Lista de atendentes disponíveis.
	 */
	private final ListaAtendentes lista;

	/**
	 * Representação do cliente contido no guiche.
	 */
	private Cliente cliente;

	/**
	 * Representação do atendente contino no guiche.
	 */
	private Atendente atendente;

	/**
	 * Representação do estado de guiche aberto (true) e fechado (false).
	 */
	private boolean aberto;// true para guiche aberto

	private final RotinaObjeto ro;

	// * CONSTRUTOR *************************************************************
	/**
	 * Cria um guiche definindo os estado de:
	 *
	 * Sem cliente, sem atendente e guiche fechado.
	 *
	 * @param lista A lista de atendentes disponíveis.
	 * @param fila  A fila de clientes.
	 */
	public Guiche(ListaAtendentes lista, FilaClientes fila) {
		this.lista = lista;// lista dos atendentes disponiveis
		cliente = null;// sem cliente
		atendente = null;// sem atendente
		aberto = false;// guiche fechado

		ro = new RotinaObjeto(0) {

			@Override
			protected final void rotina() {
				threadSleep(2000);// espera um tempo para buscar um novo cliente
				cliente = fila.remove();// tenta remover um cliente da fila
				if (cliente == null) {
					return;// sem cliente na fila retipa a rotina
				}
				int tempo = atendente.gerarTempoAtendimento(cliente);// gera o tempo de atendimemnto
				cliente.getTicket().setTempo(tempo);// registra o tempo de atendimento no ticket
				atendente.setOcupado(true);
				threadSleep(tempo);// espera do tempo de atendimento
				atendente.resolverProblema(cliente);// da uma solução para o problema
				cliente = null;// retira o cliente do guiche
				atendente.setOcupado(false);
			}

			@Override // ao finalizar a rotina
			protected void rotinaFinalizar() {
				lista.setAtendente(atendente);
				atendente = null;
				aberto = false;
				// colocar o registro do Atendente em banco de dados aqui.
			}
		};
	}

	// ** MÉTODOS ***************************************************************
	/**
	 * Retorna o atendente.
	 *
	 * @return O atendente.
	 */
	@Override
	public Atendente getAtendente() {
		return atendente;
	}

	/**
	 * Remove o cliente do guiche se ele não estiver sendo atendido.
	 *
	 * @return null caso esteja vazio ou esteja dentro de um atendimento, senão será
	 *         retornado o cliente que foi excluido.
	 */
	public final Cliente removeCliente() {
		Cliente c = cliente;
		cliente = null;
		return c;
	}

	/**
	 * Retorna o cliente contido no cliente;
	 *
	 * @return null caso não exista cliente.
	 */
	@Override
	public final Cliente getCliente() {
		return cliente;
	}

	/**
	 * Informa se o guiche esta aberto ou fechado.
	 *
	 * @return true para aberto.
	 */
	@Override
	public boolean isAberto() {
		return aberto;
	}

	// * HERANÇA ****************************************************************
	@Override
	public void iniciar() {
		if (!aberto) {
			atendente = lista.getAtendente();
			aberto = true;
			ro.iniciar();
		}
	}

	@Override
	public void finalizar() {
		ro.finalizar();
	}
}
