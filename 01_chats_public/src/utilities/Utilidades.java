package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Utilidades {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop=new Properties();
		Connection con=null;
		String parent="D:/GitMe/public/01_chats_public";
		File datas=Paths.get(parent,"/src/utilities/conexion.properties").toFile();
		try(FileInputStream fis=new FileInputStream(datas);){
			prop.load(fis);
			con=DriverManager.getConnection(prop.getProperty("url"), prop);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static String encriptar(String password) {
		return DigestUtils.sha256Hex(password);
	}
	
	public static String agregarAlJSON(String json,String k ,String v) {
		JSONObject obj=(JSONObject) JSONValue.parse(json);
		obj.put(k, v);
		return obj.toJSONString();
	}
	
	public static String timeNow() {
		Locale esp=new Locale("es");
		LocalTime t=LocalTime.now();
		return t.format(DateTimeFormatter.ofPattern("hh:mm a", esp));		
	}
	
}
