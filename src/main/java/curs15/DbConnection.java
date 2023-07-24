package curs15;
import java.sql.*;

public class DbConnection {

	public static Connection openDbConnection(String url, String user, String pass) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexiune cu success!");
		}catch(SQLException e) {
			System.out.println("nu am putut face conexiunea!");
		}
		return conn;
	}
	
	public static void closeDbConnection(Connection conn) {		//am nevoie de un obiect de tip conexiune pt a avea ce inchide
		try {
			conn.close();
			System.out.println("Conexiunea a fost inchisa!");
			
		}catch(SQLException e){
			System.out.println("nu am putut inchide conexiunea!");	//daca nu merge sa inchid
			
		}
	}
}
