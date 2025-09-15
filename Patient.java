    package hospitalmanagement;

	public class Patient {
	    String name, condition;
	    int severity;
	    Patient next;

	    public Patient(String name, String condition, int severity) {
	        this.name = name;
	        this.condition = condition;
	        this.severity = severity;
	        this.next = null; 
	    }
	}
