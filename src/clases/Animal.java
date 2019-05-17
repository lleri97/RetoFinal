package clases;

public class Animal {
	private String codAni;
	private String estado;
	private String desc;
	private int edad;
	private String codEsp;
	private String codRec;
	private String codCom;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCodAni() {
		return codAni;
	}
	public void setCodAni(String codAni) {
		this.codAni = codAni;
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
}
