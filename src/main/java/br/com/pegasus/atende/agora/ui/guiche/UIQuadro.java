package br.com.pegasus.atende.agora.ui.guiche;

import static br.com.pegasus.atende.agora.ui.frame.UIFrameStatic.EstruturaFrame.ALTURA_LETRA;
import static br.com.pegasus.atende.agora.ui.frame.UIFrameStatic.EstruturaGuiche.GUICHE_QUADRO_ALTURA;
import static br.com.pegasus.atende.agora.ui.frame.UIFrameStatic.EstruturaGuiche.GUICHE_QUADRO_LARGURA;
import static br.com.pegasus.atende.agora.ui.graphics.UIDesenhar.escrever;
import static br.com.pegasus.atende.agora.ui.graphics.UIDesenhar.retanguloCheioBorda;
import static br.com.pegasus.atende.agora.utilities.UIPaletaCores.COR_GUICHE_QUADRO;
import static br.com.pegasus.atende.agora.utilities.UIPaletaCores.COR_QUADRO_TEXTO_EXPERIENCIA;

import java.awt.Graphics;

import br.com.pegasus.atende.agora.ui.component.Component;
import br.com.pegasus.atende.agora.ui.graphics.UIGeometria.Retangulo;
import br.com.pegasus.atende.agora.ui.graphics.UIGeometria.Texto;
import br.com.pegasus.atende.agora.utilities.UIObjeto;

/**
 * Definição do que a classe representa ou administra
 *
 * @author Wellington Pires de Oliveira.
 * @date 14/12/2018
 * @path AtendeAgora.UIGuiche.UIQuadro
 */
public class UIQuadro extends UIObjeto {

	/**
	 * Quadro de experiência do Atendente.
	 */
	private Retangulo quadro;

	/**
	 * Guarda o local e a mensagem de cada texto contino no quadro.
	 */
	private PontoTexto[] listaTexto;

	/**
	 * Cria um quadro de fundo branco com letras pretas.
	 *
	 * @param x Coordenada do eixo x.
	 * @param y Coordenada do eixo y.
	 */
	public UIQuadro(int x, int y) {
		super(x, y);
		init();
	}

	/**
	 * Inicializa o quadro.
	 */
	public final void init() {
		// Cria o quadro
		quadro = new Retangulo(COR_GUICHE_QUADRO, x, y, GUICHE_QUADRO_LARGURA, GUICHE_QUADRO_ALTURA);
		// Cria os ponto de texto do quadro
		listaTexto = new PontoTexto[12];

		// Inicializa a lista de texto
		int d = 10; // deslocamento de texto

		int index = 0; // tamanho da coluna
		for (int i = 0; i < listaTexto.length / 2; i++) {
			listaTexto[index++] = new PontoTexto(x + d, y + ALTURA_LETRA + i * (ALTURA_LETRA + 3), "-");
		}
		d = d * 6;
		for (int i = 0; index < listaTexto.length; i++) {
			listaTexto[index++] = new PontoTexto(x + d, y + ALTURA_LETRA + i * (ALTURA_LETRA + 3), "-");
		}
	}

	/**
	 * Configura até 12 textos onde cada um pode comportar até "qtde caracter".
	 *
	 * @param txts um array contendo todos os textos que será impresso no quadro.
	 */
	public final void setTextos(String[] txts) {
		// verifica se o parâmetro é valido
		if (txts == null || txts.length > listaTexto.length) {
			return;
		}
		for (int i = 0; i < txts.length; i++) {
			listaTexto[i].texto.setTexto(txts[i]);
		}
	}

	@Override
	public void desenhar(Graphics g) {
		retanguloCheioBorda(g, quadro);
		if (listaTexto == null) {
			return;
		}
		for (PontoTexto p : listaTexto) {
			p.desenhar(g);
		}
	}

	/**
	 * Guarda um texto e a posição onde ele devera ficar no frame.
	 */
	private class PontoTexto implements Component {

		/**
		 * O texto do ponto.
		 */
		Texto texto;

		/**
		 * Cria um objeto que guarda a posição onde o texto deverá ficar.
		 *
		 * @param x   Coordenada do eixo x.
		 * @param y   Coordenada do eixo y.
		 * @param txt O texto do ponto.
		 */
		public PontoTexto(int x, int y, String txt) {
			texto = new Texto(COR_QUADRO_TEXTO_EXPERIENCIA, txt, x, y);
		}

		@Override
		public void desenhar(Graphics g) {
			escrever(g, texto);
		}

	}

}
