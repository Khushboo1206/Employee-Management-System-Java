package service;

import java.util.InputMismatchException;
import java.util.Scanner;

import dao.EmployeeDAO;
import model.Employee;

public class EmployeeService {

    Scanner sc = new Scanner(System.in);
    EmployeeDAO dao = new EmployeeDAO();

    // ================= ADD EMPLOYEE =================
    public void addEmployee() {

        try {

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (id <= 0) {
                System.out.println("Employee ID must be greater than 0.");
                return;
            }

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            if (salary < 0) {
                System.out.println("Salary cannot be negative.");
                return;
            }

            Employee emp = new Employee(id, name, department, salary);

            if (dao.addEmployee(emp)) {
                System.out.println("\nEmployee Added Successfully!");
            } else {
                System.out.println("\nFailed to Add Employee!");
            }

        } catch (InputMismatchException e) {

            System.out.println("\nInvalid Input!");
            sc.nextLine();

        }

    }

    // ================= VIEW EMPLOYEES =================
    public void viewEmployees() {

        dao.viewEmployees();

    }

    // ================= SEARCH EMPLOYEE =================
    public void searchEmployee() {

        try {

            System.out.print("Enter Employee ID to Search: ");
            int id = sc.nextInt();

            Employee emp = dao.searchEmployee(id);

            if (emp != null) {

                System.out.println("\nEmployee Found!");
                System.out.println("ID         : " + emp.getId());
                System.out.println("Name       : " + emp.getName());
                System.out.println("Department : " + emp.getDepartment());
                System.out.println("Salary     : " + emp.getSalary());

            } else {

                System.out.println("\nEmployee Not Found!");

            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid Employee ID!");
            sc.nextLine();

        }

    }

    // ================= UPDATE EMPLOYEE =================
    public void updateEmployee() {

        try {

            System.out.print("Enter Employee ID to Update: ");
            int id = sc.nextInt();
            sc.nextLine();

            Employee emp = dao.searchEmployee(id);

            if (emp == null) {

                System.out.println("Employee Not Found!");
                return;

            }

            System.out.print("Enter New Name: ");
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

            if (dao.updateEmployee(emp)) {

                System.out.println("\nEmployee Updated Successfully!");

            } else {

                System.out.println("\nUpdate Failed!");

            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid Input!");
            sc.nextLine();

        }

    }

    // ================= DELETE EMPLOYEE =================
    public void deleteEmployee() {

        try {

            System.out.print("Enter Employee ID to Delete: ");
            int id = sc.nextInt();

            if (dao.deleteEmployee(id)) {

                System.out.println("\nEmployee Deleted Successfully!");

            } else {

                System.out.println("\nEmployee Not Found!");

            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid Employee ID!");
            sc.nextLine();

        }

    }

}