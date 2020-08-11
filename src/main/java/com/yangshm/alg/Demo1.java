package com.yangshm.alg;

public class Demo1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.aplusb(1111, 2222);
    }
}

class Solution {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here
        int result = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0) {
            a = result ^ carry;
            carry = (result & carry) << 1;
            result = a;
        }
        return result;
    }
}

class Multiply {

    public static Double multiply(Double a, Double b) {
        return a * b;
    }
}

class TenMinWalk {
    public static boolean isValid(char[] walk) {
        // Insert brilliant code here

        int len = walk.length;
        if(len == 10){
            int n = 0, s = 0, w = 0, e = 0;
            for(int i = 0; i< len; i++){
                switch(walk[i]){
                    case 'n':
                        n++;
                        break;
                    case 's':
                        s++;
                        break;
                    case 'w':
                        w++;
                        break;
                    case 'e':
                        e++;
                        break;
                }



            }

            if(n == s && w == e)
                return true;


        }
        return false;

    }
}