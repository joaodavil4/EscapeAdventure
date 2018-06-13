package JogoDemo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Pilhas;

public class GPS extends Objeto {

	public GPS() {
		super("O GPS n�o liga",
			  "Corpstein Enterprise, seu destino est� h� 1.200 KM luz");
	}

	@Override
	public boolean usar(Ferramenta ferramenta) {
		if (ferramenta instanceof Pilhas) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}

}

