class School {
    private String name;
    private Student student1;
    private Student student2;

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        if (student1 == null) {
            student1 = student;
        } else if (student2 == null) {
            student2 = student;
        }
    }

    public void displaySchoolDetails() {
        System.out.println("School: " + name);

        if (student1 != null) {
            student1.displayStudentDetails();
        }
        if (student2 != null) {
            student2.displayStudentDetails();
        }
    }
}

class Student {
    private String name;
    private Course course1;
    private Course course2;

    public Student(String name) {
        this.name = name;
    }

    public void enrollInCourse(Course course) {
        if (course1 == null) {
            course1 = course;
        } else if (course2 == null) {
            course2 = course;
        }
        course.addStudent(this);
    }

    public void displayStudentDetails() {
        if (course1 != null) {
            System.out.println(name + " is enrolled in: " + course1.getName());
        }

        if (course2 != null) {
            System.out.println(name + " is enrolled in: " + course2.getName());
        }
    }
}

class Course {
    private String name;
    private Student student1;
    private Student student2;

    public Course(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        if (student1 == null) {
            student1 = student;
        } else if (student2 == null) {
            student2 = student;
        }
    }

    public String getName() {
        return name;
    }
}

public class TheSchool {
    public static void main(String[] args) {
        School school = new School("DPS");

        // Creating student object
        Student alex = new Student("Alex");
        Student luke = new Student("Luke");

        // Adding students to the school
        school.addStudent(alex);
        school.addStudent(luke);

        // Creating courses
        Course ai = new Course("Artificial Intelligence");
        Course maths = new Course("Mathematics");

        // Enrolling students in courses
        alex.enrollInCourse(ai);
        alex.enrollInCourse(maths);
        luke.enrollInCourse(maths);

        // Display school details
        school.displaySchoolDetails();
    }
}