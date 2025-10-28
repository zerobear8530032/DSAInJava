//3723. Maximize Sum of Squares of Digits
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given two positive integers num and sum.
//
//A positive integer n is good if it satisfies both of the following:
//
//The number of digits in n is exactly num.
//The sum of digits in n is exactly sum.
//The score of a good integer n is the sum of the squares of digits in n.
//
//Return a string denoting the good integer n that achieves the maximum score. If there are multiple possible integers, return the maximum ​​​​​​​one. If no such integer exists, return an empty string.
//
//
//
//Example 1:
//
//Input: num = 2, sum = 3
//
//Output: "30"
//
//Explanation:
//
//There are 3 good integers: 12, 21, and 30.
//
//The score of 12 is 12 + 22 = 5.
//The score of 21 is 22 + 12 = 5.
//The score of 30 is 32 + 02 = 9.
//The maximum score is 9, which is achieved by the good integer 30. Therefore, the answer is "30".
//
//Example 2:
//
//Input: num = 2, sum = 17
//
//Output: "98"
//
//Explanation:
//
//There are 2 good integers: 89 and 98.
//
//The score of 89 is 82 + 92 = 145.
//The score of 98 is 92 + 82 = 145.
//The maximum score is 145. The maximum good integer that achieves this score is 98. Therefore, the answer is "98".
//
//Example 3:
//
//Input: num = 1, sum = 10
//
//Output: ""
//
//Explanation:
//
//There are no integers that have exactly 1 digit and whose digits sum to 10. Therefore, the answer is "".
package Greedy;

public class MaximizeSumOfSquaresOfDigits_3723 {
//     approch :
//    intutions :
//    first we want to maximize the sum of squares
//    so if we try to take the biggest intereger to go at each place will get us largest by default
//    now how can we choose what tp go so each place value can range from 0 to 9
//    so to maximize we can get how many 9 we need to reach as close as sum
//    we can do this sum/9 = number of nines :
//    sum%9 = remaining sum
//    rest of the number should be equal to nums.length without increasing sum so we can choose 0
//    if thats not the case and we exceed nums whil creating the sum it means we have to return "";
//    time complexity : O(n)
//    space complexity : O(n)
    public static String maxSumOfSquares(int num, int sum) {
        StringBuilder res= new StringBuilder();
        int n= sum/9;// number of nines
        int rem= sum%9;// remaining nums
        for(int i =0;i<n;i++){// append nines
            res.append(9);
        }
        if(rem!=0){// append remainder if present
            res.append(rem);
        }
        if(res.length()>num){// if length exceed  we cn return ""
            return "";
        }
//        we can fill the number with trailing zeros to make its length equal to nums
            while(res.length()<num){
                res.append("0");
            }

        return res.toString();
    }
    public static void main(String[] args) {
        //Example 1:

        int num1 = 2, sum1 = 3;
        String output1= "30";

        //Example 2:

        int num2 = 2, sum2 = 17;
        String output2= "98";

        //Example 3:

        int num3 = 1, sum3 = 10;
        String output3= "";

        String ans1= maxSumOfSquares(num1,sum1);
        String ans2= maxSumOfSquares(num2,sum2);
        String ans3= maxSumOfSquares(num3,sum3);


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
