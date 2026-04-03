//1415. The k-th Lexicographical String of All Happy Strings of Length n
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//A happy string is a string that:
//
//consists only of letters of the set ['a', 'b', 'c'].
//s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
//For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.
//
//Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.
//
//Return the kth string of this list or return an empty string if there are less than k happy strings of length n.
//
//
//
//Example 1:
//
//Input: n = 1, k = 3
//Output: "c"
//Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
//Example 2:
//
//Input: n = 1, k = 4
//Output: ""
//Explanation: There are only 3 happy strings of length 1.
//Example 3:
//
//Input: n = 3, k = 9
//Output: "cab"
//Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
//
//
//Constraints:
//
//1 <= n <= 10
//1 <= k <= 100
package Recursion;

import java.util.ArrayList;
import java.util.List;

class TheKthLexicographicalStringOfAllHappyStringsOfLengthN_1415 {
    public static String getHappyString(int n, int k) {
        List<String> strs= new ArrayList<>();
        buildHappyString("",n,strs);
        if(strs.size()<k){return "";}
        return strs.get(k-1);
    }

    public static void buildHappyString(String str, int n, List<String> strs ){
        if(n==str.length()){
            strs.add(str);
            return;
        }
        if(str.length()==0){
            buildHappyString("a",n,strs);
            buildHappyString("b",n,strs);
            buildHappyString("c",n,strs);
            return ;
        }else{
            char ch = str.charAt(str.length()-1);
            if(ch =='a'){
                buildHappyString(str+"b",n,strs);
                buildHappyString(str+"c",n,strs);
            }else if(ch == 'b'){
                buildHappyString(str+"a",n,strs);
                buildHappyString(str+"c",n,strs);
            }else{
                buildHappyString(str+"a",n,strs);
                buildHappyString(str+"b",n,strs);
            }
        }
    }

    public static void main(String[] args) {
        //Example 1:

        int  n1 = 1, k1= 3;
        String output1= "c";

        //Example 2:

        int  n2 = 1, k2 = 4;
        String output2= "";

        //Example 3:

        int  n3 = 3, k3 = 9;
        String output3= "cab";

        String ans1= getHappyString(n1,k1);
        String ans2= getHappyString(n2,k2);
        String ans3= getHappyString(n3,k3);

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }

    }
}