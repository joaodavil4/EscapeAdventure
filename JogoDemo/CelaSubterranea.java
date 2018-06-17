package JogoDemo;

import ClassesBasicas.Ferramenta;
import JogoDemo.Ferramentas.Bilhete;
import JogoDemo.Ferramentas.Escada;
import JogoDemo.Ferramentas.Garrafa;
import JogoDemo.Objetos.Cadeado;

public class CelaSubterranea extends SalaJogoDemo {
	private boolean livre;
	
	public CelaSubterranea() {
		super("Cela Subterranea");
		livre=false;
		//OBJETOS
		Cadeado cadeado = new Cadeado();
		this.getObjetos().put("Cadeado", cadeado);
		//FERRAMENTAS
		Bilhete bilhete = new Bilhete();
		Garrafa garrafa = new Garrafa();
		Escada escada = new Escada();
		this.getFerramentas().put(bilhete.getDescricao(), bilhete);
		this.getFerramentas().put(garrafa.getDescricao(), garrafa);
		this.getFerramentas().put(escada.getDescricao(), escada);
	}
	
	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Você chegou em Marte, porém foi recebido por uma horda de marcianos seguidores da primeira ordem");
		if (livre) {
			descricao.append("Você conseguiu fugir da cela");
		}
		else {
			descricao.append("N cei");
		}
		return null;
	}

	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
		if (f == null) {
			return false;
		}
		if (f instanceof Escada) {
			livre = true;
		}
		
		if (f instanceof Bilhete && livre)
		{
			return true;
		}
		return false;
	}
	
	
}
