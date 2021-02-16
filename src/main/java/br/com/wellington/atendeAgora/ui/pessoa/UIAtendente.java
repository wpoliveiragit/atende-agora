package br.com.wellington.atendeAgora.ui.pessoa;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 04/10/2018.
 */
public class UIAtendente extends UIPessoa implements FuncionarioImp {

	private final FuncionarioImp atendente;

	public UIAtendente(FuncionarioImp atendente, int x, int y) {
		super(atendente, x, y);
		this.atendente = atendente;
	}

	@Override
	public boolean isOcupado() {
		return atendente.isOcupado();
	}

	@Override
	public String[] getExperiencia() {
		return atendente.getExperiencia();
	}

	@Override
	public String getDados() {
		return atendente.getDados();
	}

}
