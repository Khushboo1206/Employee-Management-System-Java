package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DBConnection;
import model.Employee;

public class EmployeeDAO {

    // Add Employee into Database
    public boolean addEmployee(Employee employee) {

        String query = "INSERT INTO employees (id, name, department, salary) VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\nEmployee Added Successfully!");
                return true;
            }

        } catch (Exception e) {

            System.out.println("\nFailed to Add Employee!");
            e.printStackTrace();

        }

        return false;

    }

}