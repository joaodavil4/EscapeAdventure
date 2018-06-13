package JogoDemo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Bilhete;


public class Escada extends Objeto {
	public Escada() {
		super("Nao subiu", "Em cima da escada");
	}

	@Override
	public boolean usar(Ferramenta f) {
		if (f instanceof Bilhete) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}
	

}
