package veiw;

import control.ManagerBook;
import control.ManagerLibraryCard;
import control.ManagerStudent;
import model.Book;
import model.LibraryCard;


import java.time.LocalDate;
import java.util.Scanner;

public class LibraryCardMenuWithManagerLibraryCard {

    ManagerBook managerBook = ManagerBook.getInstance();
    ManagerStudent managerStudent = ManagerStudent.getInstance();
    ManagerLibraryCard managerLibraryCard = new ManagerLibraryCard();
    final static  Scanner scanner = new Scanner(System.in); //String
    final static  Scanner scanner1 = new Scanner(System.in); //int

    LibraryCard libraryCard = new LibraryCard();
    public void runLibraryCard(){

        Scanner number = new Scanner(System.in);


        int choice = -1;

        while (choice != 0){
            System.out.println("--------Quản lý thẻ thư viện--------");
            System.out.println("1. Thêm thẻ thư viện");
            System.out.println("2. Xóa thẻ thử viện");
            System.out.println("3. Tìm kiếm thẻ thư viện theo mã sinh viên");
            System.out.println("4. Danh sách thẻ thư viện");
            System.out.println("5. Mượn sách");
            System.out.println("6. Trả sách");
            System.out.println("0. Quay lại");

            choice = number.nextInt();

            switch (choice){
                case 1:
                    addLibraryCard(managerLibraryCard);
                    break;
                case 2:
                    removeLibraryCard(managerLibraryCard);
                    break;
                case 3:
                    searchCard();
                    break;
                case 4:
                    managerLibraryCard.showAllLibraryCard();
                    break;
                case 5:
                     LibraryCard libraryCard = managerLibraryCard.searchLibraryCardByCodeStudent(inputCode());
                    if (libraryCard != null ) {
                        if (libraryCard.getStudent().getBalance() >= 20) {
                            managerBook.showAllBook();
                            System.out.print("Nhập sách code sách: ");
                            String codeBook = scanner.nextLine();
                            Book book = managerBook.searchBookByCode(codeBook);
                            for (int i = 0; i < managerBook.getBookArrayList().size(); i++) {
                                if (managerBook.getBookArrayList().get(i).equals(book)) {
                                    libraryCard.setBook(managerBook.getBookArrayList().get(i));
                                    book.setQuantity(book.getQuantity() - 1);
                                }
                            }
                            libraryCard.setBorrowedDate(enterTheLoan());
                            System.out.print("Nhập số ngày cần mượn: ");
                            int borrowedDays = scanner1.nextInt();
                            libraryCard.setBorrowedDays(borrowedDays);
                            //nếu mượn lâu thì trừ nhiều tiền
                            if (borrowedDays <= 7) {
                                libraryCard.getStudent().setBalance(libraryCard.getStudent().getBalance() - 5);
                            } else if (borrowedDays <= 14) {
                                libraryCard.getStudent().setBalance(libraryCard.getStudent().getBalance() - 10);
                            } else if (borrowedDays <= 21) {
                                libraryCard.getStudent().setBalance(libraryCard.getStudent().getBalance() - 15);
                            } else {
                                libraryCard.getStudent().setBalance(libraryCard.getStudent().getBalance() - 20);
                            }

                            System.out.println("Mượn sách thành công");
                        }else {
                            System.out.println("Bạn không đủ tiền. Vui lòng nạp tiền để tiếp tục!");
                        }
                    }else {
                        System.out.println("Không có thẻ thư viện");
                    }
                    break;
                case 6:
//                    LibraryCard libraryCard1 = managerLibraryCard.searchLibraryCardByCodeStudent(inputCode());
//                    if(libraryCard != null){
//
//                    }
            }
        }
    }

    // tìm kiếm card
    private void searchCard() {
        LibraryCard libraryCard = managerLibraryCard.searchLibraryCardByCodeStudent(inputCode());
        if(libraryCard != null){
            System.out.println(libraryCard);
        } else {
            System.out.println("Không có thẻ thư viện");
        }
    }

    private void muonsach(LibraryCard libraryCard){
        if(libraryCard != null){
            managerBook.showAllBook();
            System.out.println("Nhập sách code sách");
            String codeBook = scanner.nextLine();
            for (int i = 0; i < managerBook.getBookArrayList().size(); i++) {
                if(managerBook.getBookArrayList().get(i).getBookCode().equalsIgnoreCase(codeBook)){
//                    libraryCard.getBook().add(managerBook.getBookArrayList().get(i));
                    libraryCard.setBorrowedDate(LocalDate.of(2020,10,17));
//                    libraryCard.setPayDate(LocalDate.of(2020,12,17));
                }
            }
        }
        else {
            System.out.println("không thấy");
        }
        managerLibraryCard.showAllLibraryCard();
    }



    //xóa thẻ
    private void removeLibraryCard(ManagerLibraryCard managerLibraryCard) {
            managerLibraryCard.removeLibraryCard(inputCode());
    }


    //tạo card
    private void addLibraryCard(ManagerLibraryCard managerLibraryCard) {
            managerLibraryCard.addLibraryCard(inputCode());
    }

    //nhập code sinh viên
    private String inputCode() {
        System.out.print("Nhập code sinh viên: ");
        Scanner string = new Scanner(System.in);
        return string.nextLine();

    }

    //thêm ngày mượn
    public static LocalDate enterTheLoan() {
        System.out.print("Năm mượn: ");
        Scanner number = new Scanner(System.in);
        int year = number.nextInt();
        System.out.print("Tháng mượn: ");
        int month = number.nextInt();
        System.out.print("Ngày mượn: ");
        int day = number.nextInt();
        return LocalDate.of(year, month, day);
    }
}
