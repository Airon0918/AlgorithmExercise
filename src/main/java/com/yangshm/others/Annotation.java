package com.yangshm.others;

import lombok.Data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Annotation {
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Label {
        String value() default "";
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Format {
        String pattern() default "yyyy-MM-dd HH:mm:ss";

        String timezone() default "GMT+8";
    }

    @Data
    static class Student {
        @Label("姓名")
        String name;
        @Label("日期")
        @Format(pattern = "yyyy/MM/dd")
        Date born;
        @Label("分数")
        double score;

        public Student(String name, Date born, double score) {
            this.name = name;
            this.born = born;
            this.score = score;
        }
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Student student = new Student("JOJO", sdf.parse("1990-11-11"), 80.0d);

    }
}
