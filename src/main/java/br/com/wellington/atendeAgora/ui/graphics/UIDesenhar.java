package br.com.wellington.atendeAgora.ui.graphics;

import static br.com.wellington.atendeAgora.utilities.UIPaletaCores.PRETO;

import java.awt.Graphics;

import br.com.wellington.atendeAgora.ui.graphics.UIGeometria.Retangulo;
import br.com.wellington.atendeAgora.ui.graphics.UIGeometria.Texto;

/**
 * Classe de métodos estáticos para execução de formas geométricas de um Form.
 *
 * @author Wellington Pires de Oliveira.
 * @date 18/06/2018.
 */
public final class UIDesenhar {

	/**
	 * Desenha um retangulo pintado, mas sem as bordas.
	 *
	 * @param g A área gráfica onde será feito o deseno.
	 * @param r {@link code.ui.graphics.UIGeometria.Retangulo}.
	 */
	public static final void retanguloCheio(Graphics g, Retangulo r) {
		g.setColor(r.cor);
		g.fillRect(r.x, r.y, r.largura, r.altura);
	}

	/**
	 * Desenha apenas o contorno do retângulo.
	 *
	 * @param g A área gráfica onde será feiro o desenho.
	 * @param r {@link code.ui.graphics.UIGeometria.Retangulo}.
	 */
	public static final void retanguloBorda(Graphics g, Retangulo r) {
		g.setColor(r.cor);
		g.drawRect(r.x, r.y, r.largura, r.altura);
	}

	/**
	 * Desenha um retanguloCheio pintado com a cor que ele possui e desenha uma
	 * porda.
	 *
	 * @param g A área gráfica onde será feiro o desenho.
	 * @param r {@link code.ui.graphics.UIGeometria.Retangulo}.
	 */
	public static final void retanguloCheioBorda(Graphics g, Retangulo r) {
		g.setColor(PRETO.cor);
		g.drawRect(r.x, r.y, r.largura, r.altura);
		g.setColor(r.cor);
		g.fillRect(r.x + 1, r.y + 1, r.largura - 1, r.altura - 1);
	}

	/**
	 * Escreve um texto com a cor que ele possui.
	 *
	 * @param g A área gráfica onde será escrito
	 * @param t {@link code.ui.graphics.UIGeometria.Texto}.
	 */
	public static final void escrever(Graphics g, Texto t) {
		g.setColor(t.cor);
		g.drawString(t.texto, t.x, t.y);
	}

}
