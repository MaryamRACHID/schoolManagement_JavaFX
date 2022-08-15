package classes;

import java.time.LocalDate;

public class Etudiant extends Utilisateur {
	
	private String cne;
	private LocalDate dateNaissance;
	
	
	public Etudiant(int idUtilisateur, String CIN, String nom, String prenom, String nomArabe, String prenomArabe,
			String sexe, String email, int telephone, String cne, LocalDate dateNaissance) {
		
		super(idUtilisateur, nom, prenom, sexe, email, telephone);
		this.cne = cne;
		this.dateNaissance = dateNaissance;
	}


	public String getCne() {
		return cne;
	}


	public void setCne(String cne) {
		this.cne = cne;
	}


	public LocalDate getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	


}
