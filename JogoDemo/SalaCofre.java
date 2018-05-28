package JogoDemo;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Sala;
import JogoDemo.Ferramentas.Chave;
import JogoDemo.Ferramentas.Lanterna;
import JogoDemo.Ferramentas.Picareta;
import JogoDemo.Objetos.Cofre;

public class SalaCofre extends SalaJogoDemo {
    private boolean escuro;
    
	public SalaCofre() {
		super("SalaCofre");
	    escuro = true;
		Cofre cofre = new Cofre();
		Picareta picareta = new Picareta();
		this.getObjetos().put("Cofre", cofre);
		this.getFerramentas().put(picareta.getDescricao(), picareta);
	}

	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Voce esta na ").append(this.getNome()).append("\n");
		if (escuro) {
			descricao.append("Esta escuro aqui ...");
		}else {
		    descricao.append("Parece uma sala comum.\n");
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
		if (f instanceof Chave && escuro == false) {
			((Cofre)(this.getObjetos().get("Cofre"))).setAcaoOk(true);
			throw new FimDeJogoException();
		}
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
