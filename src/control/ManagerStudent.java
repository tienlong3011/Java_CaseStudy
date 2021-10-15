package control;

import model.Student;
import storage.StudentFile;

import java.io.IOException;
import java.util.ArrayList;

public class ManagerStudent {
    ArrayList<Student> studentArrayList = new ArrayList<>();

    public ManagerStudent() {
    }

    public ManagerStudent(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    ///thêm sinh viên
    public void addStudent(Student student) throws IOException {
        studentArrayList.add(student);
        StudentFile.writeFile(getStudentArrayList());
    }

    //sửa thông tin sinh viên theo code
    public void editStudent (String code, Student newStudent) throws IOException {
        Student student = searchStudentByCode(code);
        if(student != null){
            for (int i = 0; i < studentArrayList.size(); i++) {
                if(studentArrayList.get(i).equals(student)){
                    studentArrayList.set(i,newStudent);
                }
            }
        } else {
            System.out.println("Không tìm thấy sinh viên");
        }
        StudentFile.writeFile(getStudentArrayList());
    }

    //xóa thông tin sinh viên theo code
    public void removeStudent(String code) throws IOException {
        Student student = searchStudentByCode(code);
        if(student != null){
            for (int i = 0; i < studentArrayList.size(); i++) {
                if(studentArrayList.get(i).equals(student)){
                    studentArrayList.remove(i);
                }
            }
        } else {
            System.out.println("Không tìm thấy sinh viên");
        }
        StudentFile.writeFile(getStudentArrayList());
    }

    //showAll danh sách sinh viên
    public void showAllStudent(){
        for (Student student: studentArrayList) {
            System.out.println(student);
        }
    }

    //tìm kiếm sinh viên theo code ( trả về object)
    public Student searchStudentByCode(String code){
        for (Student student : studentArrayList) {
            if (student.getStudentCode().equalsIgnoreCase(code)) {
                return student;
            }
        }
       return null;
    }

    //tìm kiếm sinh viên theo code ( trả về index)
    public int searchIndexByCode(String code){
        for (Student student : studentArrayList) {
            if (student.getStudentCode().equalsIgnoreCase(code)) {
                return studentArrayList.indexOf(student);
            }
        }
        return -1;
    }
}
