package ClassesBasicas;

public abstract class Objeto {
    private String descricaoAntesAcao;
    private String descricaoDepoisAcao;
    private boolean acaoOk;
    
    	
	public Objeto(String descricaoAntesAcao, String descricaoDepoisAcao) {
		this.descricaoAntesAcao = descricaoAntesAcao;
		this.descricaoDepoisAcao = descricaoDepoisAcao;
		acaoOk = false;
	}
	
	public boolean isAcaoOk() {
		return acaoOk;
	}

	public void setAcaoOk(boolean acaoOk) {
		this.acaoOk = acaoOk;
	}

	public String getDescricao() {
		if (!this.isAcaoOk()) {
			return this.descricaoAntesAcao;
		}else {
			return this.descricaoDepoisAcao;
		}
	}

	public abstract boolean usar(Ferramenta f);
}
