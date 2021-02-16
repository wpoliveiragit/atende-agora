package arrumar.code.pessoa;

import static arrumar.code.utilitarios.ControleArquivo.ARQ_ATENDENTE;
import static arrumar.code.utilitarios.ControleArquivo.DIR_RAIZ;
import static arrumar.code.utilitarios.ControleArquivo.gravar;
import static arrumar.code.utilitarios.ControleArquivo.ler;
import static arrumar.code.utilitarios.Geral.abrePastaPrograma;

import java.io.File;
import java.io.IOException;

/**
 * Controlador de fuxo de dados de arquivo do pacote Pessoa.
 *
 * @author Wellington Pires de Oliveira.
 * @date 25/03/2019
 * @path AtendeAgora.Pessoa.ArquivoPessoa
 */
public class ArquivoPessoa {

	public static void main(String[] args) {
		init();
		Atendente[] atendentes = new Atendente[5];
		for (int i = 0; i < atendentes.length; i++) {
			atendentes[i] = gravarAtendente(new Atendente());
		}
		Cliente c = new Cliente();
		atendentes[2].resolverProblema(c);
		atualizarAtendente(atendentes[2]);
		deletarAtendente(atendentes[1]);

		abrePastaPrograma(new File(DIR_RAIZ, ARQ_ATENDENTE));

	}

	/**
	 * Caracter de separação entre a senha e os dados.
	 */
	public static final String SEPARADOR_SENHA_DADOS = "&";

	/**
	 * Caracter de separação de dados.
	 */
	public static final String SEPARADOR_DADOS = "#";

	/**
	 * Certifica a existencia de todos os arquivos necessarios para a gravação. Caso
	 * algum não exista, ele sera criado.
	 */
	public static void init() {
		File path = new File(DIR_RAIZ);
		path.mkdir();
		path = new File(path, ARQ_ATENDENTE);
		if (path.exists()) {
			return;
		}
		try {
			path.createNewFile();
		} catch (IOException ex) {
			throw new RuntimeException();// erro inesperado
		}
	}

	/**
	 * Registra um novo atendente no arquivo.
	 *
	 * @param atendente O atendente a ser registrado. O atendente não pode ser nulo.
	 * @return O parâmetro atualizado tendo como diferensa o código objtido do
	 *         registro.
	 */
	public static Atendente gravarAtendente(Atendente atendente) {
		if (atendente == null) {// erro
			throw new RuntimeException();
		}
		String[] linhasArquivo = ler(DIR_RAIZ, ARQ_ATENDENTE).split("\n");
		int cod = 1;
		if (linhasArquivo[0].length() > 0) {
			for (int i = 0; i < linhasArquivo.length; i++) {
				if (Integer.parseInt(linhasArquivo[i].split(SEPARADOR_SENHA_DADOS)[0]) == cod) {
					cod++;
					i = 0;
				}
			}
		}
		atendente = new Atendente(cod, atendente.getDados().split(SEPARADOR_SENHA_DADOS)[1].split(SEPARADOR_DADOS));
		gravar(DIR_RAIZ, ARQ_ATENDENTE, atendente.getDados() + '\n', true);
		return atendente;
	}

	/**
	 * Deleta do arquivo os dados do atendente.
	 *
	 * @param atendente O atendente a ser deletado
	 */
	public static void deletarAtendente(Atendente atendente) {
		if (atendente == null) {// ocorreu algum tipo de erro
			throw new RuntimeException();
		}
		String[] linhas = ler(DIR_RAIZ, ARQ_ATENDENTE).split("\n");
		if (linhas[0].length() == 0) {
			return;
		}

		String txt = "";
		int cod = Integer.parseInt(atendente.getDados().split(SEPARADOR_SENHA_DADOS)[0]);

		for (int i = 0; i < linhas.length; i++) {
			if (Integer.parseInt(linhas[i].split(SEPARADOR_SENHA_DADOS)[0]) == cod) {
				while (++i < linhas.length) {
					txt += linhas[i] + '\n';
				}
				break;
			}
			txt += linhas[i] + '\n';
		}
		gravar(DIR_RAIZ, ARQ_ATENDENTE, txt.substring(0, txt.length() - 1), false);
	}

	/**
	 * Atualiza os dados do atendente no arquivo. Caso o atendente não exista, ele
	 * será gravado.
	 *
	 * @param atendente O atendente a ser atualizado.
	 */
	public static void atualizarAtendente(Atendente atendente) {
		if (atendente == null) {// erro
			throw new RuntimeException();
		}

		String[] linhas = ler(DIR_RAIZ, ARQ_ATENDENTE).split("\n");
		if (linhas[0].length() == 0) {// arquivo vazio, gravar o atendente
			gravar(DIR_RAIZ, ARQ_ATENDENTE,
					new Atendente(1, atendente.getDados().split(SEPARADOR_SENHA_DADOS)[1].split(SEPARADOR_DADOS))
							.getDados(),
					false);
			return;
		}

		int codAtendente = Integer.parseInt(atendente.getDados().split(SEPARADOR_SENHA_DADOS)[0]);
		String txt = "";
		for (int i = 0; i < linhas.length; i++) {
			if (codAtendente == Integer.parseInt(linhas[i].split(SEPARADOR_SENHA_DADOS)[0])) {
				linhas[i] = atendente.getDados();
				do {
					txt += linhas[i] + "\n";
				} while (++i < linhas.length);
				gravar(DIR_RAIZ, ARQ_ATENDENTE, txt.substring(0, txt.length() - 1), false);
				return;
			}
			txt += linhas[i] + "\n";
		}
		gravar(DIR_RAIZ, ARQ_ATENDENTE, atendente.getDados(), true);
	}

}
