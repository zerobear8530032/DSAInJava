//2048. Next Greater Numerically Balanced Number
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//An integer x is numerically balanced if for every digit d in the number x, there are exactly d occurrences of that digit in x.
//
//Given an integer n, return the smallest numerically balanced number strictly greater than n.
//
//
//
//Example 1:
//
//Input: n = 1
//Output: 22
//Explanation:
//22 is numerically balanced since:
//- The digit 2 occurs 2 times.
//It is also the smallest numerically balanced number strictly greater than 1.
//Example 2:
//
//Input: n = 1000
//Output: 1333
//Explanation:
//1333 is numerically balanced since:
//- The digit 1 occurs 1 time.
//- The digit 3 occurs 3 times.
//It is also the smallest numerically balanced number strictly greater than 1000.
//Note that 1022 cannot be the answer because 0 appeared more than 0 times.
//Example 3:
//
//Input: n = 3000
//Output: 3133
//Explanation:
//3133 is numerically balanced since:
//- The digit 1 occurs 1 time.
//- The digit 3 occurs 3 times.
//It is also the smallest numerically balanced number strictly greater than 3000.
//
//
//Constraints:
//
//0 <= n <= 106
package Backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NextGreaterNumericallyBalancedNumber_2048 {
    static int [] map = new int [10];
    public static int nextBeautifulNumber(int n) {
        for(int i =n+1;i<Integer.MAX_VALUE;i++){
            if(isBalance(i)){
                return  i;
            }
        }
        return -1;
    }

    public static boolean isBalance (int n){
        while(n!=0){
            int rem= n%10;
            map[rem]++;
            n=n/10;
        }
        boolean valid = true;
        for(int i =0;i<map.length;i++){
            if(map[i]!=0 && map[i]!=i){
                valid=false;
            }
            map[i]=0;
        }
        return valid;
    }
    public static void main(String[] args) {
        //Example 1:

        int n1 = 1;
        int output1= 22;

        //Example 2:

        int n2 = 1000;
        int output2= 1333;

        //Example 3:

        int n3 = 3000;
        int output3= 3133;

        int ans1 = nextBeautifulNumber(n1);
        int ans2 = nextBeautifulNumber(n2);
        int ans3 = nextBeautifulNumber(n3);


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
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }
}
