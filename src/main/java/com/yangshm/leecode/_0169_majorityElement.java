package com.yangshm.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _0169_majorityElement {

    private static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    private static int majorityElement2(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                Integer value = map.get(num);
                if (value + 1 > nums.length / 2) {
                    result = num;
                    break;
                } else {
                    map.put(num, value + 1);
                }
            } else {
                map.put(num, 1);
                result = num;
            }
        }
        return result;
    }
}
