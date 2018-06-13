package JogoDemo;

public class SalaGuardas extends SalaJogoDemo {
	private boolean preso;
	
	public SalaGuardas() {
		super("Sala de Guardas");
		preso = true;
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
