package JogoDemo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Oculos;

public class GuiaMochileiro extends Objeto {

	public GuiaMochileiro() {
		super("As letras est�o estranhas, parece outro idioma",
			  "O livro descreve instru��es de uma miss�o a ser seguida, e o pr�ximo passo � seguir para o Planeta Saturno!");
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
