package com.platform.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.platform.model.User;
import com.platform.util.DBUtil;



@Service
public class UsersHandler {
public boolean addUser(User us) {
	boolean flag=false;
	Connection conn=DBUtil.establishConnection();
	try {
		
		String name=us.getUsername();
		String pass=us.getPassword();
		String email=us.getEmailId();
		PreparedStatement st=conn.prepareStatement("insert into userdb values(?,?,?,?);");

		st.setInt(1,1);
		st.setString(2, name);
		st.setString(3, pass);
		st.setString(4, email);
		
		int res=st.executeUpdate();
		if(res>0) {
			flag=true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
	return flag;
	
	}






public boolean authentication(User us) {
	Connection conn=DBUtil.establishConnection();
	
	try {
		PreparedStatement ps=conn.prepareStatement("select password from userdb where username=?;");
		
		ps.setString(1, us.getUsername());
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
			
			if( rs.getString("password").equals(us.getPassword())) {
				return true;
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return false;
}
}
