package veiw;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        StudentMenuWithManagerStudent studentMenuWithManagerStudent = new StudentMenuWithManagerStudent();
        BookMenuWithManagerBook bookMenuWithManagerBook = new BookMenuWithManagerBook();
        LibraryCardMenuWithManagerLibraryCard libraryCardMenuWithManagerLibraryCard = new LibraryCardMenuWithManagerLibraryCard();
        Scanner number = new Scanner(System.in);

        int choice = -1;


        while (choice != 0){
            System.out.println("--------Trang trủ--------");
            System.out.println("1. Quản lý sinh viên");
            System.out.println("2. Quản lý sách");
            System.out.println("3. Quản lý thẻ thư viện");
            System.out.println("4. Exit");

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
            }
        }

    }
}
