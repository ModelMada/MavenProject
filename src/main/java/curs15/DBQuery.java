package curs15;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.*;

public class DBQuery {
	
	public static List<String> dbSelectQuery(Connection conn, String query){
		List<String> resultList = new ArrayList<String>();
		try {
			Statement statement = conn.createStatement();		//trimite query si intoarce rezultatul
			ResultSet result = statement.executeQuery(query);	//exzecuteQuery este doar pt select - result va contine rezultatul queryului nostru
			
			while(result.next()) {
				resultList.add(result.getString(2));
			}
			
		}catch(SQLException e) {
			System.out.println("nu am putut executa querry-ul!");
		}
		
		return resultList;
	}
	
	public static void dbUpdateQuery(Connection conn, String query){
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(query);		//executeUpdate strict pt updates pe baza
			System.out.println("Am facut update!");
		
	}catch(SQLException e) {
		System.out.println("nu am putut face update!");
	}
	}
	
	public static void dbDeleteQuery(Connection conn, String query){
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(query);		//executeUpdate strict pt updates pe baza
			System.out.println("Am facut delete!");
		
	}catch(SQLException e) {
		System.out.println("nu am putut face delete!");
	}
	}

}
