package JogoDemo;

import JogoDemo.Ferramentas.Dinamite;
import JogoDemo.Ferramentas.Lanterna;

public class HallEntrada extends SalaJogoDemo {

	public HallEntrada() {
		super("HallEntrada");
		Lanterna lanterna = new Lanterna();
		Dinamite dinamite = new Dinamite();
		this.getFerramentas().put(lanterna.getDescricao(),lanterna);
		this.getFerramentas().put(dinamite.getDescricao(),dinamite);
	}

	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Voce esta no ").append(this.getNome()).append("\n");
		descricao.append("Parece uma sala comum.\n");
		descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
		descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
		descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
		return descricao.toString();
	}

	@Override
	public boolean usa(String ferramenta) {
		return false;
	}
}
