package JogoDemo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Garrafa;

public class CaixaFerramentas extends Objeto {
	public CaixaFerramentas() {
		super("Caixa fechada", "Voce pegou a caixa!");
		
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
