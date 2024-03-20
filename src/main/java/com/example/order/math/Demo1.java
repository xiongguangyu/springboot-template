package com.example.order.math;

import java.util.HashMap;

/**
 * 两数之和
 */
public class Demo1 {

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 9, 8};
        int target = 10;
        int[] ints1 = twoSum1(nums, target);
        int[] ints2 = twoSum2(nums, target);
        System.out.println();
    }

    public static int[] twoSum1(int[] nums, int target) {
        int a = nums.length;
        for (int i = 0; i < a; i++) {
            for (int j = i + 1; j < a; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }

}
