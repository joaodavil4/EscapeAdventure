package JogoDemo;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Sala;
import JogoDemo.Ferramentas.Oculos;
import JogoDemo.Ferramentas.Lanterna;
import JogoDemo.Ferramentas.Pilhas;
import JogoDemo.Objetos.GPS;
import JogoDemo.Objetos.GuiaMochileiro;

public class SalaBlackHole extends SalaJogoDemo {
    private boolean escuro;
    
	public SalaBlackHole() {
		super("Sala Black-Hole");
	    escuro = true;
	    //OBJETOS
		GPS gps = new GPS();
		GuiaMochileiro livro = new GuiaMochileiro();
		this.getObjetos().put("GPS", gps);
		this.getObjetos().put("GuiaMochileiro", livro);
		//FERRAMENTAS
		Oculos oculos = new Oculos();
		Pilhas pilhas = new Pilhas();
		this.getFerramentas().put(oculos.getDescricao(), oculos);
		this.getFerramentas().put(pilhas.getDescricao(), pilhas);
	}

	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Voce esta na ").append(this.getNome()).append("\n");
		if (escuro) {
			descricao.append("Está escuro aqui ...");
		}else {
		    descricao.append("A luz incendeia no buraco e você consegue enxergar\n");
		    descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
		    descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
		}
		descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
		return descricao.toString();
	}

	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
		if (f == null) {
			return false;
		}
		if (f instanceof Lanterna) {
		    escuro = false;
		    return true;
		}
//		if (f instanceof escuro == false) {
//			(()(this.getObjetos().get("Cofre"))).setAcaoOk(true);
//			throw new FimDeJogoException();
//		}
		return false;
	}	
	
	@Override
	public Sala sai(String sala) {
		Sala aux = super.sai(sala);
		if (aux != null) {
			escuro = true;
		}
		return aux;
	}	
}
