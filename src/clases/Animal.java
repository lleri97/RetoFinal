package clases;

public class Animal {
	private String codAni;
	private String desc;
	private String estado;
	private int edad;
	private String codEsp;
	private String codRec;
	private String codCom;
	
	public Animal() {
		super();
	}
	public Animal(String codAni, String desc, String estado, int edad, String codEsp, String codRec, String codCom) {
		super();
		this.codAni = codAni;
		this.desc = desc;
		this.estado = estado;
		this.edad = edad;
		this.codEsp = codEsp;
		this.codRec = codRec;
		this.codCom = codCom;
	}
	public String getCodAni() {
		return codAni;
	}
	public void setCodAni(String codAni) {
		this.codAni = codAni;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String nombre) {
		this.desc = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCodEsp() {
		return codEsp;
	}
	public void setCodEsp(String codEsp) {
		this.codEsp = codEsp;
	}
	public String getCodRec() {
		return codRec;
	}
	public void setCodRec(String codRec) {
		this.codRec = codRec;
	}
	public String getCodCom() {
		return codCom;
	}
	public void setCodCom(String codCom) {
		this.codCom = codCom;
	}
	
	public void generarCod(int num){
		codAni=codEsp.substring(0, 2)+"-"+num;
	}
}
