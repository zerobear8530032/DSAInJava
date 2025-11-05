//131. Palindrome Partitioning
//Medium
//Topics
//premium lock icon
//Companies
//Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
//
//
//
//Example 1:
//
//Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
//Example 2:
//
//Input: s = "a"
//Output: [["a"]]
//
//
//Constraints:
//
//1 <= s.length <= 16
//s contains only lowercase English letters.
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning_131 {
//    approch :
//    here we can try every single parition of the string
//    and use backtracking to create the result
//    time complexity : O(2^n)
//    space complexity : O(n)
    public static List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList();
        helper(s ,res,new ArrayList());
        return res;
    }

    public static void helper(String s, List<List<String>> res, List<String> curr){
        if(s.isBlank()){
            res.add(new ArrayList(curr));
            return ;
        }
        for(int i =0;i<s.length();i++){
            String sleft= s.substring(0,i+1);
            if(isPalindrome(sleft)){
                curr.add(sleft);
                helper(s.substring(i+1),res,curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String str){
        int s=0;
        int e = str.length()-1;
        while(s<e){
            if(str.charAt(s)!=str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "aab";
        List<List<String>> output1= new ArrayList<>(Arrays.asList(
                Arrays.asList("a","a","b"),
                Arrays.asList("aa","b")
        ));

        //Example 2:

        String s2 = "a";
        List<List<String>> output2= new ArrayList<>(Arrays.asList(
                Arrays.asList("a")
        ));

        List<List<String>> ans1 = partition(s1);
        List<List<String>> ans2 = partition(s2);

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
