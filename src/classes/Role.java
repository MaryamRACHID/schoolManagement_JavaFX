package classes;

public class Role {
	private int idRole;
	private String nomRole;

	public Role(int idRole, String nomRole) {
		this.idRole = idRole;
		this.nomRole = nomRole;
	}

	public int getIdRole() {
		return idRole;
	}


	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}


	public String getNomRole() {
		return nomRole;
	}


	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}
}
