//1291. Sequential Digits
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
//
//Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
//
//
//
//Example 1:
//
//Input: low = 100, high = 300
//Output: [123,234]
//Example 2:
//
//Input: low = 1000, high = 13000
//Output: [1234,2345,3456,4567,5678,6789,12345]
//
//
//Constraints:
//
//10 <= low <= high <= 10^9
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SequentialDigits_1291 {
//    approch : here we can recusively create the valid number
//    and at the end we can sort the res
//    time complexity : N log (recusion will only go upto 9 numbers max )
//    space complexity : O(1)

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res= new ArrayList<>();
        for(int i =1;i<10;i++){
            helper(low,high,res,i);
        }
        Collections.sort(res);
        return res;
    }

    public static void helper(int low, int high , List<Integer> res, int num){
        if(low<=num && num<=high){
            res.add(num);
        }
        if(num>high){
            return ;
        }
        int lastDigit= num%10;
        if(lastDigit==9){
            return;
        }
        num= num*10 + lastDigit+1;
        helper(low,high,res,num);
    }
    public static void main(String[] args) {
        //Example 1:

        int low1 = 100, high1 = 300;
        List<Integer> output1= Arrays.asList(123,234);

        //Example 2:

        int low2 = 1000, high2 = 13000;
        List<Integer> output2= Arrays.asList(1234,2345,3456,4567,5678,6789,12345);


        List<Integer> ans1= sequentialDigits(low1,high1);
        List<Integer> ans2= sequentialDigits(low2,high2);

        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+  (ans1));
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+  (output2));
            System.out.println("Your Answer :"+  (ans2));
        }

    }
}
