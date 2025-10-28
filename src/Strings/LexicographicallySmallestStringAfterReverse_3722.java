//3722. Lexicographically Smallest String After Reverse
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given a string s of length n consisting of lowercase English letters.
//
//You must perform exactly one operation by choosing any integer k such that 1 <= k <= n and either:
//
//reverse the first k characters of s, or
//reverse the last k characters of s.
//Return the lexicographically smallest string that can be obtained after exactly one such operation.
//
//A string a is lexicographically smaller than a string b if, at the first position where they differ, a has a letter that appears earlier in the alphabet than the corresponding letter in b. If the first min(a.length, b.length) characters are the same, then the shorter string is considered lexicographically smaller.
//
//
//
//Example 1:
//
//Input: s = "dcab"
//
//Output: "acdb"
//
//Explanation:
//
//Choose k = 3, reverse the first 3 characters.
//Reverse "dca" to "acd", resulting string s = "acdb", which is the lexicographically smallest string achievable.
//Example 2:
//
//Input: s = "abba"
//
//Output: "aabb"
//
//Explanation:
//
//Choose k = 3, reverse the last 3 characters.
//Reverse "bba" to "abb", so the resulting string is "aabb", which is the lexicographically smallest string achievable.
//Example 3:
//
//Input: s = "zxy"
//
//Output: "xzy"
//
//Explanation:
//
//Choose k = 2, reverse the first 2 characters.
//Reverse "zx" to "xz", so the resulting string is "xzy", which is the lexicographically smallest string achievable.
//
//
//Constraints:
//
//1 <= n == s.length <= 1000
//s consists of lowercase English letters.
package Strings;

public class LexicographicallySmallestStringAfterReverse_3722 {
//    approch :
//    simulate every single possible sequence and update the smallest
//    time complexity :O(n*n)
//    space complexity :O(n*n)
    public static String lexSmallest(String s) {
        String smallest = s;
        for(int i =0;i<s.length();i++){
            String leftRotate= rotateLeft(i,s);
            String rightRotate= rotateRight(i,s);
            if(smallest.compareTo(leftRotate)>0){
                smallest= leftRotate;
            }
            if(smallest.compareTo(rightRotate)>0){
                smallest= rightRotate;
            }

        }
        return smallest;

    }

    public  static String rotateLeft(int k , String s){
        StringBuilder res= new StringBuilder(s.substring(0,k+1));
        res.reverse();
        res.append(s.substring(k+1));
        return res.toString();
    }

    public static String rotateRight(int k , String s){
        StringBuilder res= new StringBuilder(s.substring(k));
        res.reverse();
        return s.substring(0,k)+res.toString();
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "dcab";
        String output1= "acdb";

        //Example 2:

        String s2 = "abba";
        String output2= "aabb";


        //Example 3:

        String s3 = "zxy";
        String output3= "xzy";

        String ans1 = lexSmallest(s1);
        String ans2 = lexSmallest(s2);
        String ans3 = lexSmallest(s3);



        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }


    }
}
