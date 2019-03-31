package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import utilities.Utilidades;

public class DaoUsuario {
	public boolean altaUser(String usuario, String password, String nombre, int edad) {
		boolean temp=false;
		Connection con=Utilidades.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into usuarios (usuario,password,nombre,edad) value(?,?,?,?)");
			ps.setString(1, usuario);
			ps.setString(2, Utilidades.encriptar(password));
			ps.setString(3, nombre);
			ps.setInt(4, edad);
			ps.execute();
			temp=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public Map<String,String> obtenerUser(String usuario, String password){
		Map<String,String> temp=null;
		Connection con=Utilidades.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from usuarios where usuario=? and password=?");
			ps.setString(1, usuario);
			ps.setString(2, Utilidades.encriptar(password));
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				temp=new HashMap<>();
				temp.put(rs.getString("usuario"),rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return temp;
	}
	
	public String obtenerUser(String usuario){
		String temp=null;
		Connection con=Utilidades.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from usuarios where usuario=?");
			ps.setString(1, usuario);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				temp=rs.getString("usuario");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return temp;
	}

}
