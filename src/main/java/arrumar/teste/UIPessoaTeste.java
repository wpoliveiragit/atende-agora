package arrumar.teste;

import arrumar.code.pessoa.Pessoa;
import arrumar.code.ui.frame.UIFrame;
import arrumar.code.ui.pessoa.UIPessoa;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 19/10/2018.
 */
public class UIPessoaTeste {

    public static void main(String[] args) {
        Pessoa p = new Pessoa(-1) {
            @Override
            public String getDados() {
                return null;
            }

        };
        UIPessoa pui = new UIPessoa(p, 5, 5) {
           

        };

        new UIFrame(pui);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {

                }
            }
        }).start();
    }
}
