package com.yangshm.leecode;

public class _283_moveZeroes {

    public static void main(String[] args) {
        int[] nums = {0};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - count; i++) {
            int j = i + count;
            while (nums[j] == 0) {
                if (j < nums.length - 1) {
                    j++;
                    count++;
                } else {
                    break;
                }
            }
            nums[i] = nums[j];
        }
        for (int i = 0; i < count; i++) {
            nums[nums.length - 1 - i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0)
                count++;
            else if(count >0){
                nums[i-count] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
