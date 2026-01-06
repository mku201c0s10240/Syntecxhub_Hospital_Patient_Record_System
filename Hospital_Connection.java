package hospital_patient_record_system;

import java.sql.*;

public class Hospital_Connection {

	public static final String url="jdbc:mysql://localhost:3306/syntecxhub2";
	public static final String user="root";
	public static final String password="Nagaraj@2003";
	
	public static Connection hospitalConnection() {
		try {
			return DriverManager.getConnection(url,user,password);
		}catch(Exception e) {
			System.out.println("Database Connection Failed");
			return null;
		}
	}
	
}
