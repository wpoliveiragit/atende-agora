package br.com.wellington.atendeAgora.utilities;

import java.awt.Toolkit;

/**
 * Guarda os métodos que não são ligados a nenhuma classe em específicos.
 *
 * @author Wellington Pires de Oliveira.
 * @date 07/11/2018.
 */
public class CaixaSom {

	/**
	 * Emite um beep no sistema.
	 */
	public static void beep() {
		Toolkit.getDefaultToolkit().beep();
	}

}
