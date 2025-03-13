import java.util.ArrayList;

class Employee {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void displayEmployee() {
        System.out.println("   - " + name + " (" + position + ")");
    }
}

class Department {
    private String departmentName;
    private ArrayList<Employee> employees;

    // Constructor
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String position) {
        employees.add(new Employee(name, position));
    }

    public void displayDepartment() {
        System.out.println("Department: " + departmentName);
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }
}

class Company {
    private String companyName;
    private ArrayList<Department> departments;  // The company will have multiple departments

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public Department getDepartment(int index) {
        if (index >= 0 && index < departments.size()) {
            return departments.get(index);
        }
        return null;
    }

    public void displayCompany() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    public void closeCompany() {
        System.out.println("\nClosing Company: " + companyName);
        departments.clear();  // Remove all departments and also the employees in that department
        System.out.println("All departments and employees have been deleted.");
    }
}

public class CompanyDepartments {
    public static void main(String[] args) {
        Company myCompany = new Company("Amazon");

        myCompany.addDepartment("Marketing");
        myCompany.addDepartment("Human Resources");

        myCompany.getDepartment(0).addEmployee("Betty", "Software Engineer");
        myCompany.getDepartment(0).addEmployee("James", "Tech Lead");
        myCompany.getDepartment(1).addEmployee("Chloe", "HR Manager");

        myCompany.displayCompany();

        myCompany.closeCompany();
    }
}