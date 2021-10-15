package model;

import java.io.Serializable;
import java.time.LocalDate;

public class LibraryCard implements Serializable {
    private Student student;
    private Book book;
    private LocalDate borrowedDate;
    private LocalDate payDate;


    public LibraryCard() {
    }

    public LibraryCard(Student student, Book book, LocalDate borrowedDate, LocalDate payDate) {
        this.student = student;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.payDate = payDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                student +
                ", " +
                book +
                ", borrowedDate= " + borrowedDate +
                ", payDate= " + payDate +
                '}';
    }
}
