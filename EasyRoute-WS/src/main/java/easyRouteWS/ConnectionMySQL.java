package easyRouteWS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConnectionMySQL {
	
	//private static String url = "jdbc:mysql://localhost/easy_route?user=root&password=mauricio";
	private static String url = "jdbc:mysql://mauricioramos.hopto.org/easy_route?user=root&password=mauricio";
	public static String status = "";
		
	public static Connection getConexao(){
		Connection conn = null;
		
		try {Class.forName("com.mysql.jdbc.Driver").newInstance();				
				conn = DriverManager.getConnection(url);				
				status = "Connection opened";
		}
	
	catch(SQLException e){
		status = e.getMessage();
	}
	catch(ClassNotFoundException e){		
		status = e.getMessage();
	}
	catch(Exception e){
		status = e.getMessage();
	}
	
	return conn;
	}
}
