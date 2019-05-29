package clases;

public class Comida {
	private String codCom;
	private String nombre;
	private String desc;
	private String alimentacion;
	private int stock;
	private String codProv;
	private String codAli;
	
	public Comida() {
		super();
	}
	public Comida(String codCom, String nombre, String desc, String alimentacion, int stock, String codProv) {
		super();
		this.codCom = codCom;
		this.nombre = nombre;
		this.desc = desc;
		this.alimentacion = alimentacion;
		this.stock = stock;
		this.codProv = codProv;
	}
	public String getCodCom() {
		return codCom;
	}
	public void setCodCom(String codCom) {
		this.codCom = codCom;
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
	public String getAlimentacion() {
		return alimentacion;
	}
	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCodProv() {
		return codProv;
	}
	public void setCodProv(String codProv) {
		this.codProv = codProv;
	}
	public String getCodAli() {
		return codAli;
	}
	public void setCodAli(String codAli) {
		this.codAli = codAli;
	}
	public void generarCod() {
		codCom=codProv.substring(0, 2)+"-"+nombre.substring(0, 2);
	}
}

