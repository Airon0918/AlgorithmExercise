package com.yangshm.others;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexTest {

    private static Pattern templatePattern = Pattern.compile("\\{(\\w+)}");

    public static void main(String[] args) {

//        String regex = "\\d{4}-\\d{2}-\\d{2}";
//        Pattern pattern = Pattern.compile(regex);
//        String str = "1111-22-33aaaaaaaa2222-33-44";
//        Matcher matcher = pattern.matcher(str);
//        while (matcher.find()) {
//            System.out.println(matcher.group(0) + " " + matcher.group(1));
//        }

//        String regex = "(\\d{4})-(\\d{2})-(\\d{2})";
//        String str = "1111-11-11";
//        System.out.println(str.replaceAll(regex, "$1/$2/$3"));

//        String regex = "}";
//        String str = "}}}";
//        System.out.println(str.replaceAll(regex, "$0/"));

//        String template = "编码：{code}，名称：{name}";
//        Map<String, Object> params = new HashMap<>();
//        params.put("code", "qwe");
//        params.put("name", "123");
//        System.out.println(templateEngin(template, params));
        List<String> oldList = Arrays.asList(new String[]{"aaa", "bbb", "cc"});
        List<String> newList = new ArrayList<>();
        newList = oldList.stream().filter(t -> t.length() > 2).collect(Collectors.toList());
        System.out.println(newList);

    }

    public static String templateEngin(String template, Map<String, Object> params) {
        StringBuffer sb = new StringBuffer();
        Matcher matcher = templatePattern.matcher(template);
        while (matcher.find()) {
            String key = matcher.group(1);
            Object value = params.get(key);
            matcher.appendReplacement(sb, value != null ? Matcher.quoteReplacement(value.toString()) : "");
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

}
