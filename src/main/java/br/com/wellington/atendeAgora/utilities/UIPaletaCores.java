package br.com.wellington.atendeAgora.utilities;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Enum de definição das cores disponíveis para uso dentro do aplicativo.
 *
 * @author Wellington Pires de Oliveira.
 * @date 10/09/2018.
 */
public enum UIPaletaCores {

    //Cores Base
    AMARELO(0, Color.yellow),
    AMARELO_ESCURO(1, Color.yellow.darker()),
    AZUL(2, Color.blue),
    AZUL_ESCURO(3, Color.blue.darker()),
    BRANCO(4, Color.white),
    CIANO(5, Color.CYAN),
    CIANO_ESCURO(6, Color.cyan.darker()),
    CINZA_1(7, Color.lightGray),
    CINZA_2(8, Color.gray),
    CINZA_3(9, Color.darkGray.brighter()),
    CINZA_4(10, Color.darkGray),
    LARANJA(11, Color.orange),
    LARANJA_ESCURO(12, Color.orange.darker()),
    MAGENTA(13, Color.magenta),
    MAGENTA_ESCURO(14, Color.magenta.darker()),
    PRETO(15, Color.black),
    ROSA(16, Color.pink),
    ROSA_ESCURO(17, Color.pink.darker()),
    VERDE(18, Color.green),
    VERDE_ESCURO(19, Color.green.darker()),
    VERMELHO(20, Color.red),
    VERMELHO_ESCURO(21, Color.red.darker());

    /**
     * Definição da cor do piso da fila.
     */
    public static final Color COR_FILA_PISO = CINZA_1.cor;

    /**
     * A cor base do fundo do Frame.
     */
    public static final Color COR_FRAME_FUNDO = CIANO.cor;

    /**
     * Cor de fundo do quadro de texto do histórico.
     */
    public static final Color COR_HISTORICO_FUNDO = MAGENTA.cor;

    /**
     * Cor A do texto do historico.
     */
    public static final Color COR_HISTORICO_TEXTO_A = PRETO.cor;

    /**
     * Cor do texto do quadro de experiencia do atendente.
     */
    public static final Color COR_QUADRO_TEXTO_EXPERIENCIA = PRETO.cor;

    /**
     * Cor B do texto do historico.
     */
    public static final Color COR_HISTORICO_TEXTO_B = LARANJA.cor;

    /**
     * Cor que a cadeira de uma pessoa terá.
     */
    public static final Color COR_GUICHE_CADEIRA = BRANCO.cor;

    /**
     * Cor do piso do guiche.
     */
    public static final Color COR_GUICHE_PISO = CIANO_ESCURO.cor;

    /**
     * Cor de fundo do quadro de experiencia do atendente no guiche.
     */
    public static final Color COR_GUICHE_QUADRO = BRANCO.cor;

    /**
     * Define a cor do sexo feminino.
     */
    public static final Color COR_SEXO_MULHER = BRANCO.cor;

    /**
     * Define a cor do sexo masculino.
     */
    public static final Color COR_SEXO_HOMEM = PRETO.cor;

    /**
     * Guarda todas as cores de roupas.
     */
    private static final List<Color> ROUPAS;

    /**
     * Guarda todas as cores de cabelos.
     */
    private static final List<Color> CABELOS;

    static {
        ROUPAS = new ArrayList<>();
        ROUPAS.add(AMARELO_ESCURO.cor);
        ROUPAS.add(AZUL.cor);
        ROUPAS.add(AZUL_ESCURO.cor);
        ROUPAS.add(LARANJA_ESCURO.cor);
        ROUPAS.add(ROSA.cor);
        ROUPAS.add(VERDE.cor);
        ROUPAS.add(VERDE_ESCURO.cor);
        ROUPAS.add(VERMELHO_ESCURO.cor);

        CABELOS = new ArrayList<>();
        CABELOS.add(UIPaletaCores.BRANCO.cor);
        CABELOS.add(UIPaletaCores.AMARELO.cor);
        CABELOS.add(UIPaletaCores.CINZA_2.cor);
        CABELOS.add(UIPaletaCores.CINZA_3.cor);
        CABELOS.add(UIPaletaCores.VERMELHO.cor);
    }

    /**
     * O código da cor.
     */
    public final int codigo;

    /**
     * A cor.
     */
    public final Color cor;

    /**
     * Construtor base da paleta de cores
     *
     * @param codigo O código da cor da palheta
     * @param cor A cor.
     */
    private UIPaletaCores(int codigo, Color cor) {
        this.codigo = codigo;
        this.cor = cor;
    }

    /**
     * Construtor de cores de lugares.
     *
     * @param uiCor Cor existende em UIPaletaCores.
     */
    private UIPaletaCores(UIPaletaCores uiCor) {
        codigo = uiCor.codigo;
        cor = uiCor.cor;
    }

    /**
     * Retorna a cor de uma roupa.
     *
     * @param index o indice da cor da roupa.
     * @return A cor de uma roupa.
     */
    public static final Color getRoupas(int index) {
        return ROUPAS.get(index);
    }

    /**
     * Retorna a cor de uma roupa
     *
     * @param index O índice da cor da roupa.
     * @return A cor de uma roupa.
     */
    public static final Color getCabelos(int index) {
        return CABELOS.get(index);
    }

}
