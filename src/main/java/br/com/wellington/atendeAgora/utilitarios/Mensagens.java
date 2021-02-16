package br.com.wellington.atendeAgora.utilitarios;

import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

/**
 * Definição do que a classe representa ou administra
 *
 * @author Wellington Pires de Oliveira.
 * @date 13/03/2019
 * @path AtendeAgora.Utilitarios.Mensagens
 */
public class Mensagens {

	/**
	 * Mensagem de erro de sistema teste.
	 *
	 * @param msg Mensagem do erro do sistema.
	 */
	public static void mensagemErroSistema(String msg) {
		showMessageDialog(null, msg, "ERRO DE SISTEMA", JOptionPane.ERROR_MESSAGE);
	}
}
