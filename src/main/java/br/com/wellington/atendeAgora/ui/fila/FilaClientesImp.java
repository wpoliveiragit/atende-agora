package br.com.wellington.atendeAgora.ui.fila;

import br.com.wellington.atendeAgora.ui.pessoa.ClienteImp;

/**
 * Interface de adaptação para execução da animação da fila de clientes.
 *
 * @author Wellington Pires de Oliveira.
 * @date 17/10/2018.
 */
public interface FilaClientesImp {

	/**
	 * Retorna o tamanho atual da fila.
	 *
	 * @return O tamanho atual da fila.
	 */
	public int size();

	/**
	 * Retorna um elemento.
	 *
	 * @param indice A posição do elemento na fila.
	 * @return O elemento indicado no indice.
	 */
	public ClienteImp get(int indice);

}
