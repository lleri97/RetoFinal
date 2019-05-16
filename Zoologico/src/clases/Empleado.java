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
	
	public Empleado() {
		super();
	}
	public Empleado(String codEmp, String nombre, String apellido, String tlf, String dir, LocalDate fechanac,
			String codOfi, String codRec) {
		super();
		this.codEmp = codEmp;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tlf = tlf;
		this.dir = dir;
		this.fechanac = fechanac;
		this.codOfi = codOfi;
		this.codRec = codRec;
	}
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
	public void generarCod(){
		codEmp=nombre.substring(0, 2)+"-"+apellido.substring(0, 2);
	}
}
