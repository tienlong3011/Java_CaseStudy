package veiw;

import control.ManagerBook;
import control.ManagerLibraryCard;
import control.ManagerStudent;
import storage.BookFile;
import storage.LibraryCardFile;
import storage.StudentFile;

import java.io.IOException;
import java.util.Scanner;

public class MenuStudentManager {
    private MenuStudentManager() {
    }

    public static MenuStudentManager getInstance() {
        return MenuStudentManager.MenuManagerStudentHelper.INSTANCE;
    }

    private static class MenuManagerStudentHelper{
        private static final MenuStudentManager INSTANCE = new MenuStudentManager();
    }

    public void runMenuStudent() {
        ManagerBook managerBook = ManagerBook.getInstance();
        ManagerLibraryCard managerLibraryCard = ManagerLibraryCard.getInstance();
        ManagerStudent managerStudent = ManagerStudent.getInstance();
        //đọc file học sinh
        try {
            managerStudent.setStudentArrayList(StudentFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        LibraryCardMenuWithManagerLibraryCard libraryCardMenuWithManagerLibraryCard = LibraryCardMenuWithManagerLibraryCard.getInstance();
        Scanner number = new Scanner(System.in);
        //Đọc file book
        try {
            managerBook.setBookArrayList(BookFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Đọc thẻ thư viện
        try {
            managerLibraryCard.setLibraryCardArrayList(LibraryCardFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //đọc file student


        int choice = -1;


        while (choice != 0){
            System.out.println("--------Trang trủ--------");
            System.out.println("1. Mượn Sách");
            System.out.println("2. Trả sách");
            System.out.println("3. Danh sách sách trong thư viện");
            System.out.println("0. Quay lại");

            choice = number.nextInt();
            switch (choice){
                case 1:
                    libraryCardMenuWithManagerLibraryCard.borrowBooks();
                    break;
                case 2:
                    libraryCardMenuWithManagerLibraryCard.giveBookBack();
                    break;
                case 3:
                    managerBook.showAllBook();
                    break;
                case 0:
            }
        }

    }
}
