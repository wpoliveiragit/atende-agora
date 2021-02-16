package br.com.wellington.atendeAgora.utilitarios;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 01/10/2018.
 */
public class ErroSistema extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Dispara um erro inexperado do sistema.
	 *
	 * @param msg a mensagem de erro.
	 */
	public ErroSistema(String msg) {
		super(msg);
	}

}
