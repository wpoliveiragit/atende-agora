package br.com.wellington.atendeAgora.objeto;

/**
 * Define os metódos de execução de uma .
 *
 * @author Wellington Pires de Oliveira.
 * @date 25/09/2018.
 */
public abstract interface BaseRotinaObjeto {

	/**
	 * Inicializa a rotina do objeto.
	 */
	public abstract void iniciar();

	/**
	 * solicita a finalização da rotina.
	 */
	public abstract void finalizar();

}
