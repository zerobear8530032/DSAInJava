//Permutation in String
//Solved
//You are given two strings s1 and s2.
//
//Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.
//
//Both strings only contain lowercase letters.
//
//Example 1:
//
//Input: s1 = "abc", s2 = "lecabee"
//
//Output: true
//Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".
//
//Example 2:
//
//Input: s1 = "abc", s2 = "lecaabee"
//
//Output: false
//Constraints:
//
//1 <= s1.length, s2.length <= 1000
package slidingwindow;

import java.util.Arrays;

public class Permutation_NEETCODE {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int [] map1= new int [26];
        int [] map2= new int [26];
        int l=0;
        for(int i =0;i<s1.length();i++){
            char ch = s1.charAt(i);
            map1[ch-'a']++;
        }

        for(int r=0;r<s2.length();r++){
            char ch = s2.charAt(r);
            map2[ch-'a']++;
            while(map2[ch-'a']>map1[ch-'a']){
                char lch= s2.charAt(l);
                map2[lch-'a']--;
                l++;
            }
            int size = r-l+1;
            if(size==s1.length() && Arrays.equals(map1,map2)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //Example 1:

        String s11 = "abc", s12 = "lecabee";
        boolean output1= true;

        //Example 2:

        String s21 = "abc", s22 = "lecaabee";
        boolean output2= false;


        boolean ans1= checkInclusion(s11,s12);
        boolean ans2= checkInclusion(s21,s22);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }

    }
}
