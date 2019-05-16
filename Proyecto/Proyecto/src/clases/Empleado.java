package clases;

import java.time.LocalDate;

public class Empleado {
	private String codEmp;
	private String nombre;
	private String apellido;
	private String tlf;
	private String dir;
	private LocalDate fechanac;
	private String codOfi;
	private String codRec;
	
	public String getCodEmp() {
		return codEmp;
	}
	public void setCodEmp(String codEmp) {
		this.codEmp = codEmp;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTlf() {
		return tlf;
	}
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public LocalDate getFechanac() {
		return fechanac;
	}
	public void setFechanac(LocalDate fechanac) {
		this.fechanac = fechanac;
	}
	public String getCodOfi() {
		return codOfi;
	}
	public void setCodOfi(String codOfi) {
		this.codOfi = codOfi;
	}
	public String getCodRec() {
		return codRec;
	}
	public void setCodRec(String codRec) {
		this.codRec = codRec;
	}
}
