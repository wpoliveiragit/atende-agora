package br.com.wellington.atendeAgora.ui.frame;

/**
 * Controle de dígito do teclado.<br>
 * Ao fechar um guiche, todos os dados do atendente correspondente deverão ser
 * atualizados no banco.<br>
 * Ao fechar um guiche, ele deverá terminar o atendimento corrente antes de
 * atualizar os dados do atendente.<br>
 * Ao encerrar o aplicativo, todos os guiches deverão ser encerrados e os
 * atendimentos correntes deverão ser finalizados prematuramente.
 *
 * @author Wellington Pires de Oliveira.
 * @date 15/10/2018.
 */
public interface TecladoImp {

	/**
	 * valor do digito espaço do teclado.
	 */
	static final int DIGITO_ESPACO = 32;

	/**
	 * Valor do dígito esc do teclado.
	 */
	static final int DIGITO_ESC = 27;

	/**
	 * Valor do dígito 1 do teclado.
	 */
	static final int DIGITO_1 = 49;

	/**
	 * Valor do dígito 2 do teclado.
	 */
	static final int DIGITO_2 = 50;

	/**
	 * Valor do dígito 3 do teclado.
	 */
	static final int DIGITO_3 = 51;

	/**
	 * Valor do dígito 4 do teclado.
	 */
	static final int DIGITO_4 = 52;

	/**
	 * Valor do dígito 5 do teclado.
	 */
	static final int DIGITO_5 = 53;

	/**
	 * Ao digitar espaço a criação da fila deverá ser pausada ou iniciada.
	 */
	abstract public void espaco();

	/**
	 * Ao digitar o numemro 1 deverá mudar o status do guiche para aberto ou
	 * fechado.
	 */
	abstract public void digitoN1();

	/**
	 * Ao digitar o numemro 2 deverá mudar o status do guiche para aberto ou
	 * fechado.
	 */
	abstract public void digitoN2();

	/**
	 * Ao digitar o numemro 3 deverá mudar o status do guiche para aberto ou
	 * fechado.
	 */
	abstract public void digitoN3();

	/**
	 * Ao digitar o numemro 4 deverá mudar o status do guiche para aberto ou
	 * fechado.
	 */
	abstract public void digitoN4();

	/**
	 * Ao digitar o numemro 5 deverá mudar o status do guiche para aberto ou
	 * fechado.
	 */
	abstract public void digitoN5();
}
