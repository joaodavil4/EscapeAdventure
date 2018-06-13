package JogoDemo;

import ClassesBasicas.Sala;

public class SalaSemNome extends SalaJogoDemo {

	public SalaSemNome(String nome){
		super(nome);	
	}
	
	@Override
	public String textoDescricao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean usa(String ferramenta) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean pega(String ferramenta) {
		return true;
	}

}
