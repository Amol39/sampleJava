package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
	
	public static void main(String[] args) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		System.out.println(obj_DB_Connection.get_connection());
	}
	
	
	public Connection get_connection() {
		Connection connection = null ;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/crud";
			String username = "root";
			String password ="Amol@4004";
			
			connection = DriverManager.getConnection(url, username, password);
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return connection ;
		
	}

}
