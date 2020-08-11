package com.yangshm.others;

import org.junit.Test;

public class InheritTest {
    @Test
    public void test() {
        Child c = new Child();
        c.addAll(new int[]{1, 2, 3});
        System.out.println(c.getSum());
    }

    class Base {
        private static final int MAX_NUM = 100;
        private int[] arr = new int[MAX_NUM];
        int count;

        public void add(int num) {
            if (count < MAX_NUM) {
                arr[count++] = num;
            }
        }

        public void addAll(int[] nums) {
            for (int num : nums) {
                add(num);
            }
        }
    }

    class Child extends Base {
        private long sum;

        @Override
        public void add(int num) {
            super.add(num);
            sum+=num;
        }

        @Override
        public void addAll(int[] nums) {
            super.addAll(nums);
            for (int num : nums) {
                sum += num;
            }
        }

        public long getSum() {
            return sum;
        }
    }
}
