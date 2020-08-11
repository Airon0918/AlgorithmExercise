package com.yangshm.others;

import java.io.*;

class UserInfo implements Serializable {
    private String name;
    private transient Integer password;

    public UserInfo(String name, Integer psw) {
        this.name = name;
        this.password = psw;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "name='" + name + '\'' + ", password='" + password + '\'' + '}';
    }
}

public class TransientTest {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("Airon", 1);
        System.out.println("UserInfo:" + userInfo);

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("E:/testdata/transient1.txt"));
            output.writeObject(userInfo);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("E:/testdata/transient1.txt"));
            Object obj = input.readObject();
            System.out.println(obj);
            input.close();
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }


    }
}
