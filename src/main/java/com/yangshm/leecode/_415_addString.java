package com.yangshm.leecode;

public class _415_addString {
    public String addStrings1(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

    public String addStrings2(String num1, String num2) {
        StringBuilder s = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : num1Char[i--] - '0';
            int y = j < 0 ? 0 : num2Char[j--] - '0';
            int sum = x + y + carry;
            s.append(sum % 10);//添加到字符串尾部
            carry = sum / 10;
        }
        return s.reverse().toString();//对字符串反转
    }

    public static String addStrings3(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int len1 = num1.length() - 1, len2 = num2.length() - 1, add = 0;

        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        while (len1 >= 0 || len2 >= 0 || add != 0) {
            int x = len1 < 0 ? 0 : arr1[len1--] - '0';
            int y = len2 < 0 ? 0 : arr2[len2--] - '0';
            int sum = x + y + add;
            result.append(sum % 10);
            add = sum / 10;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        addStrings3("0", "9");
    }
}
