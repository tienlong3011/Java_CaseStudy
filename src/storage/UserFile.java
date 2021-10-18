package storage;

import model.User;

import java.io.*;
import java.util.ArrayList;

public class UserFile {
    private static UserFile userFile;

    private UserFile() {
    }
    //Singleton
    public static UserFile getInstance(){
        if(userFile == null){
            userFile = new UserFile();
        }
        return userFile;
    }
    //đọc file
    public ArrayList<User> readFile() throws IOException, ClassNotFoundException {
        File file = new File("UserList.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<User> list = (ArrayList<User>)object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }

    //ghì file
    public void writeFile(ArrayList<User> users) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("UserList.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(users);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
