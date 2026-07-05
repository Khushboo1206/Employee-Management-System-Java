package ui;

import javax.swing.*;
import java.awt.Font;

public class Dashboard extends JFrame {

    public Dashboard() {

        setTitle("Employee Management System");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Employee Management System");
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setBounds(180, 30, 350, 40);

        JButton addButton = new JButton("Add Employee");
        addButton.setBounds(50, 120, 150, 40);

        JButton viewButton = new JButton("View Employees");
        viewButton.setBounds(250, 120, 150, 40);

        JButton updateButton = new JButton("Update Employee");
        updateButton.setBounds(450, 120, 170, 40);

        JButton deleteButton = new JButton("Delete Employee");
        deleteButton.setBounds(50, 200, 150, 40);

        JButton searchButton = new JButton("Search Employee");
        searchButton.setBounds(250, 200, 150, 40);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(450, 200, 170, 40);

        exitButton.addActionListener(e -> System.exit(0));

        add(heading);
        add(addButton);
        add(viewButton);
        add(updateButton);
        add(deleteButton);
        add(searchButton);
        add(exitButton);

        setVisible(true);

    }

}