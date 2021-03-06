package JogoDemo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Chave;

public class Cofre extends Objeto {

	public Cofre() {
		super("O cofre est� fechado",
			  "O cofre est� aberto");
	}

	@Override
	public boolean usar(Ferramenta ferramenta) {
		if (ferramenta instanceof Chave) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}

}
