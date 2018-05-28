package JogoDemo;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Sala;
import JogoDemo.Ferramentas.Chave;
import JogoDemo.Ferramentas.Lanterna;
import JogoDemo.Ferramentas.Picareta;
import JogoDemo.Objetos.Cofre;
import JogoDemo.Objetos.PilhaPedras;

public class SalaPedras extends Sala {
	public SalaPedras() {
		super("SalaPedras");
		PilhaPedras pilhaPedras = new PilhaPedras();
		this.getObjetos().put("PilhaPedras", pilhaPedras);
	}

	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Voce esta na ").append(this.getNome()).append("\n");
	    descricao.append("Parece uma caverna ...\n");
		descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
		descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
		descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
		return descricao.toString();
	}

	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
		if (f == null || !(f instanceof Picareta)) {
			return false;
		}
		PilhaPedras pp = (PilhaPedras)this.getObjetos().get("PilhaPedras");
		pp.usar(f);
		Chave chave = new Chave();
		this.getFerramentas().put(chave.getDescricao(), chave);
		return true;
	}	
	
	@Override
	public boolean pega(String nomeFerramenta) {
		boolean ok = super.pega(nomeFerramenta);
		if (ok) {
		    this.getFerramentas().remove(nomeFerramenta);
		    return true;
		}
		return false;
	}
}
