//1930. Unique Length-3 Palindromic Subsequences
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
//
//Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
//
//A palindrome is a string that reads the same forwards and backwards.
//
//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//
//For example, "ace" is a subsequence of "abcde".
//
//
//Example 1:
//
//Input: s = "aabca"
//Output: 3
//Explanation: The 3 palindromic subsequences of length 3 are:
//- "aba" (subsequence of "aabca")
//- "aaa" (subsequence of "aabca")
//- "aca" (subsequence of "aabca")
//Example 2:
//
//Input: s = "adc"
//Output: 0
//Explanation: There are no palindromic subsequences of length 3 in "adc".
//Example 3:
//
//Input: s = "bbcbaba"
//Output: 4
//Explanation: The 4 palindromic subsequences of length 3 are:
//- "bbb" (subsequence of "bbcbaba")
//- "bcb" (subsequence of "bbcbaba")
//- "bab" (subsequence of "bbcbaba")
//- "aba" (subsequence of "bbcbaba")
//
//
//Constraints:
//
//3 <= s.length <= 105
//s consists of only lowercase English letters.
package Strings;

public class UniqueLength3PalindromicSubsequences_1930 {
//    approch :
//    we have a charmap to keep track of each character fist and last occurence index
//    then we can just find all unique elements in btw it
//    time complexity : O(26*n)
//    space complexity : O(1)
    public static int countPalindromicSubsequence(String s) {
        int [][] charMap= new int [26][];
        for(int i =0;i<s.length();i++){
            int idx = s.charAt(i)-'a';
            if(charMap[idx]==null){
                charMap[idx]= new int []{Integer.MAX_VALUE,Integer.MIN_VALUE};
            }
            int [] pair= charMap[idx];
            pair[0]= Math.min(i,pair[0]);
            pair[1]= Math.max(i,pair[1]);
        }
        int res=0;
        for(int i=0;i<charMap.length;i++){
            int [] pairs= charMap[i];
            if(pairs==null){
                continue;
            }
            int count= findUniqueChar(s,pairs[0]+1,pairs[1]-1);
            // System.out.println(count+"  "+i);
            res+=count;
        }
        return res;
    }
    public static int findUniqueChar(String s,int start,int end){
        int [] map = new int [26];
        int count=0;
        for(int i=start;i<=end;i++){
            if(count==26){break;}
            int idx= s.charAt(i)-'a';
            if(map[idx]==0){
                count++;
            }
            map[idx]++;
        }
        return count;
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "aabca";
        int output1= 3;

        //Example 2:

        String s2 = "adc";
        int output2= 0;

        //Example 3:

        String s3 = "bbcbaba";
        int output3= 4;

        int ans1 = countPalindromicSubsequence(s1);
        int ans2 = countPalindromicSubsequence(s2);
        int ans3 = countPalindromicSubsequence(s3);

        if(output1== ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2== ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(output3== ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
    }
}


