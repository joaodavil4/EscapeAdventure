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
		Luminaria lanterna = new Luminaria ();
		Oculos oculos = new Oculos();
		Pilhas pilhas = new Pilhas();
		this.getFerramentas().put(oculos.getDescricao(), oculos);
		this.getFerramentas().put(pilhas.getDescricao(), pilhas);
		this.getFerramentas().put(lanterna.getDescricao(), lanterna);
			
	}

	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Você foi enviado para consertar o Mars Rover Curiosity em Marte, \n mas sua nave passou por uma chuva de meteoros \n e você foi cair num...").append(this.getNome()).append("\n");
			if (escuro) {
				descricao.append("Está escuro aqui...\n");
				descricao.append("Ferramentas: \n").append(this.ferramentasDisponiveis().toString()).append("\n");
				descricao.append("Objetos: \n").append(this.objetosDisponiveis().toString()).append("\n");
				
				}else {
			//como faz pra aparecer isso dpois que usa a luminaria?
			    descricao.append("A luminária iluminou o buraco e agora você pode usar \n suas outras ferramentas nos objetos.\n");
				}
		return descricao.toString();
	}

	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
			if (f == null) {
				return false;
				}
			if (f instanceof Luminaria) {
			    escuro = false; 
			    return true;
				}
			if (f instanceof Oculos) {
				return true;
				}
			if (f instanceof Pilhas) {
				return true;
				}
			if (!escuro) { //nao entendi?????
		//(()(this.getObjetos().get("Cofre"))).setAcaoOk(true);
				throw new FimDeJogoException();
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
