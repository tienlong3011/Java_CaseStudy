package veiw;

import control.ManagerBook;
import model.Book;

import java.io.IOException;
import java.util.Scanner;

public class BookMenuWithManagerBook {
    public void runBook(){
        Scanner number = new Scanner(System.in);
        ManagerBook managerBook = new ManagerBook();

        int choice = -1;

        while (choice != 0){
            System.out.println("--------Quản lý sách thư viện--------");
            System.out.println("1. Thêm sách");
            System.out.println("2. Sửa thông tin sách");
            System.out.println("3. Xóa sinh sách");
            System.out.println("4. Tìm kiếm theo mã sách");
            System.out.println("5. Dách sách Sách");
            System.out.println("0. Quay lại");

            choice = number.nextInt();

            switch (choice){
                case 1:
                    inputBook(managerBook);
                    break;
                case 2:
                    editBookByCode(managerBook);
                    break;
                case 3:
                    removeBookByCode(managerBook);
                    break;
                case 4:
                    managerBook.searchBookByCode(inputCode());
                    break;
                case 5:
                    managerBook.showAllBook();
                    break;
                case 0:
            }
        }

    }

    //xóa sách
    private void removeBookByCode(ManagerBook managerBook) {
        try {
            managerBook.removeBook(inputCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //sửa sách theo code
    private void editBookByCode(ManagerBook managerBook) {
        try {
            managerBook.editStudent(inputCode(),addBook());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //thêm sách
    private void inputBook(ManagerBook managerBook) {
        try {
            managerBook.addBook(addBook());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Book addBook() {
        Scanner string = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);
        String bookCode, bookName;
        int quantity;
        System.out.print("Nhập mã sách: ");
        bookCode = string.nextLine();
        System.out.print("Nhập tên sách: ");
        bookName = string.nextLine();
        System.out.print("Nhập số lượng sách: ");
        quantity = inputNumber.nextInt();
        return new Book(bookCode, bookName,quantity,true);
    }

    //nhập code sách
    private String inputCode() {
        System.out.print("Nhập code sách: ");
        Scanner string = new Scanner(System.in);
        return string.nextLine();
    }

}
