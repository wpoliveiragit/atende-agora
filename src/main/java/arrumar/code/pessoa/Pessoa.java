package arrumar.code.pessoa;

import static arrumar.code.pessoa.ArquivoPessoa.SEPARADOR_DADOS;
import static arrumar.code.pessoa.ArquivoPessoa.SEPARADOR_SENHA_DADOS;
import static arrumar.code.utilitarios.Geral.RANDOM;

import arrumar.code.ui.pessoa.PessoaImp;

/**
 * Definição de uma pessoa do simulador.
 *
 * @author Wellington Pires de Oliveira.
 * @date 10/09/2018.
 */
public abstract class Pessoa implements PessoaImp {

	protected final int codigo;
	protected String nome;
	protected int idade;
	protected boolean sexo;
	/** Define o quanto a pessoa é clara ao conversar. */
	protected int grauComunicacao;
	protected int cabelo;// guarda o índice do tipo de cabelo
	protected int roupa;// guarda o índice do tipo da roupa.

	/**
	 * Cria uma nova pessoa.
	 *
	 * @param codigo O codigo da pessoa.
	 */
	public Pessoa(int codigo) {
		this.codigo = codigo;
		sexo = PessoaStatic.gerarSexo();
		nome = (sexo) ? PessoaStatic.gerarNomeMasculino() : PessoaStatic.gerarNomeFeminino();
		idade = PessoaStatic.gerarIdade(nome);

		cabelo = PessoaStatic.gerarCabelo(idade > PessoaStatic.IDADO_MAX_VELHO);
		roupa = PessoaStatic.gerarRoupa();
		grauComunicacao = 250 + RANDOM.nextInt(751);
	}

	/**
	 * Retorna o tempo que o cliente levará para explicar o problema que ele possui.
	 *
	 * @return O tempo que o cliente levará para explicar o problema que ele possui
	 *         em milisegundos entre 1150 a 5000.
	 */
	public int explicar() {
		// 250 a 2000
		int tempo = grauComunicacao;
		// 400 a 1000
		tempo += (sexo) ? RANDOM.nextInt(601) + 400 : RANDOM.nextInt(401) + 600;
		// 500 a 2000
		if (idade < 18) {// jovem
			tempo += 1500 + RANDOM.nextInt(501);
		} else if (idade < 40) {// adulto
			tempo += 500 + RANDOM.nextInt(1501);
		} else if (idade < 60) {// velho
			tempo += 1000 + RANDOM.nextInt(1001);
		} else {// idoso
			tempo += 1250 + RANDOM.nextInt(751);
		}
		return tempo;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public int getIdade() {
		return idade;
	}

	@Override
	public boolean isSexo() {
		return sexo;
	}

	@Override
	public int getCabelo() {
		return cabelo;
	}

	@Override
	public int getRoupa() {
		return roupa;
	}

	@Override
	public String getDados() {
		return codigo + SEPARADOR_SENHA_DADOS + nome + SEPARADOR_DADOS + idade + SEPARADOR_DADOS + sexo
				+ SEPARADOR_DADOS + grauComunicacao + SEPARADOR_DADOS + cabelo + SEPARADOR_DADOS + roupa;
	}

}
