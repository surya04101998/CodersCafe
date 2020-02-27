package com.platform.util;
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
			FileReader reader=new FileReader("C:\\Users\\839843\\Documents\\workspace-spring-tool-suite-4-4.5.1.RELEASE\\platform\\src\\main\\java\\com\\platform\\util\\database.properties");
			Properties p=new Properties();
			try {
				p.load(reader);
				try {
					conn=DriverManager.getConnection(p.getProperty("DB_URL"), p.getProperty("DB_USERNAME"),p.getProperty("DB_PASSWORD"));
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
