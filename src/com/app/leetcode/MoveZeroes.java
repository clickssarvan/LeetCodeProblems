package com.app.leetcode;
/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]


Constraints:

        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1


Follow up: Could you minimize the total number of operations done?

 */

public class MoveZeroes {

    public void moveZeroesBruteForce(int[] nums) {
        int length  = nums.length;
        int nonZeroIndex = 0; // Pointer for the position of the next non-zero element
        // First pass: Move non-zero elements to the front
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }
        // Second pass: Fill the rest of the array with zeros
        for (int i = nonZeroIndex; i < length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroesTwoPointerApproach1(int[] nums) {

        int left =0;

        for(int right =0; right < nums.length; right++) {
            if(nums[right] != 0){ // If the current element is non-zero, swap it with the element at the left pointer
                if (left != right) { // Avoid unnecessary swap if pointers are the same
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                left++; // Move the left pointer to the next position
            }
        }
    }

    public void moveZeroesTwoPointerApproach2(int[] nums) {
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }

        // Fill remaining positions with zeros
        while(left < nums.length) {
            nums[left++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroesBruteForce(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 1 3 12 0 0
        System.out.println();

        moveZeroes.moveZeroesTwoPointerApproach1(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 1 3 12 0 0
        System.out.println();

        moveZeroes.moveZeroesTwoPointerApproach2(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 1 3 12 0 0
        System.out.println();


    }

}
