import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {

    ArrayList<Employee> employees = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Add Employee
    public void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, department, salary);

        employees.add(emp);

        System.out.println("\nEmployee Added Successfully!");

    }

    // View Employees
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

    // Search Employee
    public void searchEmployee() {

        System.out.print("Enter Employee ID to Search: ");
        int searchId = sc.nextInt();

        boolean found = false;

        for (Employee emp : employees) {

            if (emp.id == searchId) {

                System.out.println("\nEmployee Found!");
                System.out.println("ID         : " + emp.id);
                System.out.println("Name       : " + emp.name);
                System.out.println("Department : " + emp.department);
                System.out.println("Salary     : " + emp.salary);

                found = true;
                break;

            }

        }

        if (!found) {

            System.out.println("Employee Not Found!");

        }

    }

    // Update Employee
    public void updateEmployee() {

        System.out.print("Enter Employee ID to Update: ");
        int updateId = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (Employee emp : employees) {

            if (emp.id == updateId) {

                System.out.print("Enter New Employee Name: ");
                emp.name = sc.nextLine();

                System.out.print("Enter New Department: ");
                emp.department = sc.nextLine();

                System.out.print("Enter New Salary: ");
                emp.salary = sc.nextDouble();

                System.out.println("\nEmployee Updated Successfully!");

                found = true;
                break;

            }

        }

        if (!found) {

            System.out.println("Employee Not Found!");

        }

    }

}