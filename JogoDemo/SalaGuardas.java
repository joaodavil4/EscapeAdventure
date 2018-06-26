package JogoDemo;

import ClassesBasicas.Ferramenta;
import JogoDemo.Ferramentas.Garrafa;
import JogoDemo.Objetos.CaixaFerramentas;
import JogoDemo.Objetos.Marciano;

public class SalaGuardas extends SalaJogoDemo {
	private boolean bebado;
	
	public SalaGuardas() {
		super("Sala de Guardas");
		bebado = false;
		//OBJETOS
		CaixaFerramentas caixa = new CaixaFerramentas();
		Marciano marciano = new Marciano();
		this.getObjetos().put("Caixa", caixa);
		this.getObjetos().put("Marciano", marciano);
		//FERRAMENTAS n tem :(
		Garrafa garrafa = new Garrafa();
		this.getFerramentas().put(garrafa.getDescricao(), garrafa);
		
	}

	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Você está na").append(this.getNome()).append("\n");
		if (bebado) {
			descricao.append("O guarda dormiu, é a sua chance");
			
		}
		return null;
	}

	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
		if (f == null) {
			return false;
		}
		if (f instanceof Garrafa) {
			bebado = true;
		}
		return false;
	}
}
