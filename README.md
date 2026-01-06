# Syntecxhub_Hospital_Patient_Record_System
This project is developed as part of my internship at **SyntecxHub**.  
It is a Java-based console application designed to manage hospital patient records securely using MySQL.

# Project Overview
The **Hospital Patient Record System** allows hospitals to:
- Maintain patient information
- Store medical history
- Control access using role-based login (Admin & Doctor)

# Features
# Authentication
- Secure login system
- Role-based access:
  - **Admin**
  - **Doctor**

# Admin Functionalities
- Add new patients
- Add medical history
- View patient details
- View medical history

# Doctor Functionalities
- Add medical history
- View patient details

# Technologies Used
- Java
- JDBC
- MySQL
- SQL
- OOP Concepts


# Database Tables
### `users`
- username
- password
- role

### `patients`
- patient_id
- name
- age
- gender
- contact
- disease
- admission_date

### `medical_history`
- record_id
- patient_id
- diagnosis
- treatment
- doctor_name
- visit_date

# Project Structure
hospital_patient_record_system
│
├── Hospital_Connection.java
├── Login_Service.java
├── Hospital_Main.java
└── Patient_Service.java

# Learning Outcomes
- JDBC connection handling
- PreparedStatement for SQL security
- Role-based access control
- Real-time database integration
- Java console application design

# Acknowledgement
Special thanks to **SyntecxHub** for providing this internship opportunity and practical learning experience.

# Author
NAGARAJ  A   Java Developer(Fresher)
