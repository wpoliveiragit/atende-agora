package br.com.pegasus.atende.agora.utilitarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Responsavem por toda a área de registro sistema.
 *
 * @author Wellington Pires de Oliveira.
 * @date 12/03/2019
 * @path AtendeAgora.Main.Configuracao
 */
public class ControleArquivo {

	/**
	 * Diretório raiz do programa.
	 */
	public final static String DIR_RAIZ = "RAIZ";
	/**
	 * Nome do arquivo dos dados dos atendentes.
	 */
	public final static String ARQ_ATENDENTE = "Atendente.txt";

	/**
	 * Cria e/ou salva o texto no arquivo.
	 *
	 * @param path    o caminho onde o arquivo se encontra.
	 * @param nomeArq o nome do arquivo.
	 * @param texto   o Texto a ser inserido.
	 * @param manter  true para manter o texto existente no arquivo e adicionar o
	 *                novo texto ao final dele. false recria o arquivo que conterá
	 *                apenas o novo texto.
	 */
	public static void gravar(String path, String nomeArq, String texto, boolean manter) {
		File f = new File(path, nomeArq);
		if (texto == null) {
			throw new RuntimeException("[ERRO] Valor nulo a ser gravado no arquivo " + f.getAbsolutePath());
		}
		try {
			// false: o arquivo será recriado
			PrintWriter gravar = new PrintWriter(new FileWriter(new File(path, nomeArq), manter));
			gravar.print(texto);
			gravar.flush();
			gravar.close();
		} catch (IOException ex) {
			throw new RuntimeException("[ERRO] Problemas no acesso do arquivo" + f.getAbsolutePath());
		}
	}

	/**
	 * Método de leitura de arquivo.
	 *
	 * @param caminho O caminho onde o arquivo se encontra.
	 * @param nome    O nome do arquivo.
	 * @return null em caso de erro de caminho/nome ou falha no acesso do arquivo.
	 */
	public static String ler(String caminho, String nome) {
		String txt = "";
		File f = new File(caminho, nome);
		try {
			BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			String s;
			while ((s = leitor.readLine()) != null) {
				txt += s + "\n";
			}
			leitor.close();
			return txt;
		} catch (FileNotFoundException ex) {
			throw new RuntimeException("[ERRO] Caminho não encontrado\"" + f.getAbsolutePath() + "\"");
		} catch (IOException ex) {
			throw new RuntimeException("[ERRO] - Erro de acesso ao arquivo \"" + f.getAbsolutePath() + "\"");
		}
	}

}
