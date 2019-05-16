package clases;

public class Usuario {
	private String nomUser;
	private String passUser;
	private String codEmp;
	
	public Usuario() {
		super();
	}
	public Usuario(String nomUser, String passUser, String codEmp) {
		super();
		this.nomUser = nomUser;
		this.passUser = passUser;
		this.codEmp = codEmp;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getPassUser() {
		return passUser;
	}
	public void setPassUser(String passUser) {
		this.passUser = passUser;
	}
	public String getCodEmp() {
		return codEmp;
	}
	public void setCodEmp(String codEmp) {
		this.codEmp = codEmp;
	}

}
