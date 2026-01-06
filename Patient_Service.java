package hospital_patient_record_system;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Patient_Service {

	Scanner sc=new Scanner (System.in);
	public void addPatient() {
		
        String sql = "INSERT INTO patients(name, age, gender, contact, disease, admission_date) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection con=Hospital_Connection.hospitalConnection();
        		PreparedStatement ps=con.prepareStatement(sql)){
        	
        	System.out.println("Enter Patient Name");
        	String name=sc.nextLine();
        	System.out.println("Enter Age");
        	int age=sc.nextInt();
        	sc.nextLine();
        	System.out.println("Enter Gender");
        	String gen=sc.nextLine();
        	System.out.println("Enter Contact");
        	String contact=sc.nextLine();
        	System.out.println("Enter disease");
        	String disease=sc.nextLine();
        	System.out.println("Enter Admission Date(YYYY-MM-DD");
        	String date=sc.next();
        	
        	ps.setString(1,name);
        	ps.setInt(2, age);
        	ps.setString(3, gen);
        	ps.setString(4, contact);
        	ps.setString(5, disease);
        	ps.setDate(6, Date.valueOf(date));
        	ps.executeUpdate();
        	System.out.println("Patient added successfully");
        	
        }catch(Exception e) {
        	System.out.println("Error While Adding Patient");
        }
		
	}

	public void addMedicalHistory() {
		
        String sql = "INSERT INTO medical_history(patient_id, diagnosis, treatment, doctor_name, visit_date) VALUES (?, ?, ?, ?, ?)";

        try(Connection con=Hospital_Connection.hospitalConnection();
        		PreparedStatement ps=con.prepareStatement(sql)){
        	
        	System.out.println("Enter Patient Id");
        	int pid=sc.nextInt();
        	sc.nextLine();
        	System.out.println("Enter Diagnosis");
        	String diag=sc.nextLine();
        	System.out.println("Enter Treatment");
        	String treatment=sc.nextLine();
        	System.out.println("Enter Doctor Name");
        	String name=sc.nextLine();
        	System.out.println("Enter Visit Date");
        	String date=sc.next();
        	
        	ps.setInt(1, pid);
        	ps.setString(2, diag);
        	ps.setString(3, treatment);
        	ps.setString(4, name);
        	ps.setDate(5, Date.valueOf(date));
        	ps.executeUpdate();
        	System.out.println("Medical History Added Successfully");
        }catch(Exception e) {
        	System.out.println("Error while medical history");
        }
		
	}

	public void viewPatient() {
		
		String sql = "SELECT * FROM patients WHERE patient_id = ?";
		
		try(Connection con = Hospital_Connection.hospitalConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
	        
	        System.out.print("Enter patient ID: ");
	        int pid = sc.nextInt();
	        ps.setInt(1, pid);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            System.out.println("\n----- Patient Details -----");
	            System.out.println("ID       : " + rs.getInt("patient_id"));
	            System.out.println("Name     : " + rs.getString("name"));
	            System.out.println("Age      : " + rs.getInt("age"));
	            System.out.println("Gender   : " + rs.getString("gender"));
	            System.out.println("Contact  : " + rs.getString("contact"));
	            System.out.println("Disease  : " + rs.getString("disease"));
	            System.out.println("Admitted : " + rs.getDate("admission_date"));
	        } else {
	            System.out.println("Patient not found!");
	        }
	    }catch(Exception e) {
	    	System.out.println("Error While View Patients");
	}

	}

	public void viewMedicalHistory() {
		
         String sql = "SELECT * FROM medical_history WHERE record_id = ?";
		
		try(Connection con = Hospital_Connection.hospitalConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
	        
	        System.out.print("Enter Record ID: ");
	        int pid = sc.nextInt();
	        ps.setInt(1, pid);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            System.out.println("\n----- Medical History Details -----");
	            System.out.println("ID             : " + rs.getInt("record_id"));
	            System.out.println("Patient Id     : " + rs.getInt("patient_id"));
	            System.out.println("Diagnosis      : " + rs.getInt("diagnosis"));
	            System.out.println("Treatment      : " + rs.getString("treatment"));
	            System.out.println("Doctor Name    : " + rs.getString("doctor_name"));
	            System.out.println("Visit Date     : " + rs.getDate("visit_date"));
	        } else {
	            System.out.println("Medical History not found!");
	        }
	    }catch(Exception e) {
	    	System.out.println("Error While View Medical HIstoryadmin");
	}
	}

}
