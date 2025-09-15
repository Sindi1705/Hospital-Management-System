    package hospitalmanagement;
    
import java.util.*;

		public class PatientList {
		    private Patient head; 
		    private Stack<Patient> dischargeStack; 
		    public PatientList() {
		        this.head = null; 
		        this.dischargeStack = new Stack<>(); 
		    }

		   
		    public void addPatient(String name, String condition, int severity) {
		        Patient newPatient = new Patient(name, condition, severity);
		        if (head == null) {
		            head = newPatient; 
		        } else {
		            Patient temp = head;
		            while (temp.next != null) {
		                temp = temp.next; 
		            }
		            temp.next = newPatient; 
		        }
		        System.out.println("Added: " + name + ", Condition: " + condition + ", Severity: " + severity);
		    }

		   
		    public void dischargePatient(String name) {
		        Patient prev = null, temp = head;
		        while (temp != null) {
		            if (temp.name.equals(name)) {
		                if (prev != null) {
		                    prev.next = temp.next; 
		                } else {
		                    head = temp.next; 
		                }
		                dischargeStack.push(temp); 
		                System.out.println("Discharged: " + name);
		                return;
		            }
		            prev = temp;
		            temp = temp.next;
		        }
		        System.out.println("Patient not found.");
		    }

		   
		    public void undoDischarge() {
		        if (!dischargeStack.isEmpty()) {
		            Patient patient = dischargeStack.pop(); 
		            addPatient(patient.name, patient.condition, patient.severity); 
		            System.out.println("Undo discharge: " + patient.name);
		        } else {
		            System.out.println("No discharges to undo.");
		        }
		    }

		   
		    public void printPatients() {
		        Patient temp = head;
		        while (temp != null) {
		            System.out.println(temp.name + " - " + temp.condition + " - Severity: " + temp.severity);
		            temp = temp.next;
		        }
		    }

		   
		    public void sortPatientsBySeverity() {
		        List<Patient> patients = getPatients(); 
		        int n = patients.size();
		        for (int i = 0; i < n - 1; i++) {
		            int maxIdx = i;
		            for (int j = i + 1; j < n; j++) {
		                if (patients.get(j).severity > patients.get(maxIdx).severity) {
		                    maxIdx = j;
		                }
		            }
		            Collections.swap(patients, i, maxIdx); 
		        }
		        reconstructList(patients); 
		    }

		  
		    private List<Patient> getPatients() {
		        List<Patient> patients = new ArrayList<>();
		        Patient temp = head;
		        while (temp != null) {
		            patients.add(temp);
		            temp = temp.next;
		        }
		        return patients;
		    }

		   
		    private void reconstructList(List<Patient> patients) {
		        head = null;
		        for (Patient patient : patients) {
		            addPatient(patient.name, patient.condition, patient.severity);
		        }
		    }

		    
		    public int countHighSeverity(int threshold) {
		        return countSeverityRecursive(head, threshold);
		    }

		    private int countSeverityRecursive(Patient node, int threshold) {
		        if (node == null) return 0;
		        return (node.severity > threshold ? 1 : 0) + countSeverityRecursive(node.next, threshold);
		    }
		}

	


