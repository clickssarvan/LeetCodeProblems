package com.app.leetcode;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */

public class TrappingRainWater {

    public int trapBruteForce(int[] height) {
        if (height == null || height.length < 3) {
            return 0; // Not enough walls to trap water
        }

        int n = height.length;
        int totalWater = 0;

        for (int i = 1; i < n - 1; i++) {
            int leftMax = 0, rightMax = 0;

            // Find the maximum height to the left of the current index
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Find the maximum height to the right of the current index
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // Water trapped at current index is the minimum of left and right max minus the height at that index
            totalWater += Math.max(0, Math.min(leftMax, rightMax) - height[i]);
        }

        return totalWater;
    }

    public int trapOptimized(int[] height) {
        if (height == null || height.length < 3) {
            return 0; // Not enough walls to trap water
        }

        int n = height.length;
        int totalWater = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = n - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //int[] height = {4,2,0,3,2,5};

        int waterBruteForce = solution.trapBruteForce(height);
        System.out.println("Water trapped (Brute Force): " + waterBruteForce); // Output: 6

        int waterOptimized = solution.trapOptimized(height);
        System.out.println("Water trapped (Optimized): " + waterOptimized); // Output: 6
    }
}
