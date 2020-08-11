package com.yangshm.others;

import java.util.ArrayList;
import java.util.Collection;

public class ExceptionTest {

    public static void main(String[] args) throws ClassNotFoundException {
        String className = "com.yangshm.others.Test";
        System.out.println(Class.forName(className));
        System.out.println(className.getClass());


//        Class.forName(className).newInstance();
//        System.out.println( c);
//        factory = (ExampleInterface)c.newInstance();

//        Collection<Integer> list1 = new ArrayList<Integer>();
//        Collection<String> list2 = new ArrayList<String>();
//        Collection<Number> list3 = new ArrayList<Number>();
//        Collection<Object> list4 = new ArrayList<Object>();
//
//        getElement(list1);
//        getElement(list2);//报错
//        getElement(list3);
//        getElement(list4);//报错
//
//        getElement2(list1);//报错
//        getElement2(list2);//报错
//        getElement2(list3);
//        getElement2(list4);

    }

    // 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
    public static void getElement(Collection<? extends Number> coll) {
    }

    // 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
    public static void getElement2(Collection<? super Number> coll) {
    }
}

