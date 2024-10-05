package br.com.pegasus.atende.agora.ui.graphics;

import java.awt.Color;

/**
 * Classe de suporte para os parâmetros dosmétodos da classe
 * {@link UIUtilitarios.DesenharUI}.
 *
 * @author Wellington Pires de Oliveira.
 * @date 18/09/2018.
 */
public class UIGeometria {

    /**
     * Classe representativa de um retángulo.
     */
    public static class Retangulo extends Local {

        /**
         * A largura do desenho.
         */
        int largura;
        /**
         * A altura do desenho.
         */
        int altura;

        /**
         * Representação de um retângulo.
         *
         * @param cor A cor de fundo.
         * @param x Eixo x do lado superior esquerdo.
         * @param y Eixo y do lado superior esquerdo.
         * @param largura O tamanho do eixo x.
         * @param altura O tamanho do eixo y.
         */
        public Retangulo(Color cor, int x, int y, int largura, int altura) {
            super(x, y, cor);
            this.largura = largura;
            this.altura = altura;
        }

        /**
         * Configura uma nova cor.
         *
         * @param cor A nova cor.
         */
        public void setCor(Color cor) {
            this.cor = cor;
        }

    }

    /**
     * Classe que guarda os dados de representação de um texto desta classe.
     */
    public static class Texto extends Local {

        /**
         * O texto que será desenhado.
         */
        String texto;

        /**
         * Guarda a representação de um texto.
         *
         * @param cor A cor que ele possui.
         * @param texto O texto.
         * @param x A coordenada x do ponto.
         * @param y A coordenada y do ponto.
         */
        public Texto(Color cor, String texto, int x, int y) {
            super(x, y, cor);
            this.texto = texto;
        }

        /**
         * Insere um novo texto e reconfigura a posição.
         *
         * @param txt O texto a ser inserido.
         * @param x o ponto do eixo do x.
         * @param y O ponto do eixo do y.
         */
        public void setTextoLocal(String txt, int x, int y) {
            texto = txt;
            this.x = x;
            this.y = y;
        }

        /**
         * Insere um novo texto e reconfigura cor.
         *
         * @param txt O texto a ser inserido.
         * @param cor A cor do texto
         */
        public void setTextoCor(String txt, Color cor) {
            texto = txt;
            this.cor = cor;
        }

        /**
         * Insere um novo texto.
         *
         * @param txt O texto a ser inserido.
         */
        public void setTexto(String txt) {
            this.texto = txt;
        }

    }

    /**
     * Definição do que a classe representa ou administra
     *
     * @author Wellington Pires de Oliveira.
     * @date 07/03/2019
     * @path AtendeAgora.UIGraphics.Local2
     */
    abstract static class Local {

        /**
         * Ponto do eixo x.
         */
        int x;
        /**
         * Ponto do eixo y.
         */
        int y;
        /**
         * A cor do desenho.
         */
        Color cor;

        /**
         * Cria a localização do ponto onde o desenho irá ficar.
         *
         * @param x Ponto do eixo x.
         * @param y Ponto do eixo y
         */
        Local(int x, int y, Color cor) {
            this.x = x;
            this.y = y;
            this.cor = cor;
        }

    }
}
