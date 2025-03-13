class Hospital {
    private String name;
    private Doctor doctor1;
    private Doctor doctor2;

    public Hospital(String name) {
        this.name = name;
    }

    public void displayHospitalDetails() {
        System.out.println("Hospital: " + name);
    }
}

// Class representing a Doctor (Association with Patient)
class Doctor {
    private String name;
    private Patient patient1;
    private Patient patient2;

    public Doctor(String name) {
        this.name = name;
    }

    public void consult(Patient patient) {
        if (patient1 == null) {
            patient1 = patient;
        } else if (patient2 == null) {
            patient2 = patient;
        }
        System.out.println(patient.getName() + " is consulting " + name);
    }
}

// Class representing a Patient (Association with Doctor)
class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("Neelam Hospital");

        Doctor doctor1 = new Doctor("Dr. Gurpreet");
        Doctor doctor2 = new Doctor("Dr. Vishwakumar");

        Patient patient1 = new Patient("Amar");
        Patient patient2 = new Patient("Dev");

        hospital.displayHospitalDetails();

        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient1);

    }
}
