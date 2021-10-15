package control;


import model.LibraryCard;
import model.Student;
import storage.LibraryCardFile;


import java.io.IOException;
import java.util.ArrayList;

public class ManagerLibraryCard {
    ArrayList<LibraryCard> libraryCardArrayList = new ArrayList<>();
    ManagerStudent managerStudent = new ManagerStudent();

    public ManagerLibraryCard() {
    }

    public ManagerLibraryCard(ArrayList<LibraryCard> libraryCardArrayList, ManagerStudent managerStudent) {
        this.libraryCardArrayList = libraryCardArrayList;
        this.managerStudent = managerStudent;
    }

    public ArrayList<LibraryCard> getLibraryCardArrayList() {
        return libraryCardArrayList;
    }

    public void setLibraryCardArrayList(ArrayList<LibraryCard> libraryCardArrayList) {
        this.libraryCardArrayList = libraryCardArrayList;
    }

    public ManagerStudent getManagerStudent() {
        return managerStudent;
    }

    public void setManagerStudent(ManagerStudent managerStudent) {
        this.managerStudent = managerStudent;
    }

    //thêm card theo code
    //xử lý phần LibraryCard libraryCard
    public void addLibraryCard(String code, LibraryCard newLibraryCard) throws IOException {
        Student student = managerStudent.searchStudentByCode(code);
        if (student != null) {
            libraryCardArrayList.add(newLibraryCard);
        } else {
            System.out.println("Không tìm thấy sinh viên");
        }
        LibraryCardFile.writeFile(getLibraryCardArrayList());
    }

    //sửa card theo code
    public void editLibraryCard(String code, LibraryCard newLibraryCard) throws IOException {
        Student student = managerStudent.searchStudentByCode(code);
           if (student != null) {
            for (int i = 0; i < libraryCardArrayList.size(); i++) {
                if (libraryCardArrayList.get(i).getStudent().equals(student)) {
                    libraryCardArrayList.set(i, newLibraryCard);
                }
            }
        } else {
            System.out.println("Không tìm thấy sinh viên");
        }
        LibraryCardFile.writeFile(getLibraryCardArrayList());
    }

    //xóa card theo code
    public void removeLibraryCard(String code) throws IOException {
        Student student = managerStudent.searchStudentByCode(code);
        if (student != null) {
            for (int i = 0; i < libraryCardArrayList.size(); i++) {
                if (libraryCardArrayList.get(i).getStudent().equals(student)) {
                    libraryCardArrayList.remove(i);
                }
            }
        } else {
            System.out.println("Không tìm thấy sinh viên");
        }
        LibraryCardFile.writeFile(getLibraryCardArrayList());
    }

    //showAll danh sách card
    public void showAllLibraryCard(){
        for (LibraryCard libraryCard: libraryCardArrayList) {
            System.out.println(libraryCard);
        }
    }

    //tìm kiếm card theo code
    public LibraryCard searchLibraryCardByCodeStudent(String code){
        Student student = managerStudent.searchStudentByCode(code);
        for (LibraryCard libraryCard : libraryCardArrayList) {
            if (libraryCard.getStudent().equals(student)) {
                return libraryCard;
            }
        }
        return null;
    }
}
