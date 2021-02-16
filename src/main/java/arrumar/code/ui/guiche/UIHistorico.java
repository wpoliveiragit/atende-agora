package arrumar.code.ui.guiche;

import static arrumar.code.ui.frame.UIFrameStatic.EstruturaFrame.ALTURA_LETRA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaHistorico.HISTORICO_ALTURA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaHistorico.HISTORICO_LARGURA;
import static arrumar.code.ui.frame.UIFrameStatic.EstruturaHistorico.HISTORICO_LINHAS;
import static arrumar.code.ui.graphics.UIDesenhar.escrever;
import static arrumar.code.ui.graphics.UIDesenhar.retanguloCheioBorda;
import static arrumar.code.ui.utilities.UIPaletaCores.COR_HISTORICO_FUNDO;
import static arrumar.code.ui.utilities.UIPaletaCores.COR_HISTORICO_TEXTO_A;
import static arrumar.code.ui.utilities.UIPaletaCores.COR_HISTORICO_TEXTO_B;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import arrumar.code.ui.graphics.UIGeometria.Retangulo;
import arrumar.code.ui.graphics.UIGeometria.Texto;
import arrumar.code.ui.utilities.UIObjeto;

/**
 * Criar uma Ã¡rea grafica para imprimir os 3 ultimos tickets em forma de uma
 * lista de cima para baixo.
 *
 * @author Wellington Pires de Oliveira.
 * @date 05/10/2018.
 */
public class UIHistorico extends UIObjeto {

	private List<Texto> linhas;
	private Retangulo corpo;
	private int indice;
	private Color corTexto;

	/**
	 * Cria a Ã¡rea de onde ficarÃ¡ o texto do histÃ³rico de atendimento do guiche.
	 *
	 * @param x o ponto do eixo do x.
	 * @param y o ponto do eixo do y
	 */
	public UIHistorico(int x, int y) {
		super(x, y);

		criarHistorico();
	}

	/**
	 * Cria um novo histÃ³rico.
	 */
	public final void criarHistorico() {
		indice = 0;
		corTexto = COR_HISTORICO_TEXTO_A;
		corpo = new Retangulo(COR_HISTORICO_FUNDO, x, y, HISTORICO_LARGURA, HISTORICO_ALTURA);
		linhas = new ArrayList<>();
		for (int i = 0; i < HISTORICO_LINHAS; i++) {
			linhas.add(new Texto(corTexto, "-", x + 5, y + ((i + 1) * (ALTURA_LETRA + 3))));
		}
	}

	/**
	 * adiciona um novo texto de ticket.
	 *
	 * @param txt O texto a ser adicionado.
	 */
	public void addTexto(String txt) {
		linhas.get(indice++).setTextoCor(txt, corTexto);
		if (indice == HISTORICO_LINHAS) {
			if (corTexto.equals(COR_HISTORICO_TEXTO_A)) {
				corTexto = COR_HISTORICO_TEXTO_B;
			} else {
				corTexto = COR_HISTORICO_TEXTO_A;
			}
			indice = 0;
		}
	}

	@Override
	public void desenhar(Graphics g) {
		retanguloCheioBorda(g, corpo);
		for (Texto t : linhas) {
			escrever(g, t);
		}
	}

}
