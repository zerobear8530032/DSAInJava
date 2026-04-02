//1009. Complement of Base 10 Integer
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
//
//For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
//Given an integer n, return its complement.
//
//
//
//Example 1:
//
//Input: n = 5
//Output: 2
//Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
//Example 2:
//
//Input: n = 7
//Output: 0
//Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
//Example 3:
//
//Input: n = 10
//Output: 5
//Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
//
//
//Constraints:
//
//0 <= n < 109
//
//
//Note: This question is the same as 476: https://leetcode.com/problems/number-complement/
package BitWise;

public class ComplementOfBase10Integer_1009 {
    public static int bitwiseComplement(int n) {
        char [] str = Integer.toBinaryString(n).toCharArray();
        for(int i =0;i<str.length;i++){
            str[i]= str[i]=='0'?'1':'0';
        }
        return Integer.parseInt(new String(str),2);
    }
    public static void main(String[] args) {
        //Example 1:

        int  n1 = 5;
        int output1= 2;

        //Example 2:

        int  n2 = 7;
        int output2= 0;

        //Example 3:

        int n3 = 10;
        int output3=5;

        int ans1 = bitwiseComplement(n1);
        int ans2 = bitwiseComplement(n2);
        int ans3 = bitwiseComplement(n3);

        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }

    }

}
