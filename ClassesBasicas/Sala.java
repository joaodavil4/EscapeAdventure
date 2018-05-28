package ClassesBasicas;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Sala {
	private String nome;
	private Mochila mochila;
	private Map<String,Objeto> objetos;
	private Map<String,Ferramenta> ferramentas;
	private Map<String,Sala> portas;
	private String repVisual;
	
	public Sala(String nome) {
		this.nome = nome;
		objetos = new HashMap<>();
		ferramentas = new HashMap();
		portas = new HashMap();
	}
	
	public Sala(String nome,String repVisual) {
		this(nome);
		this.repVisual = repVisual;
	}

	public String getNome() {
		return nome;
	}
	
	public String getRepVisual() {
		return repVisual;
	}

	public Mochila getMochila() {
		return mochila;
	}
	
	public Map<String, Objeto> getObjetos() {
		return objetos;
	}

	public Map<String, Ferramenta> getFerramentas() {
		return ferramentas;
	}
	
	public Map<String,Sala> getPortas(){
		return portas;
	}
	
	public List<String> objetosDisponiveis(){
    	return objetos.values()
    			      .stream()
    			      .map(obj->obj.getDescricao())
    			      .collect(Collectors.toList());
	}

	public List<String> ferramentasDisponiveis(){
    	return ferramentas.keySet().stream().collect(Collectors.toList());		
	}
	
	public List<String> portasDisponiveis(){
    	return portas.keySet().stream().collect(Collectors.toList());				
	}

	public void entra(Mochila mochila) {
		this.mochila = mochila;
	}
	
	public boolean pega(String nomeFerramenta) {
		Ferramenta f = this.getFerramentas().get(nomeFerramenta);
		if (f != null) {
			mochila.guardar(f);
			return true;
		}else {
			return false;
		}
	}

	public Sala sai(String porta) {
		return portas.get(porta);
	}

	public abstract String textoDescricao();						

	public abstract boolean usa(String ferramenta);
}
