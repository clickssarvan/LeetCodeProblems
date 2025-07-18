package com.app.leetcode;

/*
Given an integer x, return true if x is a palindrome, and false otherwise.



        Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
        Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Constraints:

        -231 <= x <= 231 - 1


Follow up: Could you solve it without converting the integer to a string?
*/
public class PalindromeNumber {

    /**
     * Determines if a given integer is a palindrome.
     * A palindrome reads the same backward as forward.
     *
     * @param x the integer to check
     * @return true if x is a palindrome, false otherwise
     * This method checks if the integer is negative or ends with a zero (except for zero itself),
     * which cannot be palindromes.
     * It then reverses the integer by extracting its digits and comparing the reversed half with the original half.
     * This approach avoids converting the integer to a string and operates in O(log10(n)) time complexity,
     * where n is the value of the integer.
     * This solution is efficient and works for both positive and negative integers.
     * It handles edge cases such as negative numbers and numbers ending with zero.
     * This method uses a mathematical approach to reverse the digits of the integer
     * without converting it to a string.
     * This is an efficient solution with O(log10(n)) time complexity,
     * where n is the value of the integer.
     *
     */

    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        // Also, numbers ending with 0 (except for 0 itself) cannot be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while(x > reversedHalf) {
            // Get the last digit and add it to the reversed half
            reversedHalf = reversedHalf * 10 + x % 10;
            // Remove the last digit from x
            x = x/10;
        }
        // Check if the original number is equal to the reversed half
        // or if the original number is equal to the reversed half without the last digit (for odd length numbers)
        return x == reversedHalf || x == reversedHalf / 10;

    }


    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        // Test cases
        System.out.println(palindromeNumber.isPalindrome(121));  // true
        System.out.println(palindromeNumber.isPalindrome(-121)); // false
        System.out.println(palindromeNumber.isPalindrome(10));   // false
        System.out.println(palindromeNumber.isPalindrome(12321)); // true
    }
}
