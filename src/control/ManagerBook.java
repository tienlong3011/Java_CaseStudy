package control;

import model.Book;
import storage.BookFile;

import java.io.IOException;
import java.util.ArrayList;

public class ManagerBook {
    ArrayList<Book> bookArrayList = new ArrayList<>();
    BookFile bookFile = BookFile.getInstance();
    public ManagerBook() {
    }

    public ManagerBook(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    ///thêm sách
    public void addBook(Book student) throws IOException {
        bookArrayList.add(student);
        bookFile.writeFile(bookArrayList);
    }


    //sửa thông tin sách theo code
    public void editStudent (String code, Book newBook) throws IOException {
        Book book = searchBookByCode(code);
        if(book != null){
            for (int i = 0; i < bookArrayList.size(); i++) {
                if(bookArrayList.get(i).equals(book)){
                    bookArrayList.set(i,newBook);
                }
            }
        } else {
            System.out.println("Không tìm thấy sách");
        }
        bookFile.writeFile(bookArrayList);
    }

    //xóa sách theo code
    public void removeBook(String code) throws IOException {
        Book book = searchBookByCode(code);
        if(book != null){
            for (int i = 0; i < bookArrayList.size(); i++) {
                if(bookArrayList.get(i).equals(book)){
                    bookArrayList.remove(i);
                }
            }
        } else {
            System.out.println("Không tìm thấy sách");
        }
        bookFile.writeFile(bookArrayList);
    }

    //showAll danh sách sách
    public void showAllBook(){
        for (Book book: bookArrayList) {
            System.out.println(book);
        }
    }


    //tìm kiếm sách theo code ( trả về object)
    public Book searchBookByCode(String code){
        for (Book book : bookArrayList) {
            if (book.getBookCode().equalsIgnoreCase(code)) {
                return book;
            }
        }
        return null;
    }



}
