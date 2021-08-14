package kr.or.epro.fleaewha;

import org.junit.*;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class MySQLConnectionTest {

	private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
	
	private static final String URL ="jdbc:mysql://fleaewha.cvldmx2asljm.ap-northeast-2.rds.amazonaws.com:3306/fleaewha";
	private static final String USER ="admin";
	private static final String PASSWORD ="fleaewha";
	
	@Test
	public void testConnection() throws Exception {
		
		Class.forName(DRIVER);
		try {
			Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println(connection);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
			
	//fleaewha.cvldmx2asljm.ap-northeast-2.rds.amazonaws.com
}
