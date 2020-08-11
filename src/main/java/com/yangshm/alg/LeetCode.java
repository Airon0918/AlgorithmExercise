package com.yangshm.alg;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode {

    @Test
    public void test() {

    }

    //13. 罗马数字转整数
    public int romanToInt(String s) {
        int[] arr = new int[7];
        int len = s.length();
        String str = "";

        for (int i = 0; i < len; i++) {
            if (i < len - 1) {
                str = s.substring(i, i + 2);
            } else {
                str = "";
            }
            if ("IV".equals(str) || "IX".equals(str) || "XL".equals(str) || "XC".equals(str) || "CD".equals(str) || "CM".equals(str)) {
                i++;
            } else {
                str = s.substring(i, i + 1);
            }
            switch (str) {
                case "I":
                    arr[0]++;
                    break;
                case "V":
                    arr[1]++;
                    break;
                case "X":
                    arr[2]++;
                    break;
                case "L":
                    arr[3]++;
                    break;
                case "C":
                    arr[4]++;
                    break;
                case "D":
                    arr[5]++;
                    break;
                case "M":
                    arr[6]++;
                    break;
                case "IV":
                    arr[0] += 4;
                    break;
                case "IX":
                    arr[0] += 9;
                    break;
                case "XL":
                    arr[2] += 4;
                    break;
                case "XC":
                    arr[2] += 9;
                    break;
                case "CD":
                    arr[4] += 4;
                    break;
                case "CM":
                    arr[4] += 9;
                    break;
            }
        }
        return arr[6] * 1000 + arr[5] * 500 + arr[4] * 100 + arr[3] * 50 + arr[2] * 10 + arr[1] * 5 + arr[0];

    }

    //3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口
//        int res = 0;
//        int temp = 0;
//        int len = s.length();
//        String str;
//        int start = 0;
//        for (int i = 0; i < len; i++) {
//            str = s.substring(start, i);
//            int pos = str.indexOf(s.charAt(i));
//            if (pos >= 0) {
//                start = start + pos + 1;
//                if (res < temp) {
//                    res = temp;
//                }
//                temp = temp - pos - 1;
//            }
//            temp++;
//        }
//        return res > temp ? res : temp;

        //官方题解
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    //2. 两数相加
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    //1. 两数之和
    public int[] twoSum(int[] nums, int target) {
        //暴力求解
//        int pos[] = new int[2];
//        int len = nums.length;
//        for(int i = 0; i < len; i++){
//             for(int j = i + 1; j < len; j++){
//                 if(nums[i] + nums[j] == target){
//                     pos[0] = i;
//                     pos[1] = j;
//                     break;
//                 }
//             }
//        }

        //利用Hash求解
        int pos[] = new int[2];
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                pos[0] = map.get(target - nums[i]);
                pos[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return pos;
    }
}
