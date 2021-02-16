package arrumar.code.pessoa;

import static arrumar.code.problema.ControleProblemas.PROBLEMAS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import arrumar.code.problema.Problema;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 21/09/2018.
 */
public final class PessoaStatic {

	/** Objeto de geração de valores randômicos. */
	private static final Random RANDOM = new Random();

	/** Lista de Roupas. */
	public final static List<Integer> ROUPAS;

	/** Lista de Cabelos. */
	public final static List<Integer> CABELOS;

	/** Lista de nomes masculinos. */
	public final static List<String> NOMES_M;

	/** Lista de nomes femininos. */
	public final static List<String> NOMES_F;

	/**
	 * Idade maxima que um velho pode possuir antes de virar um idoso para poder ter
	 * príoridade no atendimento.
	 */
	public final static int IDADO_MAX_VELHO = 64;

	static {
		ROUPAS = new ArrayList<Integer>();
		for (int i = 0; i < 8; i++) {
			ROUPAS.add(i);
		}

		CABELOS = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			CABELOS.add(i);
		}

		NOMES_M = new ArrayList<String>();
		NOMES_M.add("H_J");
		NOMES_M.add("H_A");
		NOMES_M.add("H_V");
		NOMES_M.add("H_I");

		NOMES_F = new ArrayList<String>();
		NOMES_F.add("M_J");
		NOMES_F.add("M_A");
		NOMES_F.add("M_V");
		NOMES_F.add("M_I");
	}

	/**
	 * Retorna um estado que indique se é genero masculino ou feminino.
	 *
	 * @return true para homem.
	 */
	public static final boolean gerarSexo() {
		return RANDOM.nextBoolean();
	}

	/**
	 * Retorna um nome masculino.
	 *
	 * @return Um nome masculino.
	 */
	public static final String gerarNomeMasculino() {
		return NOMES_M.get(RANDOM.nextInt(NOMES_M.size()));
	}

	/**
	 * Retorna um nome feminino.
	 *
	 * @return Um nome feminino.
	 */
	public static final String gerarNomeFeminino() {
		return NOMES_F.get(RANDOM.nextInt(NOMES_F.size()));
	}

	/**
	 * Gera uma idade entre 15 a 80.
	 *
	 * @param nome O nome da pessoa.
	 * @return um numero entre 15 a 80.
	 */
	public static final int gerarIdade(String nome) {
		switch (nome.charAt(2)) {
		case 'J':
			return RANDOM.nextInt(5) + 15;
		case 'A':
			return RANDOM.nextInt(22) + 18;
		case 'V':
			return RANDOM.nextInt(20) + 40;
		case 'I':
			return RANDOM.nextInt(21) + 60;
		default:
			return RANDOM.nextInt(65) + 15;
		}
	}

	/**
	 * Retorna o codigo de uma roupa.
	 *
	 * @return O codigo de uma roupa.
	 */
	public static final int gerarRoupa() {
		return ROUPAS.get(RANDOM.nextInt(ROUPAS.size()));
	}

	/**
	 * Retorna o codigo de uma cabelo.
	 *
	 *
	 * @param idoso indica que o cabelo deverá ser branco.
	 * @return O codigo de uma cabelo.
	 */
	public static final int gerarCabelo(boolean idoso) {
		if (idoso) {
			return 0;
		} else {
			return CABELOS.get(1 + RANDOM.nextInt(CABELOS.size() - 1));
		}
	}

	/**
	 * Retorna um tipo de problema.
	 *
	 * @return Um tipo de problema.
	 */
	public static Problema gerarProblema() {
		return PROBLEMAS.get(RANDOM.nextInt(PROBLEMAS.size()));
	}
}
