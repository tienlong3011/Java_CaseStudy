package control;

import model.User;
import storage.StudentFile;
import storage.UserFile;

import java.io.IOException;
import java.util.ArrayList;

public class ManagerUser {
    ArrayList <User> userArrayList = new ArrayList<>();
    UserFile userFile = UserFile.getInstance();
    public ManagerUser() {
    }

    public ManagerUser(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public void addNewUser(User user) {
        userArrayList.add(user);
        try {
            userFile.writeFile(userArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(int index) {
        userArrayList.remove(index);
    }

    public void editUser(int index, User user) {
        userArrayList.set(index, user);
    }

//    public int findIndex(String username) {
//        int index = -1;
//        for (int i = 0; i < userArrayList.size(); i++) {
//            if (username.equals(userArrayList.get(i).getAccount())) {
//                index = i;
//                break;
//            }
//        }
//        return index;
//    }

    public boolean isLogin(User userLogin) {
        for (User user : userArrayList) {
            if (user.getAccount().equals(userLogin.getAccount())
                    && user.getPassWord().equals(userLogin.getPassWord())) {
                return true;
            }
        }
        return false;
    }
}
