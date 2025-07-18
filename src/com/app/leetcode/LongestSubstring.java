package com.app.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 Longest Substring Without Repeating Characters
 Given a string s, find the length of the longest substring without duplicate characters.

 Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Slinding Window Approach



Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 */
public class LongestSubstring {


    public int lengthOfLongestSubstringBruteForce(String s) {

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean[] seen = new boolean[128]; // ASCII character set
            int currentLength = 0;

            for (int j = i; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                if (seen[currentChar]) {
                    break; // Found a repeating character, break the inner loop
                }
                seen[currentChar] = true; // Mark the character as seen
                currentLength++;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;

    }


    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int[] charIndex = new int[128]; // ASCII character set

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charIndex[currentChar] > left) {
                left = charIndex[currentChar];
            }
            charIndex[currentChar] = right + 1; // Store the next index of the character
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringUsingHashMap(String s) {
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                left = charIndexMap.get(currentChar) + 1; // Move left pointer to the next index
            }
            charIndexMap.put(currentChar, right); // Update the index of the character
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringSolutionWithBetterPerformance(String s) {
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int indexOfFirstOccurrence = s.indexOf(s.charAt(right), left);
            if (indexOfFirstOccurrence != -1 && indexOfFirstOccurrence < right) {
                left = indexOfFirstOccurrence + 1; // Move left pointer to the next index
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstring solution = new LongestSubstring();
        String input = "abcabcdb";
        int result = solution.lengthOfLongestSubstringSolutionWithBetterPerformance(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}
