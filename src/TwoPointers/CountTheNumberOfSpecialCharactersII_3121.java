//3121. Count the Number of Special Characters II
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word, and every lowercase occurrence of c appears before the first uppercase occurrence of c.
//
//Return the number of special letters in word.
//
//
//
//Example 1:
//
//Input: word = "aaAbcBC"
//
//Output: 3
//
//Explanation:
//
//The special characters are 'a', 'b', and 'c'.
//
//Example 2:
//
//Input: word = "abc"
//
//Output: 0
//
//Explanation:
//
//There are no special characters in word.
//
//Example 3:
//
//Input: word = "AbBCab"
//
//Output: 0
//
//Explanation:
//
//There are no special characters in word.
//
//
//
//Constraints:
//
//1 <= word.length <= 2 * 105
//word consists of only lowercase and uppercase English letters.
package TwoPointers;

import java.util.Arrays;

public class CountTheNumberOfSpecialCharactersII_3121 {
//    approch :
//    just compute the first index from left to right when cap letter c comes
//    and compute the last letter of small letter char comes
//    then just check if small and capital character present if yes
//    just check if small last occurence is higher the capital first occurence
//    Note : make the string index as 1 based indexing will make it handle edge case where thie is only single occurences
//    time complexity : O(n)
//    space complexity : O(1)

    public static int numberOfSpecialChars(String word) {
        int [] small = new int [26];
        int [] cap = new int [26];
        Arrays.fill(cap,Integer.MAX_VALUE);
        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch>='a' && ch<='z'){
                small[ch-'a']=Math.max(i+1,small[ch-'a']);
            }else{
                cap[ch-'A']=Math.min(i+1,cap[ch-'A']);
            }
        }
        int res=0;
        for(int i =0;i<26;i++){
            if(small[i]!=0 && cap[i]!=Integer.MAX_VALUE && small[i]<cap[i]){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        String word1 = "aaAbcBC";
        int output1= 3;

        //Example 2:

        String word2 = "abc";
        int output2= 0;

        //Example 3:

        String word3 = "AbBCab";
        int output3= 0;

        int ans1= numberOfSpecialChars(word1);
        int ans2= numberOfSpecialChars(word2);
        int ans3= numberOfSpecialChars(word3);


        if (output1 == ans1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :" + output1);
            System.out.println("Your Output :" + ans1);
        }

        if (output2 == ans2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + output2);
            System.out.println("Your Output :" + ans2);
        }

        if (output3 == ans3) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :" + output3);
            System.out.println("Your Output :" + ans3);
        }

    }
}
