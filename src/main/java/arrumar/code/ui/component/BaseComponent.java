package arrumar.code.ui.component;

import static arrumar.code.ui.frame.UIFrameStatic.EstruturaFrame.FRAME_BORDA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaFrame.TECLADO;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaGuiche.GUICHE_LARGURA;

import java.awt.Graphics;

import arrumar.code.ui.fila.FilaClientesImp;
import arrumar.code.ui.fila.UIFilaClientes;
import arrumar.code.ui.frame.TecladoImp;
import arrumar.code.ui.frame.UIFrame;
import arrumar.code.ui.guiche.GuicheImp;
import arrumar.code.ui.guiche.UIListaGuiche;

/**
 * Componente de suporte para a execucao da animacao do 'Simulador'.
 *
 * @author Wellington Pires de Oliveira.
 * @date 19/10/2018.
 */
public class BaseComponent implements Component {

	/**
	 * A fila de clientes.
	 */
	private final UIFilaClientes fila;

	/**
	 * A lista de guiches.
	 */
	private final UIListaGuiche[] guiches;

	/**
	 * Cria um componente de execucao do simulador.
	 *
	 * @param fila    A fila de clientes do simulador.
	 * @param guiches todos os guiches contidos no simulador (estando ou n�o
	 *                ativos).
	 * @param teclado Um objeto de controle de teclado. Pode ser null.
	 */
	public BaseComponent(FilaClientesImp fila, GuicheImp[] guiches, TecladoImp teclado) {

		this.fila = new UIFilaClientes(fila);
		this.guiches = new UIListaGuiche[guiches.length];
		for (int i = 0; i < guiches.length; i++) {
			this.guiches[i] = new UIListaGuiche(guiches[i], FRAME_BORDA + i * (FRAME_BORDA + GUICHE_LARGURA),
					FRAME_BORDA);
		}
		if (teclado != null) {
			TECLADO = teclado;
		}
	}

	/**
	 * Inicializa o aplicativo.
	 */
	public final void start() {
		new UIFrame(this);
	}

	@Override
	public final void desenhar(Graphics g) {
		fila.desenhar(g);
		for (UIListaGuiche guiche : guiches) {
			guiche.desenhar(g);
		}
	}
}
