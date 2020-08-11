package com.yangshm.leecode;

/**
 * 异或运算有以下三个性质。
 * <p>
 * 任何数和0做异或运算，结果仍然是原来的数，即a⊕0=a。
 * 任何数和其自身做异或运算，结果是0，即a⊕a=0。
 * 异或运算满足交换律和结合律。
 */
public class _136_singleNumber {

    private int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int num : nums) {
            singleNumber ^= num;
        }
        return singleNumber;
    }

}
