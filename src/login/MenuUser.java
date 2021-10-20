package login;

import control.ManagerLibraryCard;
import control.ManagerUser;

import model.User;
import storage.UserFile;
import veiw.MenuAdminManager;
import veiw.MenuStudentManager;

import java.io.IOException;
import java.util.Scanner;

public class MenuUser {
    ManagerUser managerUser = ManagerUser.getInstance();

    Scanner string = new Scanner(System.in);
    private static final MenuAdminManager MENU_MANAGER = MenuAdminManager.getInstance();
    private static final MenuStudentManager MENU_STUDENT_MANAGER = MenuStudentManager.getInstance();
    private static final String STUDENT = "Student";
    private static final String ADMIN = "Admin";


    public void runUser() {
        try {
            managerUser.setUserArrayList(UserFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        userAdmin();
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
                    isLogin();
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

    private void userAdmin() {
        managerUser.addNewUser(new User("admin", "admin", ADMIN));
    }

    private void isLogin() {
        System.out.println("ĐĂNG NHẬP");
        System.out.print("Tài khoản : ");
        String userName = string.nextLine();
        System.out.print("Mật khẩu : ");
        String password = string.nextLine();
        User userLogin = new User(userName, password);
        boolean isLogin = managerUser.isLogin(userLogin);
        if (isLogin) {
            User user = managerUser.findUser(userName);
            if (user.getRole().equalsIgnoreCase(ADMIN)) {
                MENU_MANAGER.runMenuAdmin();
            } else {
                MENU_STUDENT_MANAGER.runMenuStudent();
            }
        } else {
            System.out.println("TÀI KHOẢN HOẶC MẬT KHẨU KHÔNG ĐÚNG VUI LÒNG THỬ LẠI!");
        }
    }

    private static User creatUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên đăng nhập: ");
        String user = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String passWord = scanner.nextLine();
        return new User(user, passWord, "Student");
    }
}
