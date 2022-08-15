package classes;

public class Compte {
	private int idCompte;
	private int idRole;
	private int idUtilisateur;
	private String login;	
	private String password;
	
	public Compte(int idCompte, int idRole, int idUtilisateur, String login, String password) {
		this.idCompte = idCompte;
		this.idRole = idRole;
		this.idUtilisateur = idUtilisateur;
		this.login = login;
		this.password = password;
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
