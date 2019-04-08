package com.t1808a.utility;

import com.t1808a.controller.EmployeeController;

import java.util.Scanner;

public class MenuUtil {

    private EmployeeController employeeController = new EmployeeController();
    private Scanner scanner = new Scanner(System.in);

    public void generateEmployeeMenu(){
        while (true) {
            System.out.println("---------------- Menu -----------------");
            System.out.println("<1> Đăng ký.");
            System.out.println("<2> Đăng nhập.");
            System.out.println("<3> Thoát.");
            System.out.println("---------------------------------------");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    employeeController.register();
                    break;
                case 2:
                    employeeController.login();
                    break;
                case 3:
                    System.out.println("Trở lại menu.");
                    break;
                default:
                    System.out.println("Nhập sai nhập lại. Từ 1 => 3");
                    break;
            }
            if (choice == 3) {
                break;
            }
        }
    }
}
