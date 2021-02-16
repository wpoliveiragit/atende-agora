package br.com.wellington.atendeAgora.ui.pessoa;

import static br.com.wellington.atendeAgora.ui.frame.UIFrameStatic.EstruturaFrame.ALTURA_LETRA;
import static br.com.wellington.atendeAgora.ui.frame.UIFrameStatic.EstruturaFrame.LARGURA_LETRA;
import static br.com.wellington.atendeAgora.ui.frame.UIFrameStatic.EstruturaPessoa.PESSOA_ALTURA;
import static br.com.wellington.atendeAgora.ui.frame.UIFrameStatic.EstruturaPessoa.PESSOA_LARGURA;
import static br.com.wellington.atendeAgora.ui.graphics.UIDesenhar.escrever;
import static br.com.wellington.atendeAgora.ui.graphics.UIDesenhar.retanguloBorda;
import static br.com.wellington.atendeAgora.ui.graphics.UIDesenhar.retanguloCheio;
import static br.com.wellington.atendeAgora.utilities.UIPaletaCores.COR_SEXO_HOMEM;
import static br.com.wellington.atendeAgora.utilities.UIPaletaCores.COR_SEXO_MULHER;
import static br.com.wellington.atendeAgora.utilities.UIPaletaCores.PRETO;
import static br.com.wellington.atendeAgora.utilities.UIPaletaCores.getCabelos;
import static br.com.wellington.atendeAgora.utilities.UIPaletaCores.getRoupas;

import java.awt.Graphics;

import br.com.wellington.atendeAgora.ui.graphics.UIGeometria.Retangulo;
import br.com.wellington.atendeAgora.ui.graphics.UIGeometria.Texto;
import br.com.wellington.atendeAgora.utilities.UIObjeto;

/**
 * Representa uma pessoa gráfica.
 *
 * @author Wellington Pires de Oliveira.
 * @date 10/09/2018.
 */
public abstract class UIPessoa extends UIObjeto implements PessoaImp {

	/**
	 * Contorno do Desenho.
	 */
	private Retangulo corpo;

	/**
	 * Quadrado superior do desenho.
	 */
	private Retangulo cabelo;

	/**
	 * Quadrado inferior do desenho.
	 */
	protected Retangulo roupa;

	/**
	 * Texto do quadrado superior do desenho.
	 */
	private Texto nome;

	/**
	 * Texto do quadrado inferior do desenho.
	 */
	private Texto idade;

	/**
	 * Quadrado que representa o sexo da pessoa localizado no quadrado inferior do
	 * desenho.
	 */
	private Retangulo sexo;

	/**
	 * A pessoa a ser instanciada.
	 */
	private final PessoaImp pessoa;

	/**
	 * Cria um objeto gráfico da classe.
	 *
	 * @param pessoa A pessoa a ser representada.
	 * @param x      dado do eixo x.
	 * @param y      dado do eixo y.
	 */
	public UIPessoa(PessoaImp pessoa, int x, int y) {
		super(x, y);
		this.pessoa = pessoa;
		init();
	}

	private void init() {
		// Configura os dados do contorno do desenho.
		int x1 = x;
		int y1 = y;
		int x2 = PESSOA_LARGURA;
		int y2 = PESSOA_ALTURA;
		corpo = new Retangulo(PRETO.cor, x1, y1, x2, y2);

		// Configura os dados do retanguloCheio referente a área do cabelo.
		x1 = x + 1;
		y1 = y + 1;
		x2 = PESSOA_LARGURA - 1;
		y2 = PESSOA_ALTURA / 2;
		cabelo = new Retangulo(getCabelos(pessoa.getCabelo()), x1, y1, x2, y2);

		// Configura os dados do retanguloCheio referente a área da roupa.
		x1 = x + 1;
		y1 = y + PESSOA_ALTURA / 2 + 1;
		x2 = PESSOA_LARGURA - 1;
		y2 = PESSOA_ALTURA / 2 - 1;
		roupa = new Retangulo(getRoupas(pessoa.getRoupa()), x1, y1, x2, y2);

		// Configura a posição do nome no retanguloCheio referente a área do cabelo.
		x1 = x + (PESSOA_LARGURA - pessoa.getNome().length() * LARGURA_LETRA) / 2;
		y1 = y + ((PESSOA_ALTURA / 2 - 1) - ALTURA_LETRA) / 2 + ALTURA_LETRA;
		nome = new Texto(PRETO.cor, pessoa.getNome(), x1, y1);

		// Configura a posição da idade no retanguloCheio referente a área da roupa.
		x1 = x + (PESSOA_LARGURA - (pessoa.getIdade() + "").length() * LARGURA_LETRA) / 2;
		y1 = y + PESSOA_ALTURA / 2 + ((PESSOA_ALTURA / 2 - ALTURA_LETRA) / 2 + ALTURA_LETRA);
		idade = new Texto(PRETO.cor, pessoa.getIdade() + "", x1, y1);

		// Configura o símbolo referente ao sexo da pessoa
		x1 = x + PESSOA_LARGURA - 5;
		y1 = y + PESSOA_ALTURA - 5;
		sexo = new Retangulo((pessoa.isSexo() ? COR_SEXO_HOMEM : COR_SEXO_MULHER), x1, y1, 4, 4);
	}

	@Override
	public String getNome() {
		return pessoa.getNome();
	}

	@Override
	public int getIdade() {
		return pessoa.getIdade();
	}

	@Override
	public boolean isSexo() {
		return pessoa.isSexo();
	}

	@Override
	public int getCabelo() {
		return pessoa.getCabelo();
	}

	@Override
	public int getRoupa() {
		return pessoa.getRoupa();
	}

	@Override
	public void desenhar(Graphics g) {
		g.getFont().deriveFont(25);
		retanguloBorda(g, corpo);
		retanguloCheio(g, cabelo);
		retanguloCheio(g, roupa);
		escrever(g, nome);
		escrever(g, idade);
		retanguloCheio(g, sexo);
	}

	@Override
	public String getDados() {
		return null;
	}

}
