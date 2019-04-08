package com.t1808a.model;

import com.t1808a.entity.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class EmployeeModel {

    private static Connection connection;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection =
                    DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/human_rescource?user=root&password=");
        }
    }


    public boolean register(Employee employee) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into employees ( name, address, email, account, password) values (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getAccount());
            preparedStatement.setString(5, employee.getPassword());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Có lỗi xảy ra khi tạo tài khoản. Vui lòng thử lại sau \nError: " + ex.getMessage());
        }
        return false;
    }

    public boolean checkExisAccount(String account) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from employees where account = ?");
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Có lỗi xảy ra. Vui lòng thử lại \nError: " + ex.getMessage());
            return false;
        }
        return false;
    }

    public Employee login(String account, String password) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from employees where account = ? and password = ?");
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                String address = resultSet.getString(2);
                String email = resultSet.getString(3);
                String accounts = resultSet.getString(4);
                String passwords = resultSet.getString(5);
                String createAt = resultSet.getString(6);
                String updateAt = resultSet.getString(7);
                String status = resultSet.getString(8);
                Employee employee = new Employee(name, address, email, accounts, passwords, createAt, updateAt, status);
                return employee;
            }
        } catch (Exception ex) {
            System.out.println("Có lỗi xảy ra. Vui lòng thử lại sau \nError: " + ex.getMessage());
        }
        return null;
    }
}
