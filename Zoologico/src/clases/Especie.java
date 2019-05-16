package clases;

public class Especie {
	private String codEsp;
	private String nomEsp;
	private String alimentacion;
	
	public Especie() {
		super();
	}
	public Especie(String codEsp, String nomEsp, String alimentacion) {
		super();
		this.codEsp = codEsp;
		this.nomEsp = nomEsp;
		this.alimentacion = alimentacion;
	}
	public String getCodEsp() {
		return codEsp;
	}
	public void setCodEsp(String codEsp) {
		this.codEsp = codEsp;
	}
	public String getNomEsp() {
		return nomEsp;
	}
	public void setNomEsp(String nomEsp) {
		this.nomEsp = nomEsp;
	}
	public String getAlimentacion() {
		return alimentacion;
	}
	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}
	public void generarCod(){
		codEsp=nomEsp.substring(0, 2);	
		}
}
