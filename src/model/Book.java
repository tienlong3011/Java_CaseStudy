package model;

import java.io.Serializable;

public class Book implements Serializable {
    private String bookCode;
    private String bookName;
    private int quantity;
    private boolean status = true;

    public Book() {
    }

    public Book(String bookCode, String bookName, int quantity, boolean status) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.quantity = quantity;
        this.status = status;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "bookCode= " + bookCode +
                ", bookName= " + bookName +
                ", quantity= " + quantity +
                ", status= " + status
                ;
    }
}
