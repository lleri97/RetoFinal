package control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import clases.Animal;
import clases.Comida;
import clases.Empleado;
import clases.Especie;
import clases.Oficio;
import clases.Proveedor;
import clases.Recinto;
import clases.Usuario;

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
	public void AñadirEspecie(Especie espe) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbmanager = new DBManager();
		dbmanager.AñadirEspecie(espe);
	}
	public void AñadirRecinto(Recinto recin) throws ClassNotFoundException, SQLException, IOException {
		DBManager dbmanager = new DBManager();
		dbmanager.AñadirRecinto(recin);
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
	public int getTamaño(String codEsp) throws IOException, ClassNotFoundException, SQLException {
		int n=0;
		DBManager dbmanager=new DBManager();
		n=dbmanager.getTamaño(codEsp);
		return n;
	}
	public int getTamañoRecin(String codAni) throws IOException, ClassNotFoundException, SQLException {
		int n=0;
		DBManager dbmanager=new DBManager();
		n=dbmanager.getTamañoAni(codAni);
		return n;
	}
	public ArrayList<Animal> getDatosListaAni (String codEsp) throws ClassNotFoundException, SQLException, IOException{
		DBManager dbmanager = new DBManager();
		ArrayList <Animal> anis = dbmanager.getDatosListaAni(codEsp);
		return anis; 
	}
	public ArrayList <Especie> getDatosListaEsp(String nombreEsp) throws ClassNotFoundException, SQLException, IOException{
		DBManager dbmanager = new DBManager();
		ArrayList <Especie> especs = dbmanager.getDatosListaEsp(nombreEsp);
		return especs;
	}
	public String getDatosListaRec(String codRec) throws ClassNotFoundException, SQLException, IOException {
		DBManager dbmanager = new DBManager();
		String recins = dbmanager.getDatosListaRec(codRec);
		return recins;
	}
	public ArrayList <String> getCodsRec() throws  SQLException, ClassNotFoundException, IOException{
		DBManager dbmanager = new DBManager();
		ArrayList <String> CodsRec= dbmanager.getCodsRec();
		return CodsRec;
	}
	public void EliminarAni(String codAni) throws ClassNotFoundException, SQLException, IOException {
		DBManager dbmanager= new DBManager();
		dbmanager.EliminarAnimal(codAni);
	}
	public void EliminarEsp(String codEsp) throws ClassNotFoundException, SQLException, IOException {
		DBManager dbmanager= new DBManager();
		dbmanager.EliminarEspecie(codEsp);
	}public void EliminarRec(String codRec) throws ClassNotFoundException, SQLException, IOException {
		DBManager dbmanager= new DBManager();
		dbmanager.EliminarRecinto(codRec);
	}
//---------------Empleado-----------------------------------------------------------------------------------------------------------------------------------
	public void AñadirEmpleado(Empleado emp) throws IOException, ClassNotFoundException, SQLException {//Añadir empleado
		DBManager dbmanager = new DBManager();
		dbmanager.AñadirEmpleado(emp);
	}
//--------------Oficio------------------------------------------------------------------------------------------------------------------------
	public Oficio getDatosOficio(String auxOfi) throws Exception {
		DBManager dbmanager = new DBManager();
		Oficio ofi =dbmanager.getDatosOficio(auxOfi);
		return ofi;
		
	}

	public ArrayList<String> getNombreOficios() throws IOException, ClassNotFoundException, SQLException {		//Cargar nombre oficios
		DBManager dbManager = new DBManager();
		ArrayList <String> ofi = dbManager.getNombreOficio();
		Collections.sort(ofi);
		return ofi;
	}

	public void AñadirOficio(Oficio ofi) throws IOException, ClassNotFoundException, SQLException {		//Oficios
		DBManager dbmanager = new DBManager();
		dbmanager.AñadirOficio(ofi);
		
	}
	public void guardarCambioOficio(Oficio ofi) throws IOException, ClassNotFoundException, SQLException {
		DBManager dbmanager = new DBManager();
		dbmanager.guardarCambioOficio(ofi);
		
	}
//-----------------Fin Oficio------------------------------------------------------------------------------------------------------------------------------
//----------------PROVEEDOR----------------------------------
	//getDatosProv
		public Proveedor getDatosProv(String auxProv) throws Exception {
			DBManager dbmanager = new DBManager();
			Proveedor prov =dbmanager.getDatosProv(auxProv);
			return prov;
		}
	//GetCodProv
		public ArrayList <String> getCodProv() throws IOException, ClassNotFoundException, SQLException{
			DBManager dbmanager= new DBManager();
			ArrayList<String> CodsProv = dbmanager.getCodProv();
			return CodsProv;
			
		}
	//AñadirProv
		public void AñadirProveedor(Proveedor pro) throws IOException, ClassNotFoundException, SQLException {		//Proveedores
			DBManager dbmanager = new DBManager();
			dbmanager.AñadirProveedor(pro);
			
		}
	//Mostrar prov
		public ArrayList<String> getNombreProv() throws IOException, ClassNotFoundException, SQLException {		//Cargar nombre oficios
			DBManager dbManager = new DBManager();
			ArrayList <String> pro = dbManager.getNombreProv();
			Collections.sort(pro);
			return pro;
		}
//----------------COMIDA----------------------------------
//getDatosCom
	public Comida getDatosCom(String auxCom) throws Exception {
		DBManager dbmanager = new DBManager();
		Comida com =dbmanager.getDatosCom(auxCom);
		return com;
	}
//GetCodCom
	public static ArrayList <String> getCodCom() {
		DBManager dbmanager= new DBManager();
		ArrayList<String> com = dbmanager.getCodCom();
		return com;
		
	}
//AñadirCom
	public void AñadirComida(Comida com) throws IOException, ClassNotFoundException, SQLException {		//Proveedores
		DBManager dbmanager = new DBManager();
		dbmanager.AñadirComida(com);
		
	}
//Borrar Com
	public void borrarCom(String auxCom) throws ClassNotFoundException, SQLException {
		DBManager dbmanager = new DBManager();
		dbmanager.borrarCom(auxCom);
		
	}
//Mostrar com
	public ArrayList<String> getNombreCom() throws IOException, ClassNotFoundException, SQLException {		//Cargar nombre oficios
		DBManager dbManager = new DBManager();
		ArrayList <String> com = dbManager.getNombreCom();
		Collections.sort(com);
		return com;
	}
//Mostrar pro
	public static ArrayList<String> getCodPro() {		//Cargar nombre oficios
		DBManager dbManager = new DBManager();
		ArrayList <String> pro = dbManager.getCodPro();
		Collections.sort(pro);
		return pro;
	}
//Mostrar ali
	public static ArrayList<String> getCodAli() {		//Cargar nombre oficios
		DBManager dbManager = new DBManager();
		ArrayList <String> ali = dbManager.getCodAli();
		Collections.sort(ali);
		return ali;
	}
//Borrar Prov
	public void borrarProv(String auxProv) throws ClassNotFoundException, SQLException {
		DBManager dbmanager = new DBManager();
		dbmanager.BorrarProveedor(auxProv);
		
	}
//Modificar Prov
	public void ModificarProv(Proveedor prov) throws ClassNotFoundException, SQLException {
		DBManager dbmanager = new DBManager();
		ArrayList<String> pro = dbmanager.getCodPro();
		Collections.sort(pro);
		dbmanager.ModificarProveedor(prov);
		
	}
//Existen Provs
	public int hayProvs(int cont, String auxProv) throws ClassNotFoundException, SQLException {
		DBManager dbmanager = new DBManager();
		cont = dbmanager.hayProvs(cont, auxProv);
		return cont;
	}
//----------------USUARIOS----------------------------------
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
