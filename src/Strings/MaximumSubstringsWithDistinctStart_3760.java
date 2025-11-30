//3760. Maximum Substrings With Distinct Start
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given a string s consisting of lowercase English letters.
//
//Return an integer denoting the maximum number of substrings you can split s into such that each substring starts with a distinct character (i.e., no two substrings start with the same character).
//
//
//
//Example 1:
//
//Input: s = "abab"
//
//Output: 2
//
//Explanation:
//
//Split "abab" into "a" and "bab".
//Each substring starts with a distinct character i.e 'a' and 'b'. Thus, the answer is 2.
//Example 2:
//
//Input: s = "abcd"
//
//Output: 4
//
//Explanation:
//
//Split "abcd" into "a", "b", "c", and "d".
//Each substring starts with a distinct character. Thus, the answer is 4.
//Example 3:
//
//Input: s = "aaaa"
//
//Output: 1
//
//Explanation:
//
//All characters in "aaaa" are 'a'.
//Only one substring can start with 'a'. Thus, the answer is 1.
//
//
//Constraints:
//
//1 <= s.length <= 105
//s consists of lowercase English letters.
package Strings;

import java.util.HashSet;
// we care about starting character so we will put all character in hashset remving duplicates
// and size is our answer
//time complexity : O(n)
//space complexity : O(n)// o(1) IF THE CHARACTER ARE JUST 26 DEPENDS ON CONSTRAINS
public class MaximumSubstringsWithDistinctStart_3760 {
    public static int maxDistinct(String s) {
        HashSet<Character> set= new HashSet();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        return set.size();
    }
    public static void main(String[] args) {
        //Example 1:

        String  s1 = "abab";
        int output1= 2;

        //Example 2:

        String  s2 = "abcd";
        int output2= 4;

        //Example 3:

        String  s3 = "aaaa";
        int output3= 1;

        int ans1 =maxDistinct(s1);
        int ans2 =maxDistinct(s2);
        int ans3 =maxDistinct(s3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }
}
