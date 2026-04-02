//696. Count Binary Substrings
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
//
//Substrings that occur multiple times are counted the number of times they occur.
//
//
//
//Example 1:
//
//Input: s = "00110011"
//Output: 6
//Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
//Notice that some of these substrings repeat and are counted the number of times they occur.
//Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
//Example 2:
//
//Input: s = "10101"
//Output: 4
//Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
//
//
//Constraints:
//
//1 <= s.length <= 105
//s[i] is either '0' or '1'.


package TwoPointers;

import java.util.ArrayList;

class Solution {
//    brute force : approch we cn group the conscutive values nd count them and store count
//    then we cn just sum and tke min of adjecent groups
//    time complexity : O(n)
//    space complexity : O(n)
    public static int countBinarySubstrings(String s) {
        int i =0;
        int res=0;
        ArrayList<Integer> groups = new ArrayList();
        while(i<s.length()){
            int l= countConsicutive(s,i);
            i+=l;
            groups.add(l);
        }
        for( i =0;i<groups.size()-1;i++){
            res+=Math.min(groups.get(i+1),groups.get(i));
        }
        return res;
    }

    public static int countConsicutive(String s, int idx){
        if(idx>=s.length()){return 1;}
        char ch = s.charAt(idx);
        int count=0;
        while(idx<s.length() && ch==s.charAt(idx)){
            count++;
            idx++;
        }
        return count;
    }

    public static void main(String[] args) {
        //Example 1:

        String s1 = "00110011";
        int output1= 6;

        //Example 2:

        String s2 = "10101";
        int output2= 4;
        int ans1 = countBinarySubstrings(s1);
        int ans2 = countBinarySubstrings(s2);

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

    }
}