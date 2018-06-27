package JogoDemo;

import ClassesBasicas.Sala;

public abstract class SalaJogoDemo extends Sala {

	public SalaJogoDemo(String nome, String repVis) {
		super(nome, repVis);
	}

	@Override
	public boolean pega(String nomeFerramenta) {
		boolean resp = super.pega(nomeFerramenta);
		this.getFerramentas().remove(nomeFerramenta);
		return resp;
	}
}
