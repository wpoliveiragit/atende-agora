package arrumar.code.ui.fila;

import java.util.ArrayList;
import java.util.List;

import arrumar.code.pessoa.Atendente;

/**
 * Cria uma lista contendo todos os atendentes do simulador.
 *
 * @author Wellington Pires de Oliveira.
 * @date 24/09/2018.
 */
public class ListaAtendentes {

    /**
     * Lista de atendentes disponíveis.
     */
    private final List<Atendente> lista;
    
    /**
     * Tamanho da lista de atendentens
     */
    private static final int TAMANHO = 5;

    /**
     * Cria a lista de atendentes contendo todos os atendentes disponíveis para
     * entrar no guiche.
     */
    public ListaAtendentes() {
        lista = new ArrayList<>();        
    }

    /**
     * Retorna uma lista contendo todos os atendentes.
     */
    public void carregarAtendentes() {
        
        for (int i = 0; i < TAMANHO; i++) {
            lista.add(new Atendente());
        }
    }
    
    /**
     * Carrega os atendentes registrados em arquivo
     */
    public void testeCarregarAtendente(){
        
    }
    

    /**
     * Retorna um atendente que esteja disponivel.
     *
     * @return null caso a lista esteja vazia.
     */
    public Atendente getAtendente() {
        return lista.isEmpty() ? null : lista.remove(0);
    }

    /**
     * Adiciona um atendente na lista de disponíveis. Ao adicionar o atendentes
     * os dados contidos nele serão registrados no banco de dados.
     *
     * @param atendente o atendente.
     */
    public void setAtendente(Atendente atendente) {
        //Atualizar os dados do atendente no banco.
        lista.add(atendente);
    }

}
