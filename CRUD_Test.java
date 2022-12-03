package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUD_Test {
	
	public static void main(String[] args) {
		CRUD_Test objTest = new CRUD_Test();
		// objTest.insert_data("2", "Pratik", "Pratik01@gmail.com", "7463849234");
		// insert data or Create 
		
		//objTest.read_data(" ");
		// Read data 
		
		//objTest.update_data("2", "3", "Amol", "Amol2@gmail","9143201129");
		// update data 
		
		objTest.delete_data("3");
		// delete data 
		
	}
	
	// create data 
	public void insert_data(String prn_no,String name,String email, String contact) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection() ;
		
		PreparedStatement ps = null ;
		try {
			
			String query ="insert into Student(prn_no,name,email,contact) values(?,?,?,?)";
			ps =connection.prepareStatement(query);
			ps.setString(1, prn_no);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, contact);
			System.out.println(ps);
			ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	// read data 
	public void read_data(String prn_no){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String query="select * from Student "; // select * from Student where prn_no = ? ;
			ps=connection.prepareStatement(query);
			//ps.setString(1, prn_no);
			System.out.println(ps);
			rs=ps.executeQuery();
			while(rs.next()){
			System.out.println("prn no -"+rs.getString("prn_no"));
			System.out.println("name -"+rs.getString("name"));
			System.out.println("email -"+rs.getString("email"));
			System.out.println("contact -"+rs.getString("contact"));
			
			System.out.println("---------------");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	// update data 
	public void update_data(String prn_no,String new_prn_no,String name,String email,String contact){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		try {
			String query="update Student set prn_no=?,name=?,email=?,contact=? where prn_no=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, new_prn_no);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, contact);
			ps.setString(5, prn_no);
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	// Delete data 
	public void delete_data(String prn_no){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		try {
			String query="delete from Student where prn_no=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, prn_no);
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
