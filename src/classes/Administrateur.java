package classes;

public class Administrateur extends Utilisateur {
	private String grade;
	
	
	public Administrateur(String grade, int idUtilisateur, String CIN, String nom, String prenom, String nomArabe, String prenomArabe,
			String sexe, String email, int telephone) {
		super(idUtilisateur, nom, prenom, sexe, email, telephone);
		this.grade = grade;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


}


