package veiw;

import control.ManagerStudent;
import model.Student;

import java.io.IOException;
import java.util.Scanner;

public class StudentMenuWithManagerStudent {
    public void runStudent(){
        Scanner number = new Scanner(System.in);
        ManagerStudent managerStudent = new ManagerStudent();

        int choice = -1;

        while (choice != 0){
            System.out.println("--------Quản lý sinh viên--------");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Tìm kiếm theo mã sinh viên");
            System.out.println("5. Dách sách sinh viên");
            System.out.println("0. Quay lại");

            choice = number.nextInt();

            switch (choice){
                case 1:
                    inputStudent(managerStudent);
                    break;
                case 2:
                    editStudent(managerStudent);
                    break;
                case 3:
                    removeStudent(managerStudent);
                    break;
                case 4:
                    managerStudent.searchStudentByCode(inputCode());
                    break;
                case 5:
                    managerStudent.showAllStudent();
                    break;
                case 0:
            }
        }
    }

    //xóa sinh viên
    private void removeStudent(ManagerStudent managerStudent) {
        try {
            managerStudent.removeStudent(inputCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //sửa thông tin
    private void editStudent(ManagerStudent managerStudent) {
        try {
            managerStudent.editStudent(inputCode(),addStudent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //tạo mới sinh viên
    private void inputStudent(ManagerStudent managerStudent) {
        try {
            managerStudent.addStudent(addStudent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Student addStudent() {
        Scanner string = new Scanner(System.in);
        String nameStudent;
        String yearOfBirth;
        String codeStudent;
        String class1;
        System.out.print("Nhập tên sinh viên: ");
        nameStudent = string.nextLine();
        System.out.print("Nhập mã sinh viên: ");
        codeStudent = string.nextLine();
        System.out.print("Nhập năm sinh: ");
        yearOfBirth = string.nextLine();
        System.out.print("Nhập tên lớp: ");
        class1 = string.nextLine();
        return new Student(nameStudent,codeStudent,yearOfBirth,class1);
    }

    //nhập code sinh viên
    private String inputCode() {
        System.out.print("Nhập code sinh viên: ");
        Scanner string = new Scanner(System.in);
        return string.nextLine();

    }
}
