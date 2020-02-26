package com.util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	//Write the required business logic as expected in the question description
	public static Connection establishConnection() {
		Connection conn=null;
		try {
			FileReader reader=new FileReader("database.properties");
			Properties p=new Properties();
			try {
				p.load(reader);
				try {
					conn=DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"),p.getProperty("password"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
