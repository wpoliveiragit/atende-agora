package arrumar.code.ui.frame;

import static arrumar.code.ui.frame.UIFrameStatic.EstruturaFrame.FRAME;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaFrame.PAINEL;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaFrame.TEMPO_ATUALIZACAO;

import java.awt.Graphics;

import javax.swing.JComponent;

import arrumar.code.ui.component.Component;
import arrumar.code.ui.utilities.UIRotinaObjeto;

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
