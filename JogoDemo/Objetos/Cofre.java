package JogoDemo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Chave;

public class Cofre extends Objeto {

	public Cofre() {
		super("O cofre está fechado",
			  "O cofre está aberto");
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
