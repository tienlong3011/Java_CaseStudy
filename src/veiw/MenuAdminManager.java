package veiw;

import control.ManagerUser;
import model.User;

import java.util.Scanner;

public class MenuAdminManager {

    private MenuAdminManager() {
    }

    public static MenuAdminManager getInstance() {
        return MenuAdminManager.MenuManagerHelper.INSTANCE;
    }

    private static class MenuManagerHelper{
        private static final MenuAdminManager INSTANCE = new MenuAdminManager();
    }
    public void runMenuAdmin() {
        StudentMenuWithManagerStudent studentMenuWithManagerStudent = StudentMenuWithManagerStudent.getInstance();
        BookMenuWithManagerBook bookMenuWithManagerBook = BookMenuWithManagerBook.getInstance();
        LibraryCardMenuWithManagerLibraryCard libraryCardMenuWithManagerLibraryCard = LibraryCardMenuWithManagerLibraryCard.getInstance();
        ManagerUser managerUser = ManagerUser.getInstance();
        Scanner number = new Scanner(System.in);


        int choice = -1;


        while (choice != 0){
            System.out.println("--------Trang trủ--------");
            System.out.println("1. Quản lý sinh viên");
            System.out.println("2. Quản lý sách");
            System.out.println("3. Quản lý thẻ thư viện");
            System.out.println("4. Đăng ký tài khoản");
            System.out.println("0. Quay lại");

            choice = number.nextInt();
            switch (choice){
                case 1:
                    studentMenuWithManagerStudent.runStudent();
                    break;
                case 2:
                    bookMenuWithManagerBook.runBook();
                    break;
                case 3:
                    libraryCardMenuWithManagerLibraryCard.runLibraryCard();
                    break;
                case 4:
                    managerUser.addNewUser(creatUser());
                case 0:
            }
        }

    }

    private User creatUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên đăng nhập: ");
        String user = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String passWord = scanner.nextLine();
        System.out.print("Quyền đăng nhập(ADMIN, STUDENT): ");
        String role = scanner.nextLine();
        return new User(user, passWord, role);
    }
}
