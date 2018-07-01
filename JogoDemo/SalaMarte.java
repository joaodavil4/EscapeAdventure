package JogoDemo;

import ClassesBasicas.Sala;

public class SalaMarte extends SalaJogoDemo {
	private boolean livre; //sei la
	
	public SalaMarte() {
		super("Marte", "7");
		
		//quando concertar, apertar no botao OK
		//trocar a imagem para a 8
		//aparecer o texto final.
		//botão encerrar.
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

}
