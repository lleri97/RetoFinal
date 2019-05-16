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
import clases.Empleado;
import clases.Especie;
import clases.Oficio;
import clases.Recinto;

public class DBManager {
	private Connection con;
	private PreparedStatement stmt;
	private String dbHost;
	private String dbName;
	private String dbUser;
	private String dbPassword;
	
	public DBManager() throws IOException {
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
	}
	
		private void connect() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + dbHost + "/" + dbName + "?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			con = DriverManager.getConnection(url, dbUser, dbPassword);
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
		return rec;
	}
	public void AñadirAnimal(Animal ani) throws ClassNotFoundException, SQLException {
		this.connect();
		String sql="Insert into animales values (?,?,?,?,?,?,?)";
		stmt.setString(1, ani.getCodAni());
		stmt.setString(4, ani.getCodEsp());
		stmt.setString(7, ani.getDesc());
		stmt.setString(2, ani.getEstado());
		stmt.setInt(3, ani.getEdad());
		stmt.setString(5, ani.getCodRec());
		stmt.setString(6, ani.getCodCom());
	}
	//Oficios
	public void AñadirOficio(Oficio ofi) throws SQLException, ClassNotFoundException {
		this.connect();
		String sql ="Insert into oficio values(?,?,?,?)";
		stmt.setString(1, ofi.getCodOfi());
		stmt.setString(2, ofi.getNombre());
		stmt.setString(3, ofi.getDesc());
		stmt.setFloat(4, ofi.getSueldo());
		this.disconnect();
	}
	//Fin Oficios
	//Empleados
	public void AñadirEmpleado(Empleado emp) throws SQLException, ClassNotFoundException {
		this.connect();
		String sql="Insert into empleados values(?,?,?,?,?,?,?,?)";
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
	//Fin empleados

	public ArrayList <String> getNombreOficio() throws ClassNotFoundException, SQLException {
		
		ArrayList <String> ofi = new ArrayList <String>();
		this.connect();
		String select = "Select nombre from oficio";
		
		ResultSet rs = stmt.executeQuery(select);
		while(rs.next()) {
			ofi.add(rs.getString(1));
		}
		rs.close();
		this.disconnect();
		return ofi;
	}
	
	
}

