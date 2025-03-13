import java.util.ArrayList;
import java.util.List;

// Class representing a Learner
class Learner {
    private String name;
    private List<Subject> subjects = new ArrayList<>();

    public Learner(String name) {
        this.name = name;
    }

    public void registerSubject(Subject subject) {
        if (!subjects.contains(subject)) {
            subjects.add(subject);
            subject.addLearner(this);
        }
    }

    public String getName() {
        return name;
    }
}

// Class representing an Instructor
class Instructor {
    private String name;

    public Instructor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Class representing a Subject (Aggregation with Instructors, Association with Learners)
class Subject {
    private String name;
    private Instructor instructor;
    private List<Learner> learners = new ArrayList<>();

    public Subject(String name) {
        this.name = name;
    }

    public void assignInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void addLearner(Learner learner) {
        if (!learners.contains(learner)) {
            learners.add(learner);
        }
    }

    public void displaySubjectDetails() {
        System.out.println("Subject: " + name);
        if (instructor != null) {
            System.out.println("  Taught by: " + instructor.getName());
        }
        if (!learners.isEmpty()) {
            System.out.print("  Enrolled Learners: ");
            for (Learner learner : learners) {
                System.out.print(learner.getName() + ", ");
            }
            System.out.println();
        } else {
            System.out.println("  No learners enrolled yet.");
        }
    }
}

public class UniversityManagement {
    public static void main(String[] args) {

        Learner learner1 = new Learner("Monica");
        Learner learner2 = new Learner("Ross");

        Instructor instructor1 = new Instructor("Dr. Geller");
        Instructor instructor2 = new Instructor("Dr. Bing");

        Subject subject1 = new Subject("Mathematics");
        Subject subject2 = new Subject("Physics");

        subject1.assignInstructor(instructor1);
        subject2.assignInstructor(instructor2);

        learner1.registerSubject(subject1);
        learner1.registerSubject(subject2);
        learner2.registerSubject(subject2);

        subject1.displaySubjectDetails();
        subject2.displaySubjectDetails();
    }
}