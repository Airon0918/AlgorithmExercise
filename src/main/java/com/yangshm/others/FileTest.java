package com.yangshm.others;

import java.io.*;
import java.util.HashMap;

public class FileTest {
    public static void main(String[] args) {
//        try {
//            serialize();
//        } catch (Exception e) {
//
//        }

//        String str = "aaa";
//        String a = str + 1;
//        String b = str + 1;
//        System.out.println(a == b);//false

//        short s = 1;
//        s=s+1;
//        s+=1;
//        System.out.println(s);

//        byte b1=1;
//        byte b2=2;
//        byte b3=1 + 2;
//        byte b4=b2 + b3;
//        System.out.println(b3);
//        System.out.println(b4);

//        int a = 0;
//        for (int i = 0; i >= a && i < 100; i++) {
//            a += i;
//        }
//        System.out.println(a);

//        int x = 4;
//        System.out.println("value  is  " + ((x > 4) ? 99.9 : 9));

        int i = 1;
        int j = ++i;
        System.out.println(i);
        System.out.println(j);

    }

    public static void serialize() throws IOException {
        Employee e = new Employee();
        e.name = "11";
        e.address = "sad";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("E:/testdata/e.txt"));
        out.writeObject(e);
        out.close();
    }

    public static void buffered() throws IOException {
        HashMap<String, String> lineMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("E:/testdata/c.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("E:/testdata/d.txt"));

        String line = null;

        while ((line = reader.readLine()) != null) {
            String[] split = line.split("\\.");
            lineMap.put(split[0], split[1]);
        }
        reader.close();

        for (int i = 1; i <= lineMap.size(); i++) {
            String key = String.valueOf(i);
            String value = lineMap.get(key);
            writer.write(key + "." + value);
            writer.newLine();
        }
        writer.close();
    }

    public static void bufferedStream() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:/testdata/a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:/testdata/b.txt"));

        int len;
//        while ((len = bis.read()) != -1) {
//            bos.write(len);
//        }
        byte[] arr = new byte[1024];
        while ((len = bis.read(arr)) != -1) {
            bos.write(arr, 0, len);
        }
        bis.close();
        bos.close();
    }
}

class Employee implements java.io.Serializable {
    public String name;
    public String address;
    public transient int age; // transient瞬态修饰成员,不会被序列化

    public void addressCheck() {
        System.out.println("Address  check : " + name + " -- " + address);
    }
}