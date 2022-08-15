package classes;

public class Niveau {
	private String idNiveau;
	private String idFiliere;
	private String alias;
	private String titre;
	
	public Niveau(String idNiveau, String idFiliere, String alias, String titre) {
		this.idNiveau = idNiveau;
		this.idFiliere = idFiliere;
		this.alias = alias;
		this.titre = titre;
	}

	public String getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(String idNiveau) {
		this.idNiveau = idNiveau;
	}

	public String getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(String idFiliere) {
		this.idFiliere = idFiliere;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	

}
