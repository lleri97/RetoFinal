package clases;

public class Oficio {
	private String codOfi;
	private String nombre;
	private String desc;
	private float Sueldo;
	
	public Oficio() {
		super();
	}
	public Oficio(String codOfi, String nombre, String desc, float sueldo) {
		super();
		this.codOfi = codOfi;
		this.nombre = nombre;
		this.desc = desc;
		Sueldo = sueldo;
	}
	public String getCodOfi() {
		return codOfi;
	}
	public void setCodOfi(String codOfi) {
		this.codOfi = codOfi;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public float getSueldo() {
		return Sueldo;
	}
	public void setSueldo(float sueldo) {
		Sueldo = sueldo;
	}
	public void generarCod(int num){
		codOfi=nombre.substring(0, 2)+"-"+num;
	}
}
