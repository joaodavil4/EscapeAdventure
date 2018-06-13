package JogoDemo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Bilhete;

public class Cadeado extends Objeto {
	public Cadeado() {
		super("Você não alcança o cadeado", "Passagem secreta aberta!");
	}

	@Override //REPETE A MESMA FERRAMENTA????
	public boolean usar(Ferramenta f) {
		if (f instanceof Bilhete) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}

}
