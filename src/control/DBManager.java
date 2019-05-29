package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Properties;

import clases.Animal;
import clases.Comida;
import clases.Empleado;
import clases.Especie;
import clases.Oficio;
import clases.Proveedor;
import clases.Recinto;
import clases.Usuario;

public class DBManager {
	private Connection con;
	private PreparedStatement stmt;
	private String dbHost;
	private String dbName;
	private String dbUser;
	private String dbPassword;
	
	/*public DBManager() throws IOException {
		if (dbHost == null) {
			Properties config = new Properties();
			FileInputStream input = null;
			try {
				input = new FileInputStream("./resources/db.properties");
				config.load(input);
				dbHost = config.getProperty("ip");
				dbName = config.getProperty("dbname");
				dbUser = config.getProperty("username");
				dbPassword = config.getProperty("password");
			} finally {
				if (input != null)
					input.close();
			}
		}
	}*/
	
	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://192.168.20.89/reto";
		con = DriverManager.getConnection(url,"cualquiera","1");
		con.createStatement();
	}

	private void disconnect() throws SQLException {
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
	}
	
	// Comprobar usuario y contraseña
	public boolean getLogin(String id, String contra) throws Exception {
		boolean isLogin = false;
		ResultSet rs = null;
		try {
			this.connect();
			String sql = "select id_operario,contrasena from operarios where id_operario = ? and contrasena = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, contra);
			rs = stmt.executeQuery();
			if (rs.next()) {
				isLogin = true;
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			this.disconnect();
		}
		return isLogin;
	}
	
	public Animal getAnimal(String Animal) throws SQLException, ClassNotFoundException {
		Animal ani = new Animal();
		ResultSet rs = null;
		try {
			this.connect();
			String sql= "select * from animales where cod_esp = (select cod_esp from especies where nom_esp = ?)";
			stmt= con.prepareStatement(sql);
			stmt.setString(1, Animal);
			rs=stmt.executeQuery();
			if(rs.next()) {
				ani.setCodAni(rs.getString("cod_esp"));
				ani.setCodCom(rs.getString("cod_com"));
				ani.setCodRec(rs.getString("cod_rec"));
				ani.setEdad(rs.getInt("edad"));
				ani.setEstado(rs.getString("estado"));
				ani.setDesc(rs.getString("desc"));
			}
		} finally {
			if(rs!=null) {
				rs.close();
			}
			this.disconnect();
		}
		return ani;
	}
	
	public Especie getEspecie(String Especie) throws ClassNotFoundException, SQLException {
		Especie esp= new Especie();
		ResultSet rs = null;
		try {
			this.connect();
			String sql="select * from especies where nom_esp=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, Especie);
			rs=stmt.executeQuery();
			if(rs.next()) {
				esp.setNomEsp(rs.getString("nom_esp"));
				esp.setAlimentacion(rs.getString("alimentacion"));
			}
		} finally {
			if(rs!=null) {
				rs.close();
			}
			this.disconnect();
		}	
			return esp;
		
	}
	public Recinto getRecinto(String Reciente) throws ClassNotFoundException, SQLException {
		Recinto rec=new Recinto();
		ResultSet rs = null;
		try {
			this.connect();
			String sql="select * from recintos where cod_rec= ?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, sql);
			rs=stmt.executeQuery();
			if(rs.next()) {
				rec.setDesc(rs.getString("desc"));
			}
		} finally {
			
		}
		this.disconnect();
		return rec;
	}
	public void AñadirAnimal(Animal ani) throws ClassNotFoundException, SQLException {
		this.connect();
		String sql="Insert into animales values (?,?,?,?,?,?,?)";
		stmt= con.prepareStatement(sql);
		stmt.setString(1, ani.getCodAni());
		stmt.setString(4, ani.getCodEsp());
		stmt.setString(7, ani.getDesc());
		stmt.setString(2, ani.getEstado());
		stmt.setInt(3, ani.getEdad());
		stmt.setString(5, ani.getCodRec());
		stmt.setString(6, ani.getCodCom());
		stmt.executeQuery(sql);
		this.disconnect();
		
	}
	public void AñadirEspecie(Especie espe) throws ClassNotFoundException, SQLException {
		this.connect();
		String sql="Insert into especies values(?,?,?)";
		stmt= con.prepareStatement(sql);
		stmt.setString(1, espe.getCodEsp());
		stmt.setString(2, espe.getNomEsp());
		stmt.setString(3, espe.getAlimentacion());
		stmt.executeQuery(sql);
		this.disconnect();
	}
	public void AñadirRecinto(Recinto recin) throws ClassNotFoundException, SQLException {
		this.connect();
		String sql="Insert into recintos values (?,?)";
		stmt= con.prepareStatement(sql);
		stmt.setString(1, recin.getCodRec());
		stmt.setString(2, recin.getDesc());
		stmt.executeQuery();
		this.disconnect();
	}
	public ArrayList <String> getCodEsp() throws ClassNotFoundException, SQLException {
		ArrayList<String> espArray = new ArrayList<String>();
		this.connect();
		
		String sql= "select nom_esp from especies";
		stmt= con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			espArray.add(rs.getString("nomEsp"));
		}
		rs.close();
		this.disconnect();
		return espArray;
	}
	public ArrayList <String> getCodRecinto() throws ClassNotFoundException, SQLException{
		ArrayList<String> codigosRec = new ArrayList<String>();
		this.connect();
		String sql= "Select codRec from recintos";
		stmt= con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			codigosRec.add(rs.getString("codRec"));
		}
		rs.close();
		this.disconnect();
		return codigosRec;
	}
	public ArrayList <String> getCodComida() throws ClassNotFoundException, SQLException{
		ArrayList<String> codigosComi = new ArrayList<String>();
		this.connect();
		String sql= "Select codCom from comida";
		stmt= con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			codigosComi.add(rs.getString("codCom"));
		}
		rs.close();
		this.disconnect();
		return codigosComi;
	}
	public ArrayList <String> getCodProv() throws ClassNotFoundException, SQLException{
		ArrayList<String> codigosProv = new ArrayList<String>();
		this.connect();
		String sql= "Select codCom from comida";
		stmt= con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			codigosProv.add(rs.getString("codCom"));
		}
		rs.close();
		this.disconnect();
		return codigosProv;
	}
	public int getTamaño(String codEsp) throws ClassNotFoundException, SQLException {
		int n=0;
		this.connect();
	
		String sql="Select count(codEsp) from animales where codEsp= ?";
		stmt= con.prepareStatement(sql);
		stmt.setString(1, codEsp);
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			n=rs.getInt(1);
		}
		rs.close();
		this.disconnect();
		return n;
	}
	public int getTamañoAni(String codRec) throws ClassNotFoundException, SQLException {
		int n=0;
		this.connect();
	
		String sql="Select count(codRec) from recintos where codRec= ?";
		stmt= con.prepareStatement(sql);
		stmt.setString(1, codRec);
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			n=rs.getInt(1);
		}
		rs.close();
		this.disconnect();
		return n;
	}
	public ArrayList<Animal> getDatosListaAni (String codEsp) throws SQLException, ClassNotFoundException{
		ArrayList <Animal> animals = new ArrayList<Animal>();
		Animal animal = new Animal();
		this.connect();
		
		String sql="String codAni,Descripcion from animales where codEsp= ?";
		stmt= con.prepareStatement(sql);
		stmt.setString(1, "codEsp");
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			animal.setCodAni(rs.getString("codAni"));
			animal.setDesc(rs.getString("Descripcion"));
			animals.add(animal);
		}
		this.disconnect();
		return animals;
		
	}
	public ArrayList <Especie> getDatosListaEsp(String nombreEsp) throws ClassNotFoundException, SQLException{
		ArrayList<Especie> Especies = new ArrayList<>();
		Especie especie= new Especie();
		this.connect();
		String sql="Select codEsp,alimentacion from especies where=?";
		stmt= con.prepareStatement(sql);
		stmt.setString(1, "nombreEsp");
		ResultSet rs= stmt.executeQuery(sql);
		while(rs.next()) {
			especie.setCodEsp(rs.getString("codEsp"));;
			especie.setAlimentacion(rs.getString("alimentacion"));
			Especies.add(especie);
		}
		this.disconnect();
		return Especies;
		
	}
	public String getDatosListaRec(String codRec) throws ClassNotFoundException, SQLException{
		String descp = null;
		this.connect();
		String sql="select describ from recintos where codRec=?";
		stmt= con.prepareStatement(sql);
		stmt.setString(1, codRec);
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			descp=rs.getString(1);
		}
		this.disconnect();
		return descp;
	}
	public ArrayList <String> getCodsRec() throws ClassNotFoundException, SQLException{
		ArrayList<String> CodsRec = new ArrayList<>();
		this.connect();
		String sql="select codRec from recintos";
		stmt= con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			CodsRec.add(rs.getString(1));
		}
		this.disconnect();
		return CodsRec;
	}
	public void EliminarAnimal(String codAni) throws ClassNotFoundException, SQLException {
		this.connect();
		String sql="delete from animales where codAnimal= ?";
		stmt= con.prepareStatement(sql);
		stmt.setString(1, codAni);
		stmt.executeQuery(sql);
		
		this.disconnect();
	}
	public void EliminarEspecie(String codEsp) throws ClassNotFoundException, SQLException {
		this.connect();
		String sql="delete from animales where codAnimal= ?";
		stmt= con.prepareStatement(sql);
		stmt.setString(1, codEsp);
		stmt.executeQuery(sql);
		
		this.disconnect();
	}
	public void EliminarRecinto(String codRec) throws ClassNotFoundException, SQLException {
		this.connect();
		String sql="delete from animales where codAnimal= ?";
		stmt= con.prepareStatement(sql);
		stmt.setString(1, codRec);
		stmt.executeQuery(sql);
		
		this.disconnect();
	}
	public void updateAni(Animal Ani) throws SQLException, ClassNotFoundException {
		this.connect();
		String sql="update from animales codAni=? and estado=? and edad=? and codEsp=0 and codRec=? and codCom=?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, Ani.getCodAni());
		stmt.setString(2, Ani.getEstado());
		stmt.setInt(3, Ani.getEdad());
		stmt.setString(4, Ani.getCodEsp());
		stmt.setString(5, Ani.getCodRec());
		stmt.setString(7, Ani.getCodCom());
	}

	public void AñadirEmpleado(Empleado emp) throws SQLException, ClassNotFoundException {//Añadir empleado
		this.connect();
		String insert="Insert into empleados values(?,?,?,?,?,?,?,?)";
		stmt=con.prepareStatement(insert);
		stmt.setString(1, emp.getCodEmp());
		stmt.setString(2, emp.getNombre());
		stmt.setString(3, emp.getApellido());
		stmt.setString(4, emp.getTlf());
		stmt.setString(5, emp.getDir());
		Date aux=asDate(emp.getFechanac());
		
		stmt.setDate(6, aux);
		stmt.setString(7, emp.getCodOfi());
		stmt.setString(8, emp.getCodRec());
		
		this.disconnect();
		
	}

	public static Date asDate(LocalDate localDate) {
	    return (Date) Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	  }

	public Oficio getDatosOficio(String auxOfi) throws ClassNotFoundException, SQLException {
		Oficio ofi = new Oficio();
		this.connect();
		String select = "Select * from oficios where nombre = '"+ auxOfi+"'";
		stmt=con.prepareStatement(select);
		ResultSet rs = stmt.executeQuery(select);
		//stmt.setString(1, auxOfi);
		while(rs.next()) {
			ofi.setCodOfi(rs.getString(1));
			ofi.setNombre(rs.getString(2));
			ofi.setDesc(rs.getString(3));
			ofi.setSueldo(rs.getFloat(4));
		}
		rs.close();
		this.disconnect();
		return ofi;
	}

		public ArrayList <String> getNombreOficio() throws ClassNotFoundException, SQLException {		//Cargar Oficios
		
		ArrayList <String> ofi = new ArrayList <String>();
		this.connect();
		String select = "Select nombre from oficios";
		stmt=con.prepareStatement(select);
		ResultSet rs = stmt.executeQuery(select);
		while(rs.next()) {
			ofi.add(rs.getString(1));
		}
		rs.close();
		this.disconnect();
		return ofi;
	}

		public void AñadirOficio(Oficio ofi) throws SQLException, ClassNotFoundException {		//Añadir Oficio
		this.connect();
		String insert ="Insert into oficios values(?,?,?,?)";
		stmt=con.prepareStatement(insert);
		stmt.setString(1, ofi.getCodOfi());
		stmt.setString(2, ofi.getNombre());
		stmt.setString(3, ofi.getDesc());
		stmt.setFloat(4, ofi.getSueldo());
		stmt.executeUpdate();
		this.disconnect();
	}
		public void guardarCambioOficio(Oficio ofi) throws SQLException, ClassNotFoundException {	//Actualizar oficio
			this.connect();
			String update = "update oficios set codOfi = ? and nombre = ? and describ = ? and sueldo = ?";
			stmt=con.prepareStatement(update);
			stmt.setString(1, ofi.getCodOfi());
			stmt.setString(2, ofi.getNombre());
			stmt.setString(3, ofi.getDesc());
			stmt.setFloat(4, ofi.getSueldo());
			stmt.executeUpdate();
			this.disconnect();
		}
		public Usuario buscarUsuario(String nombre) throws ClassNotFoundException, SQLException {
			this.connect();
			Usuario usu=new Usuario();
			String sql="Select * from users where nomUser=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, nombre);
			ResultSet rs=stmt.executeQuery(sql);
			usu.setCodEmp(rs.getString("codEmp"));
			usu.setNomUser(nombre);
			usu.setPassUser(rs.getString("passUsr"));
			this.disconnect();
			return usu;
		}
		
		public void anadirUsuario(Usuario usu) throws ClassNotFoundException, SQLException {
			this.connect();
			String sql ="insert into  users values(?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, usu.getNomUser());
			stmt.setString(2, usu.getPassUser());
			stmt.setString(3, usu.getCodEmp());
			stmt.executeQuery(sql);
			this.disconnect();
		}
		public void modificarUsuario(Usuario usu) throws ClassNotFoundException, SQLException {
			this.connect();
			String sql="update users set nomUser=? , passUser=? , codEmp=?  ";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, usu.getNomUser());
			stmt.setString(2, usu.getPassUser());
			stmt.setString(3, usu.getCodEmp());
			stmt.executeQuery(sql);
			this.disconnect();
		}
		public void eliminarUsuario(Usuario usu) throws ClassNotFoundException, SQLException {
			this.connect();
			String sql ="delete from users where nomUser=? and passUser=? ";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, usu.getNomUser());
			stmt.setString(2, usu.getPassUser());
			stmt.executeQuery(sql);
			this.disconnect();
		}
	
		public Proveedor getUsuario(String Prov) throws Exception{
			Proveedor Pro = new Proveedor();
			this.connect();
			String select="select * from Proveedor where codProv='"+"'";
			ResultSet rs = stmt.executeQuery(select);
			while(rs.next()) {
				Pro.setCodProv(Prov);
			}
			rs.close();
			this.disconnect();
			return Pro;
		}

		public Proveedor getDatosProv(String auxProv) throws ClassNotFoundException, SQLException {
			Proveedor pro = new Proveedor();
			this.connect();
			String select = "Select * from Proveedores where nombre = '"+auxProv+"'";
			ResultSet rs = stmt.executeQuery(select);
			while(rs.next()) {
				pro.setNombre(rs.getString(2));
				pro.setTlf(rs.getInt(3));
				pro.setDir(rs.getString(4));
				pro.setDesc(rs.getString(5));
				
			}
			rs.close();
			this.disconnect();
			return pro;
		}
		
		public void AñadirProveedor(Proveedor pro) throws SQLException, ClassNotFoundException {		//Añadir Proveedor
			this.connect();
			String insert ="Insert into Proveedores values(?,?,?,?,?)";
			stmt=con.prepareStatement(insert);
			stmt.setString(1, pro.getCodProv());
			stmt.setString(2, pro.getNombre());
			stmt.setInt(3, pro.getTlf());
			stmt.setString(4, pro.getDir());
			stmt.setString(5, pro.getDesc());
			stmt.executeUpdate();
			this.disconnect();
		}
		public void ModificarProveedor(Proveedor pro) throws SQLException, ClassNotFoundException {		//Añadir Proveedor
			this.connect();
			String update ="Update into proveedores where codProv="+pro.getCodProv()+" set value(?,?,?,?)";
			stmt=con.prepareStatement(update);
			stmt.setString(2,pro.getNombre());
			stmt.setInt(3, pro.getTlf());
			stmt.setString(4, pro.getDir());
			stmt.setString(5, pro.getDesc());
			stmt.executeUpdate();
			this.disconnect();
		}
		public void BorrarProveedor(String auxProv) throws SQLException, ClassNotFoundException {		//Borrar Proveedor
			this.connect();
			String delete ="delete from proveedores where codProv="+auxProv+"";
			stmt=con.prepareStatement(delete);
			this.disconnect();
		}
		public ArrayList <String> getNombreProv() throws ClassNotFoundException, SQLException {		//Cargar Proveedores
			
			ArrayList <String> pro = new ArrayList <String>();
			this.connect();
			String select = "Select nombre from Proveedores";
			stmt=con.prepareStatement(select);
			ResultSet rs = stmt.executeQuery(select);
			while(rs.next()) {
				pro.add(rs.getString(1));
			}
			rs.close();
			this.disconnect();
			return pro;
		}
		//Comida
		public Comida getDatosCom(String auxCom) throws ClassNotFoundException, SQLException {
			Comida com = new Comida();
			this.connect();
			String select = "Select * from comida where nombre = '"+auxCom+"'";
			ResultSet rs = stmt.executeQuery(select);
			while(rs.next()) {
				com.setCodCom(rs.getString(1));
				com.setNombre(rs.getString(2));
				com.setDesc(rs.getString(3));
				com.setAlimentacion(rs.getString(4));
				com.setStock(rs.getInt(5));
				com.setCodProv(rs.getString(6));
			}
			rs.close();
			this.disconnect();
			return com;
		}
		
		public void AñadirComida(Comida com) throws SQLException, ClassNotFoundException {		//Añadir Comida
			this.connect();
			String insert ="Insert into comida (codCom,nombre,describ,alimentacion,stock,codProv,codAli) values(?,?,?,?,?,?,?)";
			stmt=con.prepareStatement(insert);
			stmt.setString(1, com.getCodCom());
			stmt.setString(2, com.getNombre());
			stmt.setString(3, com.getDesc());
			stmt.setString(4, com.getAlimentacion());
			stmt.setInt(5, com.getStock());
			stmt.setString(6, com.getCodProv());
			stmt.setString(7, com.getCodAli());
			stmt.executeUpdate();
			this.disconnect();
		}
		public ArrayList <String> getNombreCom() throws ClassNotFoundException, SQLException {		//Cargar Comida
			
			ArrayList <String> com = new ArrayList <String>();
			this.connect();
			String select = "Select nombre from comida";
			stmt=con.prepareStatement(select);
			ResultSet rs = stmt.executeQuery(select);
			while(rs.next()) {
				com.add(rs.getString(1));
			}
			rs.close();
			this.disconnect();
			return com;
		}
public ArrayList <String> getCodPro() {		//Cargar Prov
			
			ArrayList <String> pro = new ArrayList <String>();
			try {
				this.connect();
				String select = "Select codProv from proveedores";
				stmt=con.prepareStatement(select);
				ResultSet rs = stmt.executeQuery(select);
				while(rs.next()) {
					pro.add(rs.getString(1));
				}
				rs.close();
				this.disconnect();
			}
			catch(Exception e){
				System.out.println(e);
			}
			return pro;
		}
public ArrayList <String> getCodCom() {		//Cargar Prov
	
	ArrayList <String> com = new ArrayList <String>();
	try {
		this.connect();
		String select = "Select codCom from comida";
		stmt=con.prepareStatement(select);
		ResultSet rs = stmt.executeQuery(select);
		while(rs.next()) {
			com.add(rs.getString(1));
		}
		rs.close();
		this.disconnect();
	}
	catch(Exception e){
		System.out.println(e);
	}
	return com;
}
public ArrayList <String> getCodAli() {		//Cargar Ali
	
			ArrayList <String> ali = new ArrayList <String>();
			try {
			this.connect();
			String select = "Select codAli from alimentacion";
			stmt=con.prepareStatement(select);
			ResultSet rs = stmt.executeQuery(select);
			while(rs.next()) {
				ali.add(rs.getString(1));
			}
			rs.close();
			this.disconnect();
			}
			catch(Exception e){
				System.out.println(e);
			}
			return ali;
		}
public void borrarProv(String auxProv) throws ClassNotFoundException, SQLException {
	this.connect();
	String delete = "Delete from proveedores where codProv = '"+auxProv+"' ";
	stmt=con.prepareStatement(delete);
	stmt.executeUpdate();
	this.disconnect();			
}
public void borrarCom(String auxCom) throws ClassNotFoundException, SQLException {
	this.connect();
	String delete = "Delete from Comida where codCom = '"+auxCom+"' ";
	stmt=con.prepareStatement(delete);
	stmt.executeUpdate();
	this.disconnect();			
}
public int hayProvs(int cont, String auxProv) throws ClassNotFoundException, SQLException {
	this.connect();
	cont=0;
	String select = "Select count(nombre) from comida where codProv = '"+auxProv+"'";
	stmt=con.prepareStatement(select);
	ResultSet rs = stmt.executeQuery();
	while(rs.next()) {
		cont=rs.getInt(1);
	}
	this.disconnect();
	return cont;
	
}
}