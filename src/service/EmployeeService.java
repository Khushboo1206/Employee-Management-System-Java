package service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Employee;

public class EmployeeService {

    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Add Employee
    public void addEmployee() {

        try {

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            // Validate ID
            if (id <= 0) {
                System.out.println("Employee ID must be greater than 0.");
                return;
            }

            // Check duplicate ID
            for (Employee emp : employees) {
                if (emp.getId() == id) {
                    System.out.println("Employee ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            // Validate Salary
            if (salary < 0) {
                System.out.println("Salary cannot be negative.");
                return;
            }

            Employee emp = new Employee(id, name, department, salary);
            employees.add(emp);

            System.out.println("\nEmployee Added Successfully!");

        } catch (InputMismatchException e) {

            System.out.println("\nInvalid Input! Please enter the correct data type.");
            sc.nextLine(); // Clear invalid input

        }

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

        try {

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

        } catch (InputMismatchException e) {

            System.out.println("Invalid Employee ID!");
            sc.nextLine();

        }

    }

    // Update Employee
    public void updateEmployee() {

        try {

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
                    double salary = sc.nextDouble();

                    if (salary < 0) {
                        System.out.println("Salary cannot be negative.");
                        return;
                    }

                    emp.setSalary(salary);

                    System.out.println("\nEmployee Updated Successfully!");

                    found = true;
                    break;

                }

            }

            if (!found) {
                System.out.println("Employee Not Found!");
            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid Input!");
            sc.nextLine();

        }

    }

    // Delete Employee
    public void deleteEmployee() {

        try {

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

        } catch (InputMismatchException e) {

            System.out.println("Invalid Employee ID!");
            sc.nextLine();

        }

    }

}