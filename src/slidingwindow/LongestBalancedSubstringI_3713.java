//3713. Longest Balanced Substring I
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a string s consisting of lowercase English letters.
//
//A substring of s is called balanced if all distinct characters in the substring appear the same number of times.
//
//Return the length of the longest balanced substring of s.
//
//
//
//Example 1:
//
//Input: s = "abbac"
//
//Output: 4
//
//Explanation:
//
//The longest balanced substring is "abba" because both distinct characters 'a' and 'b' each appear exactly 2 times.
//
//Example 2:
//
//Input: s = "zzabccy"
//
//Output: 4
//
//Explanation:
//
//The longest balanced substring is "zabc" because the distinct characters 'z', 'a', 'b', and 'c' each appear exactly 1 time.​​​​​​​
//
//Example 3:
//
//Input: s = "aba"
//
//Output: 2
//
//Explanation:
//
//​​​​​​​One of the longest balanced substrings is "ab" because both distinct characters 'a' and 'b' each appear exactly 1 time. Another longest balanced substring is "ba".
//
//
//
//Constraints:
//
//1 <= s.length <= 1000
//s consists of lowercase English letters.
package slidingwindow;

import java.util.HashSet;

public class LongestBalancedSubstringI_3713 {
//   approch :
//     check every single substring
//    and validate it find the max one
//    time complexity : O(n*n)
//    space complexity : O(n*n)
    public static int longestBalanced(String s) {
        int max =0;
        for(int i =0;i<s.length();i++){
            int [] map = new  int [26];
            for(int j =i;j<s.length();j++){
                map[s.charAt(j)-'a']++;
                if(checkValidSubstring(map)){
                    int size= j-i+1;
                    max=Math.max(size,max);
                }
            }
        }
        return max;
    }

    public static boolean checkValidSubstring(int [] map){
        HashSet<Integer> set= new HashSet();
        for(int x:map){
            if(x!=0){
                set.add(x);
            }
        }
        return set.size()==1;
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "abbac";
        int output1= 4;

        //Example 2:

        String  s2 = "zzabccy";
        int output2= 4;

        //Example 3:

        String  s3 = "aba";
        int output3= 2;

        int ans1= longestBalanced(s1);
        int ans2= longestBalanced(s2);
        int ans3= longestBalanced(s3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }

    }
}
