import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while (true) {

            System.out.println("\n========== Employee Management System ==========");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    service.addEmployee();
                    break;

                case 2:
                    service.viewEmployees();
                    break;

                case 6:
                    System.out.println("Thank you for using Employee Management System!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");

            }

        }

    }

}