package com.app.leetcode;

import java.util.HashMap;
import java.util.Map;

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]
// Constraints:
// 2 <= nums.length <= 10^4
// -10^9 <= nums[i] <= 10^9
// -10^9 <= target <= 10^9
// Only one valid answer exists.
// Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
public class TwoSum {

    /**
     * Finds two indices in the array such that the numbers at those indices add up to the target.
     * This solution has O(n^2) time complexity.
     *
     * @param nums   an array of integers
     * @param target the target sum
     * @return an array containing the two indices
     * @throws IllegalArgumentException if no solution is found
     * Quadratic time complexity solution.
     * This method iterates through each pair of numbers in the array to find the indices
     * that add up to the target.
     * This is a brute-force approach with O(n^2) time complexity.
     */

    public int[] twoSumSolution1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution");
    }

    /**
     * Finds two indices in the array such that the numbers at those indices add up to the target.
     *
     * @param nums   an array of integers
     * @param target the target sum
     * @return an array containing the two indices
     * @throws IllegalArgumentException if no solution is found
     * This method uses a HashMap to store the indices of the numbers
     * and checks for the complement of each number
     * to find the indices that add up to the target.
     * This is a more efficient solution with O(n) time complexity.
     * This method iterates through the array once,
     * storing each number and its index in a HashMap.
     * If the complement (target - current number) is found in the map,
     * it returns the indices of the current number and its complement.
     * This approach has O(n) time complexity,
     */

    public int[] twoSumSolution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }

    public int[] twoSumSolution3(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer complementIndex = complements.get(nums[i]);
            if (complementIndex != null) {
                System.out.println("HashMap Entry -> " + complements);
                return new int[]{complementIndex, i};
            }
            complements.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }

    /**
     * Main method to test the twoSum function.
     * It creates an instance of TwoSum and calls the twoSum method with a sample input.
     *
     * @param args command line arguments (not used)
     */
    // Example usage
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.twoSumSolution3(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        int[] nums1 = {2, 7, 11, 15, 10, 5, 3};
        int target1 = 5;
        int[] result1 = twoSum.twoSumSolution3(nums1, target1);
        System.out.println("Indices: [" + result1[0] + ", " + result1[1] + "]");

    }

}
