package br.com.wellington.atendeAgora.ui.frame;

import static br.com.wellington.atendeAgora.ui.frame.UIFrameStatic.EstruturaPessoa.PESSOA_ALTURA;
import static br.com.wellington.atendeAgora.ui.frame.UIFrameStatic.EstruturaPessoa.PESSOA_LARGURA;
import static br.com.wellington.atendeAgora.utilities.UIPaletaCores.COR_FRAME_FUNDO;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Area de inicializacao da base grafica.
 *
 * @author Wellington Pires de Oliveira.
 * @date 13/06/2018.
 */
public class UIFrameStatic {

	public static class EstruturaFrame {

		/**
		 * Guarda o nome que irá aparecer no título da janela.
		 */
		private static final String TITULO_JANELA = "ATENDE AGORA";
		/**
		 * A base grafica do sistema.
		 */
		static final JFrame FRAME;
		/**
		 * O painel de controle da área gráfica.
		 */
		static final JPanel PAINEL;
		/**
		 * Controle dos comandos do teclado.
		 */
		public static TecladoImp TECLADO;

		/**
		 * A altura de uma letra em pixels.
		 */
		public static final int ALTURA_LETRA;
		/**
		 * A largura de uma letra em pixels.
		 */
		public static final int LARGURA_LETRA;
		/**
		 * Guarda a altura do frame.
		 */
		public static final int FRAME_ALTURA = 300;
		/**
		 * guarda a largura do frame.
		 */
		public static final int FRAME_LARGURA = 1000;
		/**
		 * Distancia minima de um objeto da borda.
		 */
		public static final int FRAME_BORDA;
		/**
		 * Tempo de atualização de todas as sprites do sistema.
		 */
		public static final int TEMPO_ATUALIZACAO = 30;

		static {
			// Configuração do Frame
			FRAME = new JFrame(TITULO_JANELA);
			FRAME.setSize(FRAME_LARGURA, FRAME_ALTURA);
			FRAME.setUndecorated(true);
			FRAME.setLocationRelativeTo(null);// centraliza a janela no monitor
			FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// habilita o 'X' da JanelaImp
			FRAME.setResizable(false);// Desativa o redimensionamento da janela
			FRAME.setVisible(true);
			// Configura o painel
			PAINEL = new JPanel(new BorderLayout()) {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override // atualizador do plano de fundo
				public void paintComponent(Graphics g) {
					g.setColor(COR_FRAME_FUNDO);
					g.fillRect(0, 0, (int) getWidth(), (int) getHeight());
					// update(g);//Apaga tudo menos a cor de fundo do painel
				}
			};
			// implementação dos listeners do teclado
			TECLADO = new TecladoImp() {

				@Override
				public void espaco() {
					System.out.println("Digito espaco nao construido");
				}

				@Override
				public void digitoN1() {
					System.out.println("Digito '1' nao construido");
				}

				@Override
				public void digitoN2() {
					System.out.println("Digito '2' nao construido");
				}

				@Override
				public void digitoN3() {
					System.out.println("Digito '3' nao construido");
				}

				@Override
				public void digitoN4() {
					System.out.println("Digito '4' nao construido");
				}

				@Override
				public void digitoN5() {
					System.out.println("Digito '5' nao construido");
				}
			};
			// Configuracao dos listeners
			FRAME.addWindowListener(new WindowListener() {

				@Override // Ao iniciar a interface
				public void windowOpened(WindowEvent e) {
				}

				@Override // Ao finalizar a interface.
				public final void windowClosing(WindowEvent e) {

				}

				@Override // ao minimizar a janela
				public void windowIconified(WindowEvent e) {// ignorado
					System.out.println("minimizei");
				}

				@Override // Apos fechar a janela
				public void windowClosed(WindowEvent e) { // ignoraso
				}

				@Override // Ao maximizar a janela
				public void windowDeiconified(WindowEvent e) {// ignorado
					System.out.println("maximizei");
				}

				@Override // Assim que a janela perde o foco
				public void windowDeactivated(WindowEvent e) {// ignorado
				}

				@Override // Assim que a janela ganha o foco
				public void windowActivated(WindowEvent e) {// ignorado
				}
			});
			FRAME.addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {
					switch (e.getKeyChar()) {
					case TecladoImp.DIGITO_ESPACO: {
						TECLADO.espaco();
						break;
					}
					case TecladoImp.DIGITO_ESC: {
						System.exit(0);
						// Elimina todos os processos existente do JFrame
						// Runtime.getRuntime().exit(0);
						break;
					}
					case TecladoImp.DIGITO_1: {
						TECLADO.digitoN1();
						break;
					}
					case TecladoImp.DIGITO_2: {
						TECLADO.digitoN2();
						break;
					}
					case TecladoImp.DIGITO_3: {
						TECLADO.digitoN3();
						break;
					}
					case TecladoImp.DIGITO_4: {
						TECLADO.digitoN4();
						break;
					}
					case TecladoImp.DIGITO_5: {
						TECLADO.digitoN5();
					}
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
				}

				@Override
				public void keyReleased(KeyEvent e) {
				}
			});
			// Dos atributos de apoio
			ALTURA_LETRA = EstruturaFrame.FRAME.getGraphics().getFontMetrics().getFont().getSize();
			LARGURA_LETRA = EstruturaFrame.FRAME.getGraphics().getFontMetrics().stringWidth("_");
			FRAME_BORDA = (FRAME_LARGURA - 5 * EstruturaGuiche.GUICHE_LARGURA) / 6;
		}
	}

	public static class EstruturaPessoa {

		/**
		 * Altura de uma pessoa
		 */
		public static final int PESSOA_ALTURA = 40;
		/**
		 * Largura de uma pessoa.
		 */
		public static final int PESSOA_LARGURA = 30;
	}

	public static class EstruturaHistorico {

		/**
		 * Quantidade de linhas que o histórico possui.
		 */
		public static final int HISTORICO_LINHAS = 6;
		/**
		 * Define a altura máxima da área.
		 */
		public static final int HISTORICO_LARGURA;
		/**
		 * Define a largura máxima da área.
		 */
		public static final int HISTORICO_ALTURA;

		static {
			HISTORICO_ALTURA = 5 + HISTORICO_LINHAS * (EstruturaFrame.ALTURA_LETRA + 3);
			HISTORICO_LARGURA = 24 * EstruturaFrame.LARGURA_LETRA;
		}
	}

	public static class EstruturaGuiche {

		/**
		 * Distancia base entre um objeto e outro.
		 */
		public static final int GUICHE_BORDA = 5;
		/**
		 * Tamanho da largura do guiche.
		 */
		public static final int GUICHE_ALTURA = 4 * GUICHE_BORDA + 2 * EstruturaPessoa.PESSOA_ALTURA + 6
				+ EstruturaHistorico.HISTORICO_ALTURA;
		/**
		 * Tamanho da altura do Guiche.
		 */
		public static final int GUICHE_LARGURA = GUICHE_BORDA + EstruturaHistorico.HISTORICO_LARGURA + GUICHE_BORDA;
		/**
		 * Largura da cadeira do guiche.
		 */
		public static final int GUICHE_CADEIRA_LARGURA = PESSOA_LARGURA + 3;
		/**
		 * Altura da cadeira do guiche.
		 */
		public static final int GUICHE_CADEIRA_ALTURA = PESSOA_ALTURA + 3;
		/**
		 * Largura do quadro de experiências do atendente atual no guiche.
		 */
		public static final int GUICHE_QUADRO_LARGURA = GUICHE_LARGURA - 3 * GUICHE_BORDA - GUICHE_CADEIRA_LARGURA;
		/**
		 * Altura do quadro de experiências do atendente atual no guiche.
		 */
		public static final int GUICHE_QUADRO_ALTURA = 2 * GUICHE_CADEIRA_ALTURA + GUICHE_BORDA;

	}

	public static class EstruturaFila {

		/**
		 * Definição do tamanho do espaço entre uma pessoa e outra na fila.
		 */
		public static final int FILA_BORDA;

		/**
		 * Largura total da fila de clientes.
		 */
		public static final int FILA_LARGURA;

		/**
		 * Altura total da fila de clientes.
		 */
		public static final int FILA_ALTURA;

		/**
		 * Largura fila.
		 */
		public static final int x;
		/**
		 * Altura Fila.
		 */
		public static final int y;

		static {
			FILA_BORDA = 5;
			FILA_LARGURA = 15 * PESSOA_LARGURA + 16 * FILA_BORDA;
			FILA_ALTURA = PESSOA_ALTURA + 2 * FILA_BORDA;
			x = (EstruturaFrame.FRAME_LARGURA - FILA_LARGURA) / 2;
			y = EstruturaFrame.FRAME_ALTURA - EstruturaFrame.FRAME_BORDA - FILA_ALTURA;
		}
	}

}
