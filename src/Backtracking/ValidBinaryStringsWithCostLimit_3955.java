//3955. Valid Binary Strings With Cost Limit
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given two integers n and k.
//
//The cost of a binary string s is defined as the sum of all indices i (0-based) such that s[i] == '1'.
//
//A binary string is considered valid if:
//
//It does not contain two consecutive '1' characters.
//Its cost is less than or equal to k.
//Return a list of all valid binary strings of length n in any order.
//
//
//
//Example 1:
//
//Input: n = 3, k = 1
//
//Output: ["000","010","100"]
//
//Explanation:
//
//The binary strings of length 3 without consecutive '1' characters are:
//
//"000" : cost = 0
//"100" : cost = 0
//"010" : cost = 1
//"001" : cost = 2
//"101" : cost = 0 + 2 = 2
//Among these, the strings with cost less than or equal to k = 1 are "000", "010" and "100".
//
//Thus, the valid strings are ["000", "010", "100"].
//
//Example 2:
//
//Input: n = 1, k = 0
//
//Output: ["0","1"]
//
//Explanation:
//
//The valid binary strings of length 1 are "0" and "1".
//
//Thus the answer is ["0", "1"].
//
//
//
//Constraints:
//
//1 <= n <= 12
//0 <= k <= n * (n - 1) / 2
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidBinaryStringsWithCostLimit_3955 {
//    approch : we can use recursive back tracking to  build a valid grid and keep adding the valid stirng in the list
//    time complexity : O(n^2)
//    space complexity : O(n)
    public static List<String> generateValidStrings(int n, int k) {
        List<String> res= new ArrayList();
        buildString("",0,res,k,n);
        return res;
    }

    public static void buildString(String curr, int cost ,List<String> res, int k, int n){
        if(cost>k){
            return ;
        }
        if(curr.length()==n){
            // System.out.println(curr);
            if(cost<=k){
                res.add(curr);
            }
            return ;
        }
        int len= curr.length();
        if(len==0 || len!=0 && curr.charAt(len-1)=='0'){
            buildString(curr+"0",cost,res,k,n);
            buildString(curr+"1",cost+len,res,k,n);
        }
        if(len!=0 && curr.charAt(len-1)=='1'){
            buildString(curr+"0",cost,res,k,n);
        }
    }
    public static void main(String[] args) {
        //Example 1:

        int n1 = 3, k1 = 1;
        List<String> output1= new ArrayList<>(Arrays.asList("000","010","100"));

        //Example 2:

        int n2 = 1, k2 = 0;
        List<String> output2= new ArrayList<>(Arrays.asList("0","1"));

        List<String> ans1 = generateValidStrings(n1,k1);
        List<String> ans2 = generateValidStrings(n2,k2);
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
