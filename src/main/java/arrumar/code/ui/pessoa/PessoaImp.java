package arrumar.code.ui.pessoa;

/**
 * Interface de acesso aos atributos bases de uma pessoa.
 *
 * @author Wellington Pires de Oliveira.
 * @date 16/10/2018.
 */
public interface PessoaImp {

	/**
	 * Retorna o nome.
	 *
	 * @return O nome.
	 */
	public String getNome();

	/**
	 * Retorna a idade.
	 *
	 * @return A idade.
	 */
	public int getIdade();

	/**
	 * Retorna o sexo da pessoa.
	 *
	 * @return true para Homem.
	 */
	public boolean isSexo();

	/**
	 * Retorna o índice do cabelo
	 *
	 * @return O índice do cabelo.
	 */
	public int getCabelo();

	/**
	 * Retorna o índice da roupa.
	 *
	 * @return Oíndice da roupa.
	 */
	public int getRoupa();

	/**
	 * Retorna uma string contendo todos os dados da pessoa onde o separador é um
	 * '-'.
	 *
	 * (Criar uma codificação de identificação de dados)
	 *
	 * @return um array contendo todos os dados.
	 */
	public String getDados();

}
