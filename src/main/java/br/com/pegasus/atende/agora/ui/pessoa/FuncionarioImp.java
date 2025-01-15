package br.com.pegasus.atende.agora.ui.pessoa;

/**
 *
 * @author Thon
 */
public interface FuncionarioImp extends PessoaImp {

	/**
	 *
	 * @return
	 */
	public boolean isOcupado();

	/**
	 * Retorna um conjunto de textos onde cada um contem o nome do problema seguido
	 * do valor que representa a experiência nele.
	 *
	 * @return
	 */
	public String[] getExperiencia();

}
