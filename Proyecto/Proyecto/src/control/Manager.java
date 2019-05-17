package control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import clases.Animal;
import clases.Especie;
import clases.Recinto;

public class Manager {

	public Animal getAnimal(String animal) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbManager = new DBManager();
		Animal ThisAnimal =dbManager.getAnimal(animal);
		return ThisAnimal;
		
	}
	public Especie getEspecie(String especie) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbManager = new DBManager();
		Especie ThisEspecie =dbManager.getEspecie(especie);
		return ThisEspecie;
		
	}
	public Recinto getRecinto(String recinto) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbManager = new DBManager();
		Recinto ThisRecinto =dbManager.getRecinto(recinto);
		return ThisRecinto;
		
	}
	public void AņadirAnimal(Animal ani) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbmanager = new DBManager();
		dbmanager.AņadirAnimal(ani);
	}
	public void AņadirEspecie(Especie espe) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbmanager = new DBManager();
		dbmanager.AņadirEspecie(espe);
	}
	public void AņadirRecinto(Recinto recin) throws ClassNotFoundException, SQLException, IOException {
		DBManager dbmanager = new DBManager();
		dbmanager.AņadirRecinto(recin);
	}
	public ArrayList <String> getCodEsp() throws IOException, ClassNotFoundException, SQLException{
		DBManager dbmanager= new DBManager();
		ArrayList<String> codsEsp =dbmanager.getCodEsp();
		return null;
	}
	public ArrayList <String> getCodRecinto() throws IOException, ClassNotFoundException, SQLException{
		DBManager dbmanager= new DBManager();
		ArrayList<String> CodsRecin =dbmanager.getCodRecinto();
		return CodsRecin;
		
	}
	public ArrayList <String> getCodComida() throws IOException, ClassNotFoundException, SQLException{
		DBManager dbmanager= new DBManager();
		ArrayList<String> CodsComi = dbmanager.getCodComida();
		return CodsComi;
		
	}
	public int getTamaņo(String codEsp) throws IOException, ClassNotFoundException, SQLException {
		int n=0;
		DBManager dbmanager=new DBManager();
		n=dbmanager.getTamaņo(codEsp);
		return n;
	}
	public int getTamaņoRecin(String codAni) throws IOException, ClassNotFoundException, SQLException {
		int n=0;
		DBManager dbmanager=new DBManager();
		n=dbmanager.getTamaņoAni(codAni);
		return n;
	}
	public ArrayList<Animal> getDatosListaAni (String codEsp) throws ClassNotFoundException, SQLException{
		DBManager dbmanager = new DBManager();
		ArrayList <Animal> anis = dbmanager.getDatosListaAni(codEsp);
		return anis; 
	}
	public ArrayList <Especie> getDatosListaEsp(String nombreEsp) throws ClassNotFoundException, SQLException{
		DBManager dbmanager = new DBManager();
		ArrayList <Especie> especs = dbmanager.getDatosListaEsp(nombreEsp);
		return especs;
	}
	public String getDatosListaRec(String codRec) throws ClassNotFoundException, SQLException {
		DBManager dbmanager = new DBManager();
		String recins = dbmanager.getDatosListaRec(codRec);
		return recins;
	}
	public ArrayList <String> getCodsRec() throws  SQLException, ClassNotFoundException{
		DBManager dbmanager = new DBManager();
		ArrayList <String> CodsRec= dbmanager.getCodsRec();
		return CodsRec;
	}
}
