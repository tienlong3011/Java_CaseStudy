package model;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String studentCode;
    private String yearOfBirth;
    private String class1;

    public Student() {
    }

    public Student(String name, String studentCode, String yearOfBirth, String class1) {
        this.name = name;
        this.studentCode = studentCode;
        this.yearOfBirth = yearOfBirth;
        this.class1 = class1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    @Override
    public String toString() {
        return "name= " + name +
                ", studentCode= " + studentCode +
                ", dateOfBirth= " + yearOfBirth +
                ", class= " + class1
                ;
    }
}
