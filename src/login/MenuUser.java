package login;

import control.ManagerUser;

import model.User;
import storage.UserFile;
import veiw.MenuManager;

import java.io.IOException;
import java.util.Scanner;

public class MenuUser {
    ManagerUser managerUser = new ManagerUser();
    Scanner string = new Scanner(System.in);
    private static final MenuManager MENU_MANAGER = MenuManager.getInstance();

    public void runUser() {
        try {
            managerUser.setUserArrayList(UserFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Scanner number = new Scanner(System.in);


        int choice = -1;


        while (true) {
            System.out.println("----------HỆ THỐNG QUẢN TRỊ VIÊN----------");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("0. Thoát");

            choice = number.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("ĐĂNG NHẬP");
                    System.out.print("Tài khoản : ");
                    String userName = string.nextLine();
                    System.out.print("Mật khẩu : ");
                    String password = string.nextLine();
                    User userLogin = new User(userName, password);
                    if(managerUser.isLogin(userLogin)){
                        MENU_MANAGER.runMenu();
                    } else {
                        System.out.println("Tài khoản hoặc mật khẩu chưa chính xác!");
                    }
                    break;
                case 2:
                    managerUser.addNewUser(creatUser());
                    System.out.println("Tạo tài khoản thành công");
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    private static User creatUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên đăng nhập: ");
        String user = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String passWord = scanner.nextLine();
        return new User(user,passWord);
    }
}
