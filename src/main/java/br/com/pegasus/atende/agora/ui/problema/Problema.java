package br.com.pegasus.atende.agora.ui.problema;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 25/09/2018.
 */
public class Problema {

    /**
     * Tipo do problema
     */
    private final char nome;
    /**
     * O tempo que levará para tentar resolver o problema.
     */
    private final int tempo;
    /**
     * Chance de erro de resolução.
     */
    private final int erro;

    /**
     * Cria um novo problema para o simulador.
     *
     * @param tipo o tipo do problema
     * @param tempo o tempo que levará para tentar resolver o problema em
     * milisegundos.
     * @param erro Chance de erro de resolução.
     */
    public Problema(char tipo, int tempo, int erro) {
        this.nome = tipo;
        this.tempo = tempo;
        this.erro = erro;
    }

    /**
     * Retorna o nome do problema.
     *
     * @return O nome do problema.
     */
    public char getNome() {
        return nome;
    }

    /**
     * Retorna o tempo que levará para tentar resolver o problema.
     *
     * @return O tempo que levará para resolver o problema em milissegundos
     * variando entre 1000 a 5000.
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * Retorna Chance de erro de resolução.
     *
     * @return Chance de erro de resolução.
     */
    public int getErro() {
        return erro;
    }

}
