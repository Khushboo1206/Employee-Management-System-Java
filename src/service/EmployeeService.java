package service;

import java.util.ArrayList;
import java.util.Scanner;

import model.Employee;

public class EmployeeService {

    ArrayList<Employee> employees = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Add Employee
    public void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check for duplicate ID
        for (Employee emp : employees) {

            if (emp.getId() == id) {

                System.out.println("\nEmployee ID already exists!");
                return;

            }

        }

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

            System.out.println("ID         : " + emp.getId());
            System.out.println("Name       : " + emp.getName());
            System.out.println("Department : " + emp.getDepartment());
            System.out.println("Salary     : " + emp.getSalary());
            System.out.println("-----------------------------------");

        }

    }

    // Search Employee
    public void searchEmployee() {

        System.out.print("Enter Employee ID to Search: ");
        int searchId = sc.nextInt();

        boolean found = false;

        for (Employee emp : employees) {

            if (emp.getId() == searchId) {

                System.out.println("\nEmployee Found!");
                System.out.println("ID         : " + emp.getId());
                System.out.println("Name       : " + emp.getName());
                System.out.println("Department : " + emp.getDepartment());
                System.out.println("Salary     : " + emp.getSalary());

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

            if (emp.getId() == updateId) {

                System.out.print("Enter New Employee Name: ");
                emp.setName(sc.nextLine());

                System.out.print("Enter New Department: ");
                emp.setDepartment(sc.nextLine());

                System.out.print("Enter New Salary: ");
                emp.setSalary(sc.nextDouble());

                System.out.println("\nEmployee Updated Successfully!");

                found = true;
                break;

            }

        }

        if (!found) {

            System.out.println("Employee Not Found!");

        }

    }

    // Delete Employee
    public void deleteEmployee() {

        System.out.print("Enter Employee ID to Delete: ");
        int deleteId = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i).getId() == deleteId) {

                employees.remove(i);

                System.out.println("\nEmployee Deleted Successfully!");

                found = true;
                break;

            }

        }

        if (!found) {

            System.out.println("Employee Not Found!");

        }

    }

}