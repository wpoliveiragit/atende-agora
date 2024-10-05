package br.com.pegasus.atende.agora.fila;

import br.com.pegasus.atende.agora.guiche.Guiche;
import br.com.pegasus.atende.agora.ui.fila.ListaAtendentes;

/**
 * Guarda todos os guiches disponíveis para o controle do sistema.
 *
 * @author Wellington Pires de Oliveira.
 * @date 18/03/2019
 * @path AtendeAgora.Fila.ListaGuiches
 */
public class ListaGuiches {

    /**
     * Tamanho da fila de guiches.
     */
    public static int TAMANHO = 5;

    /**
     * Todos os guiches do sistema.
     */
    private final Guiche[] listaGuiches;

    public ListaGuiches(ListaAtendentes listaAtendente, FilaClientes filaClientes) {
        listaGuiches = new Guiche[TAMANHO];
        for (int i = 0; i < listaGuiches.length; i++) {
            listaGuiches[i] = new Guiche(listaAtendente, filaClientes);
            try {
                Thread.sleep(130);
            } catch (InterruptedException e) {

            }
            listaGuiches[i].iniciar();
        }
    }

    /**
     * Abre ou fecha um guiche. Antes fechar um guiche, o atendente terminará de
     * atender o cliente.
     *
     * @param i O indice do guiche.
     * @return false se i for negativo ou se i for maior que o tamanho da lista
     * de guiches.
     */
    public boolean fecharAbrir(int i) {
        try {
            if (listaGuiches[i].isAberto()) {
                listaGuiches[i].finalizar();
            } else {
                listaGuiches[i].iniciar();
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    /**
     * Retorna todos os guiches da lista de guiche.
     *
     * @return Todos os guiches da lista de guiche.
     */
    public Guiche[] getGuiches() {
        return listaGuiches;
    }
}
