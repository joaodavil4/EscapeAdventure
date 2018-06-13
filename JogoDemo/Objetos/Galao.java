package JogoDemo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Abridor;


public class Galao extends Objeto {
	public Galao() {
		super("Galão de combustivel", "Tanque cheio!");
	}

	@Override
	public boolean usar(Ferramenta f) {
		if (f instanceof Abridor) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	
	}

}
