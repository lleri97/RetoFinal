package control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import clases.Animal;
import clases.Especie;
import clases.Recinto;
import clases.Usuario;

public class Manager {
	
	public boolean getLogin(String id, String pass) throws Exception {

		DBManager dbManager = new DBManager();
		boolean isLogin = dbManager.getLogin(id, pass);
		return isLogin;
	}
	
	//Metodos Animales
	public void AñadirAnimal(Animal ani) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbmanager = new DBManager();
		dbmanager.AñadirAnimal(ani);
	}
	
	public Animal getAnimal(String animal) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbManager = new DBManager();
		Animal ThisAnimal =dbManager.getAnimal(animal);
		return ThisAnimal;
		
	}
	//Metodos Especie
	public Especie getEspecie(String especie) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbManager = new DBManager();
		Especie ThisEspecie =dbManager.getEspecie(especie);
		return ThisEspecie;
		
	}
	//Metodos Recinto
	public Recinto getRecinto(String recinto) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbManager = new DBManager();
		Recinto ThisRecinto =dbManager.getRecinto(recinto);
		return ThisRecinto;
		
	}
	
	
	//Metodos usuario
	
	public Usuario BuscarUsuario(String nombre) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbmanager=new DBManager();
		Usuario ThisUsu=dbmanager.buscarUsuario(nombre);
	return ThisUsu;
	}
	
	public void AnadirUsuario(Usuario usu) throws ClassNotFoundException, SQLException, IOException {
		DBManager dbmanager=new DBManager();
		dbmanager.anadirUsuario(usu);
	}
	public void ModificarUsuario(Usuario usu) throws ClassNotFoundException, SQLException, IOException {
		DBManager dbmanager=new DBManager();
		dbmanager.modificarUsuario(usu);
	}
	public void EliminarUsuario(Usuario usu) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbmanager= new DBManager();
		dbmanager.eliminarUsuario(usu);
		
	}
}
