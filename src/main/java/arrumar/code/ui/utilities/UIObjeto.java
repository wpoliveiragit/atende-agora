package arrumar.code.ui.utilities;

import arrumar.code.ui.component.Component;

/**
 * Todo objeto da Interface precisa ser uma extenção desta classe.
 *
 * @author Wellington Pires de Oliveira.
 * @date 10/09/2018.
 */
public abstract class UIObjeto implements Component {

	protected int x;
	protected int y;

	public UIObjeto(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
