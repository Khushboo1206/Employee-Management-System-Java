package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener {

    JLabel titleLabel, userLabel, passLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    public LoginFrame() {

        setTitle("Employee Management System - Login");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("Employee Management System");
        titleLabel.setBounds(60, 20, 350, 35);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));

        userLabel = new JLabel("Username");
        userLabel.setBounds(50, 80, 100, 25);

        usernameField = new JTextField();
        usernameField.setBounds(160, 80, 180, 25);

        passLabel = new JLabel("Password");
        passLabel.setBounds(50, 130, 100, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(160, 130, 180, 25);

        loginButton = new JButton("Login");
        loginButton.setBounds(160, 190, 100, 30);
        loginButton.addActionListener(this);

        add(titleLabel);
        add(userLabel);
        add(usernameField);
        add(passLabel);
        add(passwordField);
        add(loginButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if (username.equals("admin") && password.equals("admin123")) {

            JOptionPane.showMessageDialog(this, "Login Successful!");

            dispose();

            new Dashboard();

        } else {

            JOptionPane.showMessageDialog(this, "Invalid Username or Password!");

        }

    }

}