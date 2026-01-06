package hospital_patient_record_system;

import java.util.*;
import java.sql.*;

public class Login_Service {
	
		public static String login(Scanner sc) throws Exception{
			
			String sql="select role from users where username=? and password=?";
			Connection con=Hospital_Connection.hospitalConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("Enter User Name");
			String username=sc.nextLine();
			System.out.println("Enter Password");
			String pass=sc.nextLine();
			ps.setString(1, username);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				return rs.getString("role");
			}
			else {
				return null;
			}
			

}
}
