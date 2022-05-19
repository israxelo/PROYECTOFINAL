package Conexion_y_Métodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion_y_metodos {
	private static String bd = "XE";
	private static String login="PROYECTO";
	private static String password="proyecto";
	private static String url="jdbc:oracle:thin:@localhost:1521/"+bd;
	static Connection conexion =null;
	static Statement st =null;
	static ResultSet rs =null;

	public static void conectar() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion =DriverManager.getConnection(url,login,password);
			if(conexion !=null) {
				System.out.println("conexion realizada correctamente");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void ver_todo() {
		try {
			st = conexion.createStatement();
			rs = st.executeQuery("select * from PRUEBA");
			while(rs.next()) {
				System.out.println(rs.getString("COLUMNA1") + "   " + rs.getString("COLUMNA2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public static void main(String[] args) {
		conectar();
		ver_todo();
	}
	
	

}
