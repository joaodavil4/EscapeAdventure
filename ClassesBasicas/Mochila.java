package ClassesBasicas;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mochila {
    private Map<String,Ferramenta> coisas;
    
    public Mochila() {
    	coisas = new HashMap<>();
    }
    
    public void guardar(Ferramenta f) {
    	coisas.put(f.getDescricao(), f);
    }
    
    public Ferramenta usar(String descricao) {
    	return coisas.get(descricao);
    }
    
    public List<String> inventario(){
    	return coisas.keySet().stream().collect(Collectors.toList());
    }
}
