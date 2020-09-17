package com.yangshm.leecode;

import java.util.Arrays;
import java.util.Stack;

public class _0581_findUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    /**
     * 我们将数组 numsnums 进行排序，记为 nums\_sortednums_sorted 。然后我们比较 numsnums 和 nums\_sortednums_sorted 的元素来决定最左边和最右边不匹配的元素。它们之间的子数组就是要求的最短无序子数组。
     */
    public int findUnsortedSubarray1(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    /**
     * 这个方法背后的想法仍然是选择排序。我们需要找到无序子数组中最小元素和最大元素分别对应的正确位置，来求得我们想要的无序子数组的边界。
     * 为了达到这一目的，此方法中，我们使用 栈栈 。我们从头遍历 numsnums 数组，如果遇到的数字大小一直是升序的，我们就不断把对应的下标压入栈中，这么做的目的是因为这些元素在目前都是处于正确的位置上。一旦我们遇到前面的数比后面的数大，也就是 nums[j]nums[j] 比栈顶元素小，我们可以知道 nums[j]nums[j] 一定不在正确的位置上。
     * 为了找到 nums[j]nums[j] 的正确位置，我们不断将栈顶元素弹出，直到栈顶元素比 nums[j]nums[j] 小，我们假设栈顶元素对应的下标为 kk ，那么我们知道 nums[j]nums[j] 的正确位置下标应该是 k + 1k+1 。
     * 我们重复这一过程并遍历完整个数组，这样我们可以找到最小的 kk， 它也是无序子数组的左边界。
     * 类似的，我们逆序遍历一遍 numsnums 数组来找到无序子数组的右边界。这一次我们将降序的元素压入栈中，如果遇到一个升序的元素，我们像上面所述的方法一样不断将栈顶元素弹出，直到找到一个更大的元素，以此找到无序子数组的右边界。
     * 我们可以看下图作为参考。我们观察到上升还是下降决定了相对顺序，我们还可以观察到指针 bb 在下标 0 后面标记着无序子数组的左边界，指针 aa 在下标 7 前面标记着无序子数组的右边界。
     */
    public int findUnsortedSubarray2(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int left = 0;
//        int right = nums.length - 1;
//        for (int i = left; i < nums.length; i++) {
//            boolean flag = true;
//            for (int j = i; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                left++;
//            } else {
//                break;
//            }
//        }
//        for (int i = right; i >= 0; i--) {
//            boolean flag = true;
//            for (int j = i; j >= 0; j--) {
//                if (nums[i] < nums[j]) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                right--;
//            } else {
//                break;
//            }
//        }
//        return right - left + 1 < 0 ? 0 : right - left + 1;
    }

}
