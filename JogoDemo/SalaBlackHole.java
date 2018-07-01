package JogoDemo;

import java.util.Map;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Sala;
import JogoDemo.Ferramentas.Oculos;
import JogoDemo.Ferramentas.Luminaria;
import JogoDemo.Ferramentas.Pilhas;
import JogoDemo.Objetos.GPS;
import JogoDemo.Objetos.GuiaMochileiro;

public class SalaBlackHole extends SalaJogoDemo {
    private boolean escuro;
    private StageScene stage;
    
	public SalaBlackHole() {
		super("Buraco Negro", "0");
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
		descricao.append("Você foi enviado para consertar o Mars Rover Curiosity em Marte, \n mas sua nave passou por uma chuva de meteoros \n e você foi cair num...").append(this.getNome()).append("\n");
		descricao.append("Ferramentas Disponíveis: \n").append(this.ferramentasDisponiveis().toString()).append("\n");
		descricao.append("Objetos: \n").append(this.objetosDisponiveis().toString()).append("\n");
				

		return descricao.toString();
	}

	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
			if (f == null) {
				return false;
				}
			if (f instanceof Oculos) {
				return true;
				}
			if (f instanceof Pilhas) {
				//GPS fica ativo
				((GPS)(this.getObjetos().get("GPS"))).setAcaoOk(true);	
				return true;
				}
		
			return false;
	}	
	
	public void trocaSala() {
			if (!escuro) {
				this.getPortas();
			}
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
