package JogoDemo;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Sala;
import JogoDemo.Ferramentas.Abridor;
import JogoDemo.Objetos.Galao;

public class SalaSaturno extends SalaJogoDemo {
	private boolean combustivel;
	
	public SalaSaturno() {
		super("Planeta Saturno!", "2");
		combustivel=false;
		//OBJETOS
		Galao combustivel = new Galao();
		this.getObjetos().put("Combust�vel PeTurno", combustivel);
		//FERRAMENTAS
		Abridor abridor = new Abridor();
		this.getFerramentas().put(abridor.getDescricao(), abridor);
	}

	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Voc� chegou em Saturno, mas seu combust�vel acabou");
		if (combustivel)
		{
			descricao.append("Sua nave foi abastecida, voc� pode seguir com a sua miss�o");
			
		}
		else {
			descricao.append("(Tra Tra) O led de combust�vel est� piscando");
		}
		return null;
	}

	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
		if (f == null) {
			return false;
		}
		if (f instanceof Abridor) {
			combustivel = true;
			return true;
		}
		return false;
	}
	
	@Override
	public Sala sai (String sala) {
		Sala aux = super.sai(sala);
		if (aux != null) {
			combustivel = true;
		}
		return aux;
	}
	
}
