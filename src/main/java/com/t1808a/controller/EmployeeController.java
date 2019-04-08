package com.t1808a.controller;

import com.t1808a.entity.Employee;
import com.t1808a.model.EmployeeModel;

import java.util.Scanner;

public class EmployeeController {
    private EmployeeModel employeeModel = new EmployeeModel();
    Scanner scanner = new Scanner(System.in);

    public void register() {
        while (true) {
            System.out.println("Đăng ký tài khoản mới bằng cách điền đầy đủ những thông tin dưới đây.");
            System.out.println("Họ và tên: ");
            String name = scanner.nextLine();
            System.out.println("Địa chỉ: ");
            String address = scanner.nextLine();
            System.out.println("Email: ");
            String email = scanner.nextLine();
            System.out.println("Tài khoản đăng nhập: ");
            String account = scanner.nextLine();
            System.out.println("Mật khẩu: ");
            String password = scanner.nextLine();
//        System.out.println("Thời điểm tạo: ");
//        String createAt = scanner.nextLine();
//        System.out.println("Thời điểm cập nhật: ");
//        String updateAt = scanner.nextLine();
//        System.out.println("Trạng thái: ");
//        String status = scanner.nextLine();
            if (employeeModel.checkExisAccount(account)) {
                System.err.println("Tài khoản đã tồn tại, vui lòng thử lại.");
                System.out.println("---------------------------------------");
                System.out.println("---------------------------------------");
            } else {
                Employee employee = new Employee(name, address, email, name, address, email, account, password);
                employeeModel.register(employee);
                System.out.println("----------Đăng ký thành công!----------");
                System.out.println("---------------------------------------");
                return;
            }
        }
    }


    public void login() {
        System.out.println("----------Đăng nhập--------");
        System.out.println("Nhập tài khoản: ");
        String account = scanner.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        Employee employee = employeeModel.login(account, password);
        if (employee == null) {
            System.err.println("Sai tài khoản hoặc mật khẩu, vui lòng kiểm tra và đăng nhập lại!");
        } else {
            System.out.println("Đăng nhập thành công! Hiển thị thông tin tài khoản. ");
            System.out.println("Tên: " + employee.getName());
            System.out.println("Địa chỉ: " + employee.getAddress());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Tên tài khoản: " + employee.getAccount());
            System.out.println("Mật khẩu: " + employee.getPassword());
            System.out.println("Ngày tạo: " + employee.getCreateAt());
            System.out.println("Ngày cập nhật: " + employee.getUpdateAt());
            System.out.println("Trạng thái: " + employee.getStatus());
        }
    }


    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
