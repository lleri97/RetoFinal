package control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import clases.Animal;
import clases.Empleado;
import clases.Especie;
import clases.Oficio;
import clases.Recinto;

public class Manager {
	
	public boolean getLogin(String id, String pass) throws Exception {

		DBManager dbManager = new DBManager();
		boolean isLogin = dbManager.getLogin(id, pass);
		return isLogin;
	}
	
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
	public void AñadirAnimal(Animal ani) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbmanager = new DBManager();
		dbmanager.AñadirAnimal(ani);
	}
	public void AñadirOficio(Oficio ofi) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbmanager = new DBManager();
		dbmanager.AñadirOficio(ofi);
		
	}

	public void AñadirEmpleado(Empleado emp) throws ClassNotFoundException, SQLException, IOException {
		DBManager dbmanager = new DBManager();
		dbmanager.AñadirEmpleado(emp);
	}

	public ArrayList<String> getNombreOficios() throws IOException, ClassNotFoundException, SQLException {
		DBManager dbManager = new DBManager();
		ArrayList <String> ofi = dbManager.getNombreOficio();
		Collections.sort(ofi);
		return ofi;
	}
}
