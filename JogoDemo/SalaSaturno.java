package JogoDemo;

public class SalaSaturno extends SalaJogoDemo {
	private boolean combustivel;
	
	public SalaSaturno() {
		super("Planeta Saturno!");
		combustivel=false;
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
