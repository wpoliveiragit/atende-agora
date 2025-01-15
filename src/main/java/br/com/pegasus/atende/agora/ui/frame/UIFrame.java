package br.com.pegasus.atende.agora.ui.frame;

import static br.com.pegasus.atende.agora.ui.frame.UIFrameStatic.EstruturaFrame.FRAME;
import static br.com.pegasus.atende.agora.ui.frame.UIFrameStatic.EstruturaFrame.PAINEL;
import static br.com.pegasus.atende.agora.ui.frame.UIFrameStatic.EstruturaFrame.TEMPO_ATUALIZACAO;

import java.awt.Graphics;

import javax.swing.JComponent;

import br.com.pegasus.atende.agora.ui.component.Component;
import br.com.pegasus.atende.agora.utilities.UIRotinaObjeto;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 15/10/2018.
 */
public class UIFrame {

	/**
	 * Cria e executa o motor gráfico do aplicativo.
	 *
	 * @param componenteGrafico
	 */
	public UIFrame(Component componenteGrafico) {

		JComponent jc = new JComponent() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics g) {
				componenteGrafico.desenhar(g);
			}
		};

		new UIRotinaObjeto(TEMPO_ATUALIZACAO) {
			@Override
			protected void rotina() {
				jc.repaint();
			}
		}.iniciar();
		PAINEL.add(jc);
		FRAME.setContentPane(PAINEL);
		PAINEL.updateUI();
	}
}
