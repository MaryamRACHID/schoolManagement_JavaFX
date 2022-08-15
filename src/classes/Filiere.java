package classes;


public class Filiere {
	private String idFiliere;
	private String titreFiliere;
	private String codeFiliere;
	private String anneeaccreditation;
	private String anneeFinaccreditation;
	
	
	public Filiere(String idFiliere, String titreFiliere, String codeFiliere, String anneeaccreditation,
			String anneeFinaccreditation) {
		super();
		this.idFiliere = idFiliere;
		this.titreFiliere = titreFiliere;
		this.codeFiliere = codeFiliere;
		this.anneeaccreditation = anneeaccreditation;
		this.anneeFinaccreditation = anneeFinaccreditation;
	}


	public Filiere() {
		// TODO Auto-generated constructor stub
	}


	public String getIdFiliere() {
		return idFiliere;
	}


	public void setIdFiliere(String idFiliere) {
		this.idFiliere = idFiliere;
	}


	public String getTitreFiliere() {
		return titreFiliere;
	}


	public void setTitreFiliere(String titreFiliere) {
		this.titreFiliere = titreFiliere;
	}


	public String getCodeFiliere() {
		return codeFiliere;
	}


	public void setCodeFiliere(String codeFiliere) {
		this.codeFiliere = codeFiliere;
	}


	public String getAnneeaccreditation() {
		return anneeaccreditation;
	}


	public void setAnneeaccreditation(String anneeaccreditation) {
		this.anneeaccreditation = anneeaccreditation;
	}


	public String getAnneeFinaccreditation() {
		return anneeFinaccreditation;
	}


	public void setAnneeFinaccreditation(String anneeFinaccreditation) {
		this.anneeFinaccreditation = anneeFinaccreditation;
	}
	
	
	
}
