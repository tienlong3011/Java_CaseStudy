package model;

import java.io.Serializable;

public class User implements Serializable {
    private String account;
    private String passWord;
    private String role;

    public User() {
    }

    public User(String account, String passWord, String role) {
        this.account = account;
        this.passWord = passWord;
        this.role = role;
    }

    public User(String account, String passWord) {
        this.account = account;
        this.passWord = passWord;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
