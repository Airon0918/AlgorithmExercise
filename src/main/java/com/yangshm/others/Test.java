package com.yangshm.others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
//        Father father = new Son();
//        father.getName();
//        EatKaoShanYao k = new KaoShanYao("250斤");


        String line = "000AAA";
        String pattern = "(\\d*)";
        line.replaceAll(pattern, "");
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);


    }

}

class Father {
    private String name;

    public Father getName() {
        System.out.println("Fahter");
        return new Father();
    }
}

class Son extends Father {
    @Override
    public Son getName() {
        System.out.println("Son");
        return new Son();
    }
}


class EatKaoShanYao {
    EatKaoShanYao() {
        System.out.println("吃烤山药之前...");
        eat();
        System.out.println("吃烤山药之后(熊孩子懵逼中)....");
    }

    public void eat() {
        System.out.println("7岁半就喜欢吃烤山药");
    }
}

class KaoShanYao extends EatKaoShanYao {
    private String Weight = "110斤";

    public KaoShanYao(String Weight) {
        this.Weight = Weight;
        System.out.println("熊孩子的体重：" + this.Weight);
    }

    @Override
    public void eat() { // 子类覆盖父类方法
        System.out.println("熊孩子吃烤山药之前的体重是：" + this.Weight);
    }


}
