package br.com.pegasus.atende.agora.ui.fila;

import static br.com.pegasus.atende.agora.ui.frame.UIFrameStatic.EstruturaFila.FILA_ALTURA;
import static br.com.pegasus.atende.agora.ui.frame.UIFrameStatic.EstruturaFila.FILA_BORDA;
import static br.com.pegasus.atende.agora.ui.frame.UIFrameStatic.EstruturaFila.FILA_LARGURA;
import static br.com.pegasus.atende.agora.ui.frame.UIFrameStatic.EstruturaPessoa.PESSOA_LARGURA;
import static br.com.pegasus.atende.agora.ui.graphics.UIDesenhar.retanguloCheioBorda;
import static br.com.pegasus.atende.agora.utilities.UIPaletaCores.COR_FILA_PISO;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import br.com.pegasus.atende.agora.ui.frame.UIFrameStatic.EstruturaFila;
import br.com.pegasus.atende.agora.ui.graphics.UIGeometria.Retangulo;
import br.com.pegasus.atende.agora.ui.pessoa.UICliente;
import br.com.pegasus.atende.agora.utilities.UIObjeto;

/**
 * Representa uma fila gráfica.
 *
 * @author Wellington Pires de Oliveira.
 * @date 14/09/2018.
 */
public class UIFilaClientes extends UIObjeto {

	/**
	 * A fila que será representada.
	 */
	private final FilaClientesImp fila;
	/**
	 * A fila que será desenhada.
	 */
	private List<UICliente> uiFila;
	/**
	 * Representação dos dados graficos do desenho da fila.
	 */
	private Retangulo corpo;

	/**
	 * Cria e inicializa a fila grafica
	 *
	 * @param fila A fila a ser representada.
	 */
	public UIFilaClientes(FilaClientesImp fila) {
		super(EstruturaFila.x, EstruturaFila.y);
		this.fila = fila;
		init();
	}

	/**
	 * inicializador da interface.
	 */
	private void init() {
		uiFila = new ArrayList<>();
		corpo = new Retangulo(COR_FILA_PISO, x, y, FILA_LARGURA, FILA_ALTURA);
		verificarFila();
	}

	/**
	 * Configura as dimeções da fila.
	 */
	private void verificarFila() {
		if (uiFila.size() == fila.size()) {
			return;
		}
		uiFila.clear();
		for (int i = 0; i < fila.size(); i++) {
			uiFila.add(new UICliente(fila.get(i), x + FILA_BORDA + i * (FILA_BORDA + PESSOA_LARGURA), y + FILA_BORDA));
		}
	}

	@Override
	public void desenhar(Graphics g) {
		verificarFila();
		retanguloCheioBorda(g, corpo);
		for (UICliente c : uiFila) {
			c.desenhar(g);
		}
	}

}
