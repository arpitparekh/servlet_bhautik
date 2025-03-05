package my_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseHandler {
	
	Connection connection;
	PreparedStatement ps;
	final String connectionString = "jdbc:mysql://localhost/bascom";
	ArrayList<Majoor> list= new ArrayList<Majoor>();
	
	DatabaseHandler(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionString, "root", "Walden0042$$");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("DH : "+e.getMessage());
		}
		createTable();
	}
	
	private void createTable() {
		
		try {
			ps = connection.prepareStatement("create table if not exists majoor(id int primary key auto_increment,name text,salary float)");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DH : "+e.getMessage());
		}
	}

	void insertData(String name,float salary) {
		String sql = "insert into majoor(name,salary) values (?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setFloat(2, salary);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DH : "+e.getMessage());
		}
		
	}
	
	ArrayList<Majoor> showData() {
		
		list.clear();
		
		String sql = "select * from majoor";
		try {
			ResultSet result = ps.executeQuery(sql);
			
			while(result.next()) {				
				list.add(new Majoor(result.getInt("id"),result.getString("name"),result.getFloat("salary")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DH : "+e.getMessage());
			
		}
		
		return list;
		
	}
	
	

}
