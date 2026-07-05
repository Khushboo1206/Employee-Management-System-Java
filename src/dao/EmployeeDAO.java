package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;
import model.Employee;

public class EmployeeDAO {

    // ================= ADD EMPLOYEE =================
    public boolean addEmployee(Employee employee) {

        String query = "INSERT INTO employees(id, name, department, salary) VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }

    // ================= VIEW EMPLOYEES =================
    public void viewEmployees() {

        String query = "SELECT * FROM employees";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Employee List ==========");

            while (rs.next()) {

                System.out.println("ID         : " + rs.getInt("id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Department : " + rs.getString("department"));
                System.out.println("Salary     : " + rs.getDouble("salary"));
                System.out.println("------------------------------------");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // ================= SEARCH EMPLOYEE =================
    public Employee searchEmployee(int id) {

        String query = "SELECT * FROM employees WHERE id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary"));

                rs.close();
                ps.close();
                con.close();

                return emp;

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    // ================= UPDATE EMPLOYEE =================
    public boolean updateEmployee(Employee employee) {

        String query = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getDepartment());
            ps.setDouble(3, employee.getSalary());
            ps.setInt(4, employee.getId());

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }

    // ================= DELETE EMPLOYEE =================
    public boolean deleteEmployee(int id) {

        String query = "DELETE FROM employees WHERE id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }

}