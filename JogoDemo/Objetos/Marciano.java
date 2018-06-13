package JogoDemo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Garrafa;

public class Marciano extends Objeto {
	public Marciano() {
		super("Guarda-marciano entendiado", "Guarda-marciano bebado");
	}

	@Override //1 FERRAMENTA PARA DOIS OBJETOS???
	public boolean usar(Ferramenta f) {
		if (f instanceof Garrafa) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}
	
}
