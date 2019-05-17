package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;

import clases.Animal;
import clases.Especie;
import clases.Recinto;

public class DBManager {
	private Connection con;
	private PreparedStatement stmt;

		private void connect() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://192.168.20.110/reto";
			con = DriverManager.getConnection(url,"cualquiera","1");
			con.createStatement();
		}
	
		private void disconnect() throws SQLException {
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
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
	
	}



