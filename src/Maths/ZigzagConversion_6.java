//6. Zigzag Conversion
//Medium
//Topics
//premium lock icon
//Companies
//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//
//Write the code that will take a string and make this conversion given a number of rows:
//
//string convert(string s, int numRows);
//
//
//Example 1:
//
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
//Example 2:
//
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
//Example 3:
//
//Input: s = "A", numRows = 1
//Output: "A"
//
//
//Constraints:
//
//1 <= s.length <= 1000
//s consists of English letters (lower-case and upper-case), ',' and '.'.
//1 <= numRows <= 1000

package Maths;

import java.util.Arrays;

public class ZigzagConversion_6 {
// approch:
//     just create a 2d array of size of s*s
//    and put the string in it zigzag and read it as row wise
//    time complexity :O(s*s)
//    space complexity :O(s*s)
    public static String convert(String s, int numRows) {
        int n=s.length();
        if(n==numRows || numRows==1){return s;}
        char [][] grid = new char [numRows][s.length()];
        int idx= 0;
        int r=0;
        int c=0;
        StringBuilder res= new StringBuilder();
        while(r<grid.length && c<grid[0].length){
            // go down :
            while(idx<n && r<grid.length){
                grid[r][c]=s.charAt(idx);
                r++;
                idx++;
            }
            r=grid.length-2;
            c++;
            // go up  diagonal
            while(idx<n && r>0 && c<=grid[r].length){
                grid[r][c]=s.charAt(idx);
                r--;
                c++;
                idx++;
            }
        }
        for(char [] rows:grid){
            for(char ch:rows){
                if(ch!='\u0000'){
                    res.append(ch);
                }
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        String output1="PAHNAPLSIIGYIR";

        //Example 2:

        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        String output2="PINALSIGYAHRPI";

        //Example 3:

        String s3 = "A";
        int numRows3 = 1;
        String output3="A";

        String ans1=convert(s1,numRows1);
        String ans2=convert(s2,numRows2);
        String ans3=convert(s3,numRows3);


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
