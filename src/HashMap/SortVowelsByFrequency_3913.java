//3913. Sort Vowels by Frequency
//Solved
//Medium
//premium lock icon
//Companies
//You are given a string s consisting of lowercase English characters.
//
//Rearrange only the vowels in the string so that they appear in non-increasing order of their frequency.
//
//If multiple vowels have the same frequency, order them by the position of their first occurrence in s.
//
//Return the modified string.
//
//Vowels are 'a', 'e', 'i', 'o', and 'u'.
//
//Example 1:
//
//Input: s = "leetcode"
//Output: "leetcedo"
//
//Example 2:
//
//Input: s = "aeiaaioooa"
//Output: "aaaaoooiie"
//
//Example 3:
//
//Input: s = "baeiou"
//Output: "baeiou"
//
//Constraints:
//
//1 <= s.length <= 10^5
//s consists of lowercase English letters

package HashMap;

import java.util.*;

class Entry {
    char ch;
    int freq;
    int startIdx;

    public Entry(char ch, int freq, int startIdx) {
        this.ch = ch;
        this.freq = freq;
        this.startIdx = startIdx;
    }

    public void increaseFrequency() {
        this.freq++;
    }

    public void decreaseFrequency() {
        this.freq--;
    }

    public String toString() {
        return "Entry{" +
                "ch=" + ch +
                ", freq=" + freq +
                ", startIdx=" + startIdx +
                '}';
    }
}

public class SortVowelsByFrequency_3913 {

    // Time Complexity: O(n + k log k)
    // n = length of string
    // k = number of unique vowels (at most 5)
    // → O(n) for traversal + O(k log k) for sorting (constant small)

    // Space Complexity: O(k) ≈ O(1)
    // only storing vowel entries (max 5)

    public static String sortVowels(String s) {
        HashMap<Character, Entry> map = new HashMap<>();
        char[] str = s.toCharArray();

        for (int i = 0; i < str.length; i++) {
            char ch = str[i];
            if (!isVovel(ch)) {
                continue;
            }
            if (map.containsKey(ch)) {
                map.get(ch).increaseFrequency();
            } else {
                map.put(ch, new Entry(ch, 1, i));
            }
        }

        List<Entry> list = new ArrayList<>(map.values());

        Collections.sort(list, (e1, e2) -> {
            if (e1.freq == e2.freq) {
                return e1.startIdx - e2.startIdx;
            }
            return e2.freq - e1.freq;
        });

        int idx = 0;
        int lidx = 0;

        while (idx < str.length) {
            char ch = str[idx];

            if (!isVovel(ch)) {
                idx++;
                continue;
            }

            while (idx < str.length && isVovel(str[idx])) {
                Entry e = list.get(lidx);

                while (idx < str.length && e.freq != 0 && isVovel(str[idx])) {
                    str[idx] = e.ch;
                    idx++;
                    e.decreaseFrequency();
                }

                if (e.freq == 0) {
                    lidx++;
                }
            }
        }

        return new String(str);
    }

    public static boolean isVovel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {

        // Example 1:
        String s1 = "leetcode";
        String output1 = "leetcedo";

        // Example 2:
        String s2 = "aeiaaioooa";
        String output2 = "aaaaoooiie";

        // Example 3:
        String s3 = "baeiou";
        String output3 = "baeiou";

        String ans1 = sortVowels(s1);
        String ans2 = sortVowels(s2);
        String ans3 = sortVowels(s3);

        if (output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :" + output1);
            System.out.println("Your Output :" + ans1);
        }

        if (output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + output2);
            System.out.println("Your Output :" + ans2);
        }

        if (output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :" + output3);
            System.out.println("Your Output :" + ans3);
        }
    }
}