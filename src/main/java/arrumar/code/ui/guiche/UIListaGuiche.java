package arrumar.code.ui.guiche;

import static arrumar.code.ui.frame.UIFrameStatic.EstruturaGuiche.GUICHE_ALTURA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaGuiche.GUICHE_BORDA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaGuiche.GUICHE_CADEIRA_ALTURA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaGuiche.GUICHE_CADEIRA_LARGURA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaGuiche.GUICHE_LARGURA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaHistorico.HISTORICO_ALTURA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaPessoa.PESSOA_ALTURA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaPessoa.PESSOA_LARGURA;
import static arrumar.code.ui.graphics.UIDesenhar.retanguloCheio;
import static arrumar.code.ui.graphics.UIDesenhar.retanguloCheioBorda;
import static arrumar.code.ui.utilities.CaixaSom.beep;
import static arrumar.code.ui.utilities.UIPaletaCores.COR_GUICHE_CADEIRA;
import static arrumar.code.ui.utilities.UIPaletaCores.COR_GUICHE_PISO;

import java.awt.Graphics;
import java.text.DecimalFormat;

import arrumar.code.ui.component.Component;
import arrumar.code.ui.graphics.UIGeometria.Retangulo;
import arrumar.code.ui.pessoa.UIAtendente;
import arrumar.code.ui.pessoa.UICliente;
import arrumar.code.ui.utilities.UIObjeto;
import arrumar.code.ui.utilities.UIRotinaObjeto;

/**
 * Representa um Guiche gráfico.
 *
 * @author Wellington Pires de Oliveira.
 * @date 21/09/2018.
 */
public class UIListaGuiche extends UIObjeto {

	/**
	 * Estrutura do guiche.
	 */
	private Estrutura estrutura;
	/**
	 * Estrutura de Pessoas.
	 */
	private Controle controle;
	/**
	 * O controle do histórico do guiche.
	 */
	private UIHistorico historico;
	/**
	 * Guarda o texto que o atendente pode representar.
	 */
	private UIQuadro quadro;

	/**
	 * Cria um novo guiche.
	 *
	 * @param guiche o guiche a ser desenhado.
	 * @param x      dado do eixo do x.
	 * @param y      dado do eixo do y.
	 */
	public UIListaGuiche(GuicheImp guiche, int x, int y) {
		super(x, y);
		init(guiche);
	}

	private void init(GuicheImp guiche) {
		controle = new Controle(guiche);
		estrutura = new Estrutura();
		historico = new UIHistorico(x + GUICHE_BORDA, y + GUICHE_ALTURA - GUICHE_BORDA - HISTORICO_ALTURA);
		quadro = new UIQuadro(x + 2 * GUICHE_BORDA + GUICHE_CADEIRA_LARGURA, y + GUICHE_BORDA);

		new UIRotinaObjeto(30) {
			@Override
			protected void rotina() {
				if (controle.guicheAberto()) {
					controle.verificarAtendente();
					if (controle.atendenteOcupado()) {// Atendente atendendo?
						controle.setCliente();
						return;
					}
					if (controle.cliente == null) {// atendimento enserrado?
						controle.emitirSom();
						return;
					}
					controle.addAtendimento();
					controle.cliente = null;
					controle.som = true;
					return;
				}
				controle.addAtendimento();
				controle.atendente = null;
				controle.cliente = null;
			}
		}.iniciar();

	}

	@Override
	public void desenhar(Graphics g) {
		estrutura.desenhar(g);
		controle.desenhar(g);
		historico.desenhar(g);
		quadro.desenhar(g);
	}

	private class Estrutura implements Component {

		/**
		 * O piso da área do guiche.
		 */
		Retangulo pisoGuiche;
		/**
		 * Local onde o atendente fica.
		 */
		Retangulo cadeiraAtendente;
		/**
		 * Local onde o cliente fica.
		 */
		Retangulo cadeiraCliente;

		/**
		 * Cria uma estrutura de um guiche.
		 *
		 * @param guiche O guiche a ser criado.
		 */
		Estrutura() {
			initPiso();
			initCadeiraAtendente();
			initCadeiraCliente();
		}

		private void initPiso() {
			pisoGuiche = new Retangulo(COR_GUICHE_PISO, x, y, GUICHE_LARGURA, GUICHE_ALTURA);
		}

		private void initCadeiraAtendente() {
			cadeiraAtendente = new Retangulo(COR_GUICHE_CADEIRA, x + GUICHE_BORDA, y + GUICHE_BORDA, PESSOA_LARGURA + 3,
					PESSOA_ALTURA + 3);
		}

		private void initCadeiraCliente() {
			cadeiraCliente = new Retangulo(COR_GUICHE_CADEIRA, x + GUICHE_BORDA,
					y + 2 * GUICHE_BORDA + PESSOA_ALTURA + 3, GUICHE_CADEIRA_LARGURA, GUICHE_CADEIRA_ALTURA);
		}

		@Override
		public void desenhar(Graphics g) {
			retanguloCheioBorda(g, pisoGuiche);
			retanguloCheio(g, cadeiraAtendente);
			retanguloCheio(g, cadeiraCliente);
		}
	}

	private class Controle implements Component {

		/**
		 * O Guiche de controle.
		 */
		private final GuicheImp guiche;
		/**
		 * O atendente corrente do guiche.
		 */
		private UIAtendente atendente;
		/**
		 * O cliente corrente do guiche.
		 */
		private UICliente cliente;
		/**
		 * Determina se precisa ou não emitir um som.
		 */
		private boolean som;

		private Controle(GuicheImp guiche) {
			this.guiche = guiche;
			atendente = null;
			cliente = null;
			som = true;
		}

		/**
		 * Verifica se o guiche esta aberto ou fechado.
		 *
		 * @return
		 */
		private boolean guicheAberto() {
			return guiche.isAberto();
		}

		/**
		 * Verifica se o atendente esta ocupado.
		 *
		 * @return true para sim.
		 */
		private boolean atendenteOcupado() {
			return atendente.isOcupado();
		}

		/**
		 * Adiciona o histórico do atendimento na interface histórico.
		 */
		private void addAtendimento() {
			if (cliente == null) {
				return;
			}
			historico.addTexto("- " + cliente.getNome() // "- M_J(15:00) A - (Exito)"
					+ "(" + new DecimalFormat("#,##").format(cliente.getTicket().getTempo() * .1).replace('.', ':')
					+ ") " + cliente.getTicket().getTipo()
					+ (cliente.getTicket().isResolvido() ? " (Exito)" : " (Falha)"));
			quadro.setTextos(atendente.getExperiencia());
		}

		/**
		 * Instancia o cliente caso ele não tenha sido instanciado
		 */
		private void setCliente() {
			if (controle.cliente == null) {// Confere se o cliente foi instanciado
				if (guiche.getCliente() == null) {
					return;
				}
				cliente = new UICliente(guiche.getCliente(), x + GUICHE_BORDA + 1,
						y + 2 * GUICHE_BORDA + PESSOA_ALTURA + 4);
			}
		}

		/**
		 * Verifica se contem um atendente no guiche e o instancia.
		 */
		private void verificarAtendente() {
			if (controle.atendente == null) {
				if (guiche.getAtendente() == null) {
					return;
				}
				atendente = new UIAtendente(guiche.getAtendente(), x + GUICHE_BORDA + 1, y + GUICHE_BORDA + 1);
				historico.criarHistorico();
				quadro.setTextos(atendente.getExperiencia());
			}
		}

		/**
		 * Verifica se precisa emitir um som.
		 */
		private void emitirSom() {
			if (som) {
				beep();
				som = false;
			}
		}

		@Override
		public void desenhar(Graphics g) {
			if (controle.atendente != null) {
				controle.atendente.desenhar(g);

			}
			if (controle.cliente != null) {
				controle.cliente.desenhar(g);
			}
		}

	}
}
