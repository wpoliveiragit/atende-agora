package br.com.wellington.atendeAgora.fila;

import static br.com.wellington.atendeAgora.pessoa.PessoaStatic.IDADO_MAX_VELHO;

import java.util.ArrayList;
import java.util.List;

import br.com.wellington.atendeAgora.objeto.BaseRotinaObjeto;
import br.com.wellington.atendeAgora.objeto.RotinaObjeto;
import br.com.wellington.atendeAgora.pessoa.Cliente;
import br.com.wellington.atendeAgora.ui.fila.FilaClientesImp;

/**
 * Definição de uma fila de atendimento.
 *
 * @author Wellington Pires de Oliveira.
 * @date 20/09/2018.
 */
public class FilaClientes implements BaseRotinaObjeto, FilaClientesImp {

	// * STATIC *****************************************************************
	/**
	 * O tamanho máximo que a fila pode comportar de elementos.
	 */
	public static final int T_MAX = 15;// tamanho máximo

	// * ATRIBUTOS **************************************************************
	/**
	 * A fila que irá conter os clientes.
	 */
	private final List<Cliente> fila;
	/**
	 * Rotina da fila cliente.
	 */
	private final RotinaObjeto ro;
	/**
	 *
	 */
	private int chanceTeste;

	/**
	 * Cria uma fila e de tempos em tempos, um teste será feito caso ele tenha
	 * exito, um novo cliente será inserido na fila.
	 *
	 * @param tempo  Tempo de teste de geração de cliente em milisegundos. Se tempo
	 *               menor que 500, o valor 500 será atribuido ao tempo.
	 * @param chance Chance de exito no teste de criação onde este valor deverá
	 *               estar entre 0 e 100, caso contrario será atribuido o valor 50.
	 */
	public FilaClientes(int tempo, int chance) {
		if (tempo < 500) {
			tempo = 500;
		}
		if (chance < 0 || 100 < chance) {
			chance = 50;
		}
		chanceTeste = chance;
		// add variavel no atributo
		fila = new ArrayList<>();
		ro = new RotinaObjeto(tempo) {

			@Override // Gerador de cliente
			protected void rotina() {
				// Tenta gerar um cliente
				if (br.com.wellington.atendeAgora.utilitarios.Geral.RANDOM.nextInt(100) < chanceTeste) {
					add(new Cliente());
				}
			}

			@Override
			protected void rotinaFinalizar() {
				// fila.clear();
			}
		};
	}

	/**
	 * Adiciona um novo cliente na fila.
	 *
	 * @param cliente O cliente a ser adicionado na fila.
	 * @return true para cliente adicionado.
	 */
	private boolean add(Cliente cliente) {
		if (fila.size() < T_MAX) {
			return fila.add(cliente);
		}
		return false;
	}

	/**
	 * Remove o primeiro cliente da fila, caso exista um idoso na fila ele será
	 * prioridade na remoção.
	 *
	 * @return null caso fila vazia.
	 */
	public Cliente remove() {

		if (fila.isEmpty()) {
			return null;
		}
		for (int i = 0; i < fila.size(); i++) {
			if (fila.get(i).getIdade() > IDADO_MAX_VELHO) {
				return fila.remove(i);
			}
		}
		return fila.remove(0);

	}

	/**
	 * Retorna a Cliente referente ao índice.
	 *
	 * @param indice o índice da Cliente
	 * @return null caso fila vázia ou índice fora do range.
	 */
	@Override
	public Cliente get(int indice) {
		if (indice > -1 && indice < fila.size()) {
			return fila.get(indice);
		}
		return null;
	}

	/**
	 * Retorna o tamanho corrente da fila.
	 *
	 * @return O tamanho corrente da fila.
	 */
	@Override
	public int size() {
		return fila.size();
	}

	@Override
	public final void iniciar() {
		ro.iniciar();
	}

	@Override
	public final void finalizar() {
		ro.finalizar();
	}

	/**
	 * Informa se a fila esta ativa.
	 *
	 * @return true em caso de fila ativa.
	 */
	public boolean isAtivo() {
		return ro.isAtivo();
	}

}
