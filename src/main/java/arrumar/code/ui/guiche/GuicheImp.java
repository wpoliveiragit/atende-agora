package arrumar.code.ui.guiche;

import arrumar.code.ui.pessoa.ClienteImp;
import arrumar.code.ui.pessoa.FuncionarioImp;

/**
 * Assinatura necessaria de um guiche.
 *
 * @author Thon
 */
public interface GuicheImp {

    /**
     * Informa se o guiche esta aberto.
     *
     * @return true para aberto.
     */
    public boolean isAberto();

    /**
     * Retorna o cliente que está no guiche.
     *
     * @return null caso não contenha um cliente.
     */
    public ClienteImp getCliente();

    /**
     * Retorna o atendente que está no guiche.
     *
     * @return null caso não contenha um atendente.
     */
    public FuncionarioImp getAtendente();
}
