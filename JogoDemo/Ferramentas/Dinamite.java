package JogoDemo.Ferramentas;

import ClassesBasicas.Ferramenta;

public class Dinamite extends Ferramenta {
    private boolean usada;
    
	public Dinamite() {
		super("Dinamite");
	    this.usada = false;	
	}

	@Override
	public boolean usar() {
		if (!usada) {
			usada = true;
		}
		return !usada;
	}
}
