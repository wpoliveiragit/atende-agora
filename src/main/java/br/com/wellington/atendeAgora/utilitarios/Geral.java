package br.com.wellington.atendeAgora.utilitarios;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 24/09/2018.
 */
public class Geral {

	/**
	 * Gera valores de variáveis primitivas aleatórias.
	 */
	public static final Random RANDOM = new Random();

	/**
	 * Congela o processo em que for usado um tempo determinado.
	 *
	 * @param milisegundos o tempo que o processo ficara congelado em milisegundos.
	 */
	public static final void threadSleep(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException ie) {

		}
	}

	/**
	 * Abre uma janela ou um programa.
	 *
	 * @param path Uma instancia de onde fica o arquivo.
	 */
	public static void abrePastaPrograma(File path) {
		try {
			Runtime.getRuntime().exec("explorer " + path.getAbsolutePath());
		} catch (IOException ex) {
			System.out.println("[ERRO] problemas em abrir o caminho \"" + path.getAbsolutePath() + "\"");
		}
	}

}
