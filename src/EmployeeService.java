import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {

    ArrayList<Employee> employees = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Add Employee
    public void addEmployee() {

        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.println("Enter Employee Name:");
        String name = sc.nextLine();

        System.out.println("Enter Department:");
        String department = sc.nextLine();

        System.out.println("Enter Salary:");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, department, salary);

        employees.add(emp);

        System.out.println("\nEmployee Added Successfully!");

    }

    // View All Employees
    public void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("\nNo Employees Found!");
            return;
        }

        System.out.println("\n========== Employee List ==========");

        for (Employee emp : employees) {

            System.out.println("ID         : " + emp.id);
            System.out.println("Name       : " + emp.name);
            System.out.println("Department : " + emp.department);
            System.out.println("Salary     : " + emp.salary);
            System.out.println("-----------------------------------");

        }

    }

}