package classes;

import java.time.LocalDate;

public class Inscription {
	private int idInscription; 
	private int idNiveau; private int idUtilisateur;
	private LocalDate annee;
	
	
	public Inscription(int idInscription, int idNiveau, int idUtilisateur, LocalDate annee) {
		super();
		this.idInscription = idInscription;
		this.idNiveau = idNiveau;
		this.idUtilisateur = idUtilisateur;
		this.annee = annee;
	}


	public int getIdInscription() {
		return idInscription;
	}


	public void setIdInscription(int idInscription) {
		this.idInscription = idInscription;
	}


	public int getIdNiveau() {
		return idNiveau;
	}


	public void setIdNiveau(int idNiveau) {
		this.idNiveau = idNiveau;
	}


	public int getIdUtilisateur() {
		return idUtilisateur;
	}


	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}


	public LocalDate getAnnee() {
		return annee;
	}


	public void setAnnee(LocalDate annee) {
		this.annee = annee;
	}
	
	


}
