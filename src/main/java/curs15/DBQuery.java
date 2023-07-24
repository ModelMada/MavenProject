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
			ResultSet result = statement.executeQuery(query);	//result va contine rezultatul queryului nostru
			
			while(result.next()) {
				resultList.add(result.getString(2));
			}
			
		}catch(SQLException e) {
			System.out.println("nu am putut executa querry-ul!");
		}
		
		return resultList;
	}

}
