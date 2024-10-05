package br.com.pegasus.atende.agora.ui.sistema;

import br.com.pegasus.atende.agora.fila.FilaClientes;
import br.com.pegasus.atende.agora.fila.ListaGuiches;
import br.com.pegasus.atende.agora.ui.component.BaseComponent;
import br.com.pegasus.atende.agora.ui.fila.ListaAtendentes;
import br.com.pegasus.atende.agora.ui.frame.TecladoImp;

/**
 * Central de controle do Sistema.
 *
 * @author Wellington Pires de Oliveira.
 * @date 15/10/2018.
 */
public class Sistema {

	/**
	 * Lista de atendentes disponíveis para trabalhar.
	 */
	private ListaAtendentes listaAtendente;
	/**
	 * Fila de clientes disponíveis para atendimento.
	 */
	private FilaClientes filaClientes;
	/**
	 * Todos os guiches do sistema.
	 */
	// private Guiche[] listaGuiches;

	private ListaGuiches lGuiches;
	/**
	 * Controle do teclado do sistema.
	 */
	private TecladoImp teclado;

	/**
	 * Criar uma descrição melhor para o metodos indicando qual metodo deve ser
	 * inicializado primeiro.
	 */
	public Sistema() {
		init();
	}

	private void init() {
		// Inicializa a base de arquivos do sistema
		// SuporteRegistro s = new SuporteRegistro();
		// Inicializando lista de atendentes
		listaAtendente = new ListaAtendentes();
		listaAtendente.carregarAtendentes();
		// cria e inicializa a fila de clientes
		filaClientes = new FilaClientes(1000, 55);
		filaClientes.iniciar();
		// Cria e inicializa os guiches lincando a lista de atendentes e fila de
		// clientes
		lGuiches = new ListaGuiches(listaAtendente, filaClientes);
//        listaGuiches = new Guiche[5];
//        for (int i = 0; i < listaGuiches.length; i++) {
//            listaGuiches[i] = new Guiche(listaAtendente, filaClientes);
//            try {
//                Thread.sleep(130);
//            } catch (InterruptedException e) {
//
//            }
//            listaGuiches[i].iniciar();
//        }

		// cria o controle de teclas
		teclado = new TecladoImp() {
			// Criar uma descrição para cada comando do teclado.
			@Override
			public void espaco() {
				if (filaClientes.isAtivo()) {
					filaClientes.finalizar();
				} else {
					filaClientes.iniciar();
				}
			}

			@Override
			public void digitoN1() {
				lGuiches.fecharAbrir(0);
			}

			@Override
			public void digitoN2() {
				lGuiches.fecharAbrir(1);
			}

			@Override
			public void digitoN3() {
				lGuiches.fecharAbrir(2);
			}

			@Override
			public void digitoN4() {
				lGuiches.fecharAbrir(3);
			}

			@Override
			public void digitoN5() {
				lGuiches.fecharAbrir(4);
			}
		};
	}

	/**
	 * Inicializa o sistema.
	 */
	public void iniciar() {
		BaseComponent ca = new BaseComponent(filaClientes, lGuiches.getGuiches(), teclado);
		ca.start();
	}

}
