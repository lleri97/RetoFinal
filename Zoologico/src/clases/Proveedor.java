package clases;

public class Proveedor {
	private String codProv;
	private String nombre;
	private String tlf;
	private String dir;
	private String desc;
	
	public Proveedor() {
		super();
	}
	public Proveedor(String codProv, String nombre, String tlf, String dir, String desc) {
		super();
		this.codProv = codProv;
		this.nombre = nombre;
		this.tlf = tlf;
		this.dir = dir;
		this.desc = desc;
	}
	public String getCodProv() {
		return codProv;
	}
	public void setCodProv(String codProv) {
		this.codProv = codProv;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void generarCod() {
		codProv=nombre.substring(0,2);
	}
}
