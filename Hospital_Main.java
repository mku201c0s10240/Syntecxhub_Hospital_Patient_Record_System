package hospital_patient_record_system;

import java.util.*;


public class Hospital_Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner (System.in);
		Patient_Service ps=new Patient_Service();
		
		Login_Service ls=new Login_Service();
		try {
			String role=Login_Service.login(sc);
			
			if(role==null) {
				System.out.println("Invalid login credentials!");
				return;
			}
			System.out.println("Login successfull as :"+role);
			
			while(true) {
				System.out.println("...HOSPITAL MENU...");
				
				if(role.equals("admin")) {
					System.out.println("1. Add New Patients");
					System.out.println("2. Add Medical History");
					System.out.println("3. View Patient Details");
					System.out.println("4. Exit");
				}
				if(role.equals("doctor")) {
					System.out.println("1. Add Medical History");
					System.out.println("2. View Patient Details");
					System.out.println("3. Exit");
				}
				System.out.println("Enter Choice :");
				int ch=sc.nextInt();
				
				if(role.equals("admin")) {
					switch(ch) {
					case 1:ps.addPatient();
					break;
					case 2:ps.addMedicalHistory();
					break;
					case 3:ps.viewPatient();
					break;
					case 4:ps.viewMedicalHistory();
					break;
					case 5:System.out.println("Thank You");
					return;
					default:System.out.println("Invalid choice..");
					break;
					}
				}
				if(role.equals("doctor")) {
					switch(ch) {
					case 1:ps.addMedicalHistory();
					break;
					case 2:ps.viewPatient();
					break;
					case 3:System.out.println("Thank You");
					return;
					default:System.out.println("Invalid choice..");
					break;
					}
				}
			}
			
		}catch(Exception e) {
			System.out.println("Error Main Method "+e);
			
		}

	}

}
