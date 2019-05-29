package clases;

import java.time.LocalDate;

public class Registro {
	private String CodReg;
	private String nomUser;
	private LocalDate fecha;
	private String desc;
	private String codEmp;
	public String getCodReg() {
		return CodReg;
	}
	public void setCodReg(String codReg) {
		CodReg = codReg;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCodEmp() {
		return codEmp;
	}
	public void setCodEmp(String codEmp) {
		this.codEmp = codEmp;
	}
	
	
}
