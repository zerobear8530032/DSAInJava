//5. Longest Palindromic Substring
//Attempted
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given a string s, return the longest palindromic substring in s.
//
//
//
//Example 1:
//
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
//Example 2:
//
//Input: s = "cbbd"
//Output: "bb"
//
//
//Constraints:
//
//1 <= s.length <= 1000
//s consist of only digits and English letters.
package Strings;

public class LongestPalindromicSubstring_5 {

    public static String longestPalindrome(String s) {
        String res="";

        for(int i =0;i<s.length();i++){
           String even = findPalindrome(s,i,i);
           String odd = findPalindrome(s,i,i+1);
           String max = even.length()<odd.length() ? odd:even;
           if(max.length()>res.length()){
               res=max;
           }
        }
        return res;
    }
    public static String findPalindrome(String s, int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }

    public static void main(String[] args) {
        //Example 1:

        String s1 = "babad";
        String output1="bab";
        //Example 2:

        String s2 = "cbbd";
        String output2="bb";


        String ans1 = longestPalindrome(s1);
        String ans2 = longestPalindrome(s2);

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
    }
}
