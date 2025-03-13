class University {
    private String name;
    private Department department1;
    private Department department2;
    private Faculty faculty1;
    private Faculty faculty2;

    public University(String name) {
        this.name = name;
    }

    public void addDepartments(String dept1, String dept2) {
        this.department1 = new Department(dept1);
        this.department2 = new Department(dept2);
    }

    // Method to add faculty (Aggregation)
    public void addFaculty(Faculty faculty) {
        if (faculty1 == null) {
            faculty1 = faculty;
        } else if (faculty2 == null) {
            faculty2 = faculty;
        }
    }

    public void displayUniversityDetails() {
        System.out.println("University: " + name);

        if (department1 != null) {
            department1.displayDepartment();
        }
        if (department2 != null) {
            department2.displayDepartment();
        }
        if (faculty1 != null) {
            System.out.println("Faculty: " + faculty1.getName());
        }
        if (faculty2 != null) {
            System.out.println("Faculty: " + faculty2.getName());
        }
    }
}

// Class representing a Department (Composition - Exists only within University)
class Departmentt {

    private String name;

    public Departmentt(String name) {
        this.name = name;
    }

    public void displayDepartment() {
        System.out.println("  Department: " + name);
    }
}

// Class representing a Faculty (Aggregation - Can exist independently)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        University university = new University("Chitkara University");

        university.addDepartments("Computer Science", "M Pharma");

        Faculty faculty1 = new Faculty("Dr. Verma");
        Faculty faculty2 = new Faculty("Prof. Jeetu");

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        university.displayUniversityDetails();
    }
}
