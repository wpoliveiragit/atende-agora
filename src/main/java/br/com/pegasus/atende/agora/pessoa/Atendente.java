package br.com.pegasus.atende.agora.pessoa;

import static br.com.pegasus.atende.agora.pessoa.ArquivoPessoa.SEPARADOR_DADOS;
import static br.com.pegasus.atende.agora.ui.problema.ControleProblemas.PROBLEMAS;
import static br.com.pegasus.atende.agora.utilitarios.Geral.RANDOM;

import br.com.pegasus.atende.agora.ui.pessoa.FuncionarioImp;
import br.com.pegasus.atende.agora.utilitarios.ErroSistema;

/**
 * Representa um atendente do simulador.
 *
 * @author Wellington Pires de Oliveira.
 * @date 21/09/2018.
 */
public final class Atendente extends Pessoa implements FuncionarioImp {

	/**
	 * mensagem de falha ao tentar encontrar o problema do cliente na lista de
	 * problemas.
	 */
	private final static String MSG_ERRO_PROBLEMA;

	/** Quantidade máxima que a experiência pode alcançar. */
	private final static int MAX_XP;

	static {
		MSG_ERRO_PROBLEMA = "PROBLEMA N�O ENCONTRADO NA LISTA DE PROBLEMAS";
		MAX_XP = 20;
	}

	/**
	 * Indicador que o atendente pode ou n�o realizar um novo atendimento. true para
	 * ocupado.
	 */
	private boolean ocupado;

	/**
	 * Indicador de quanto o atendente sabe sobre um determinado problema, deixando
	 * o atendimento mais r�pido e aumentando a chance de sucesso na resolu��o.
	 */
	private int[] ex;

	/**
	 * Instancia um novo atendente.
	 */
	public Atendente() {
		super(-1);
		roupa = PessoaStatic.ROUPAS.get(7);
		ocupado = false;
		ex = new int[PROBLEMAS.size()];
		for (int i = 0; i < ex.length; i++) {
			ex[i] = 0;
		}
		// Certifica que o atendente sempre vai ser maior de 18 anos.
		if ((super.idade - 18 < 0)) {
			idade += 3;
		}

	}

	/**
	 * Instancia um atendente existente.
	 *
	 * @param codigo O codigo do atendente.
	 * @param dados  Dados de um atendente existente, null para criar um novo
	 *               atendente.
	 */
	public Atendente(int codigo, String[] dados) {
		super(codigo);
		setDados(dados);
	}

	private void setDados(String[] d) {
		super.nome = d[0];
		super.idade = Integer.parseInt(d[1]);
		super.sexo = Boolean.parseBoolean(d[2]);
		super.grauComunicacao = Integer.parseInt(d[3]);
		super.cabelo = Integer.parseInt(d[4]);
		super.roupa = Integer.parseInt(d[5]);
		ex = new int[PROBLEMAS.size()];
		for (int i = 6, j = 0; i < d.length - 1; i++, j++) {
			ex[j] = Integer.parseInt(d[i]);
		}

	}

	/**
	 * Configura um novo estado.
	 *
	 * @param estado true para ocupado.
	 */
	public void setOcupado(boolean estado) {
		ocupado = estado;
	}

	/**
	 * Retorna o estado do atendente.
	 *
	 * @return true para atendendo um cliente.
	 */
	@Override
	public boolean isOcupado() {
		return ocupado;
	}

	/**
	 * Gera o tempo de atendimento.
	 *
	 * @param cliente o cliente que será atendido.
	 * @return o tempo do atendimento em milisegundos entre 3300 a 15000.
	 */
	public int gerarTempoAtendimento(Cliente cliente) {
		for (int i = 0; i < PROBLEMAS.size(); i++) {// busca o indice da experiencia
			if (PROBLEMAS.get(i) == cliente.getTicket().getProblema()) {// cálculo do tempo
				return (int) (cliente.getTicket().getProblema().getTempo()
						- ex[i] / 40f * cliente.getTicket().getProblema().getTempo() + cliente.explicar() + explicar());
			}
		}
		throw new ErroSistema(MSG_ERRO_PROBLEMA + " {" + cliente.getTicket().getProblema().getNome() + "}");
	}

	/**
	 * Tenta resolver o problema do cliente adicionando a experiencia que o
	 * atendente teve com o atendimento e adiciona no ticket a resolução do
	 * problema.
	 *
	 * @param cliente o cliente.
	 */
	public void resolverProblema(Cliente cliente) {
		for (int i = 0; i < PROBLEMAS.size(); i++) {// busca o indice do problema
			if (PROBLEMAS.get(i) == cliente.getTicket().getProblema()) {// problema encontrado
				cliente.getTicket().setResolvido(RANDOM.nextInt(100) > PROBLEMAS.get(i).getErro() - ex[i]);// marca a
																											// resolução
																											// do
																											// problema
				ex[i] += cliente.getTicket().isResolvido() ? 2 : 1;// adiciona a experiencia do atendente
				if (ex[i] > MAX_XP) {// correção de experiência
					ex[i] = MAX_XP;
				}
				return;
			}
		}
		throw new ErroSistema(MSG_ERRO_PROBLEMA + " {" + cliente.getTicket().getProblema().getNome() + "}");
	}

	@Override
	public String[] getExperiencia() {
		String[] e = new String[ex.length];
		for (int i = 0; i < ex.length; i++) {
			e[i] = PROBLEMAS.get(i).getNome() + ": " + ex[i];
		}
		return e;
	}

	@Override
	public String getDados() {
		String s = super.getDados();
		for (int s2 : ex) {
			s += SEPARADOR_DADOS + s2;
		}
		return s;
	}

}
