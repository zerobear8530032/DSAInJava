//1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
//
//Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.
//
//
//
//Example 1:
//
//Input: n = "32"
//Output: 3
//Explanation: 10 + 11 + 11 = 32
//Example 2:
//
//Input: n = "82734"
//Output: 8
//Example 3:
//
//Input: n = "27346209830709182346"
//Output: 9
//
//
//Constraints:
//
//1 <= n.length <= 105
//n consists of only digits.
//n does not contain any leading zeros and represents a positive integer.
package Strings;
//find the max character and return its value its face value
//time complexity : O(n)
//space complexity : O(1)
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers_1689 {
    public static int minPartitions(String n) {
        int ch = Character.MIN_VALUE;
        for(int i =0;i<n.length();i++){
            ch = Math.max(ch,n.charAt(i));
        }
        return ch-'0';
    }
    public static void main(String[] args) {
        //Example 1:

        String n1 = "32";
        int output1= 3;

        //Example 2:


        String n2 = "82734";
        int output2= 8;

        //Example 3:

        String n3 = "27346209830709182346";
        int output3= 9;

        int ans1= minPartitions(n1);
        int ans2= minPartitions(n2);
        int ans3= minPartitions(n3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }

    }
}
