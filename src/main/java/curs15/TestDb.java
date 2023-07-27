package curs15;

import java.sql.Connection;

public class TestDb {
	
	static String URL = "jdbc:mysql://keytraining-demo.c050jeowbe1q.eu-central-1.rds.amazonaws.com:3306/KeyTraining";
	static String USER = "demouser";
	static String PASS = "demouser";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Obiect de tip DB connection, care deschide o conexiune la baza de date
		//baza de date bazata pe credentialele de mai sus
		Connection conn = DbConnection.openDbConnection(URL, USER, PASS);
		//query
		String selectQuery = "select * from customers;";
		//metoda care primeste obiectul de tip connection si queryul si executa
		// query ul pe connexiuea primita
		System.out.println(DBQuery.dbSelectQuery(conn, selectQuery));	
		
		//update pe baza de date
		String updateQuery = "update customers set CustomerName = 'ModelMada' where CustomerName = 'TestCristi';";
		DBQuery.dbUpdateQuery(conn, updateQuery);
		//facem select ca sa vedem updateul
		String selectQuery2 = "select * from customers;";
		System.out.println(DBQuery.dbSelectQuery(conn, selectQuery2));	
		
		//delete client
		String deleteQuery = "delete from customers where CustomerName='ModelMada';";
		DBQuery.dbDeleteQuery(conn, deleteQuery);
		//facem select ca sa vedem updateul
		String selectQuery3 = "select * from customers;";
		System.out.println(DBQuery.dbSelectQuery(conn, selectQuery3));	

		
		//inchidem obiectul de tip connection
		DbConnection.closeDbConnection(conn);
		
		
		
	}

}
