package classes;

public class Module {
	private String idModule;
	private String idNiveau;
	private String titre;
	private String code;
	
	
	public Module(String idModule, String idNiveau, String titre, String code) {
		this.idModule = idModule;
		this.idNiveau = idNiveau;
		this.titre = titre;
		this.code = code;
	}


	public String getIdModule() {
		return idModule;
	}


	public void setIdModule(String idModule) {
		this.idModule = idModule;
	}


	public String getIdNiveau() {
		return idNiveau;
	}


	public void setIdNiveau(String idNiveau) {
		this.idNiveau = idNiveau;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
}
