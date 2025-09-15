package hospitalmanagement;

public class HospitalManagement {

	public static void main(String[] args) {
		
		 PatientList hospital = new PatientList();

	        hospital.addPatient("John Doe", "Heart Attack", 9);
	        hospital.addPatient("Jane Smith", "Flu", 4);
	        hospital.addPatient("Alice Brown", "Fracture", 6);

	        System.out.println("\n--- Patients Before Sorting ---");
	        hospital.printPatients();

	        hospital.sortPatientsBySeverity();
	        System.out.println("\n--- Patients After Sorting ---");
	        hospital.printPatients();

	        System.out.println("\n--- Discharging a Patient ---");
	        hospital.dischargePatient("Jane Smith");
	        hospital.printPatients();

	        System.out.println("\n--- Undo Last Discharge ---");
	        hospital.undoDischarge();
	        hospital.printPatients();

	        System.out.println("\n--- Counting High Severity Patients (Threshold: 5) ---");
	        System.out.println(hospital.countHighSeverity(5));
	    }
	}

	


