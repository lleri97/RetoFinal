package clases;

public class Recinto {
	private String codRec;
	private String desc;
	
	public Recinto() {
		super();
	}
	public Recinto(String codRec, String desc) {
		super();
		this.codRec = codRec;
		this.desc = desc;
	}
	public String getCodRec() {
		return codRec;
	}
	public void setCodRec(String codRec) {
		this.codRec = codRec;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void generarCod(int num){
		codRec="rec"+num;	
		}
}
