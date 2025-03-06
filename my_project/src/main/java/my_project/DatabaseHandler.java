package my_project;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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

	void insertData(String name,float salary,InputStream is,String fileName) {
		String sql = "insert into majoor(name,salary,image,image_path) values (?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setFloat(2, salary);
			ps.setBlob(3, is);
			ps.setString(4, fileName);
			ps.execute();
			try {
				is.close();
			} catch (IOException e) {

				System.out.println("DH : "+" Input Stream close nai thai");
				
			}
			
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
				int id = result.getInt("id");
				String name = result.getString("name");
				float salary = result.getFloat("salary");
				String image_path = result.getString("image_path");
				Blob b = result.getBlob("image");
				
				InputStream is = b.getBinaryStream();
				byte[] arr = new byte[2024];
				try {
					arr = new byte[is.available()];
					is.read(arr);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("DH Blog  mathi read kairu: "+e.getMessage());
				}
				
			
				list.add(new Majoor(id,name,salary,arr,image_path));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DH : "+e.getMessage());
			
		}
		
		return list;
		
	}
	
	Majoor getSingleData(int parameterId) {
		Majoor m = new Majoor();
		String sql = "select * from majoor where id=?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, parameterId);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				float salary = result.getFloat("salary");
				String image_path = result.getString("image_path");
				Blob b = result.getBlob("image");
				
				
				InputStream is = b.getBinaryStream();
				byte[] arr = new byte[2024];
				try {
					arr = new byte[is.available()];
					is.read(arr);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("DH Blog  mathi read kairu: "+e.getMessage());
				}
				
				image_path = "/home/arpit-parekh/Pictures/Screenshots/" + image_path;
				
				m = new Majoor(id,name,salary,arr,image_path);
			}
			return m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DH : "+e.getMessage());

		}
		return m;
		
	}
	
	void updateData(String name,float salary,int id) {
		String sql = "update majoor set name = ?,salary = ? where id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setFloat(2, salary);
			ps.setInt(3, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DH : "+e.getMessage());
		}
		
	}
	
	void deleteData(int id) {
		String sql = "delete from majoor where id = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			
		}catch (Exception e) {
			
			System.out.println("DH : "+e.getMessage());

		}
				
	}
	
	

}
