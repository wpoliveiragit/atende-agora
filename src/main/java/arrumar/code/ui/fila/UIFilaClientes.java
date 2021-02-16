package arrumar.code.ui.fila;

import static arrumar.code.ui.frame.UIFrameStatic.EstruturaFila.FILA_ALTURA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaFila.FILA_BORDA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaFila.FILA_LARGURA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaPessoa.PESSOA_LARGURA;
import static arrumar.code.ui.graphics.UIDesenhar.retanguloCheioBorda;
import static arrumar.code.ui.utilities.UIPaletaCores.COR_FILA_PISO;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import arrumar.code.ui.frame.UIFrameStatic.EstruturaFila;
import arrumar.code.ui.graphics.UIGeometria.Retangulo;
import arrumar.code.ui.pessoa.UICliente;
import arrumar.code.ui.utilities.UIObjeto;

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
