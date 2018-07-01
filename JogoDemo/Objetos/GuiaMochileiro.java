package JogoDemo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Oculos;

public class GuiaMochileiro extends Objeto {

	public GuiaMochileiro() {
		super("Guia do Mochileiro, Edição 1.5 - As letras estão estranhas, parece outro idioma \n",
			  "O guia descreve instruções de uma missão a ser seguida, e o próximo passo é seguir para o Planeta Saturno!");
	}

	@Override
	public boolean usar(Ferramenta ferramenta) {
		if (ferramenta instanceof Oculos) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}

}
