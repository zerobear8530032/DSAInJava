// 76. Minimum Window Substring
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
//
// The testcases will be generated such that the answer is unique.
//
// Example 1:
//
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
//
// Example 2:
//
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
//
// Example 3:
//
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
//
// Constraints:
//
// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.
//
// Follow up: Could you find an algorithm that runs in O(m + n) time?

package slidingwindow;

import java.util.HashMap;
import java.util.Set;

public class MinimumWindowSubstring_76 {

    // Approach: use sliding window
    // Take a hashmap to keep frequency and reduce size of the window if it becomes valid
    // Otherwise keep increasing the window
    // Time complexity: O(n*52)
    // Space complexity: O(52)

    public static String minWindow(String s, String t) {
        // if s is smaller than t, it cannot contain t as substring
        if (s.length() < t.length() || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        String smallest = "";

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> available = new HashMap<>();
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            available.put(ch, available.getOrDefault(ch, 0) + 1);

            while (isValid(need, available)) {
                if (smallest.isEmpty() || smallest.length() > r - l + 1) {
                    smallest = s.substring(l, r + 1);
                }
                char lch = s.charAt(l);
                available.put(lch, available.get(lch) - 1);
                l++;
            }
        }

        return smallest;
    }

    public static boolean isValid(HashMap<Character, Integer> need, HashMap<Character, Integer> available) {
        Set<Character> keys = need.keySet();
        for (Character key : keys) {
            if (!available.containsKey(key)) {
                return false;
            }
            if (available.get(key) < need.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example 1:
        String s1 = "ADOBECODEBANC", t1 = "ABC";
        String output1 = "BANC";

        // Example 2:
        String s2 = "a", t2 = "a";
        String output2 = "a";

        // Example 3:
        String s3 = "a", t3 = "aa";
        String output3 = "";

        String ans1 = minWindow(s1, t1);
        String ans2 = minWindow(s2, t2);
        String ans3 = minWindow(s3, t3);

        if (output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output: " + output1);
            System.out.println("Your Output: " + ans1);
        }

        if (output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output: " + output2);
            System.out.println("Your Output: " + ans2);
        }

        if (output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output: " + output3);
            System.out.println("Your Output: " + ans3);
        }
    }
}
