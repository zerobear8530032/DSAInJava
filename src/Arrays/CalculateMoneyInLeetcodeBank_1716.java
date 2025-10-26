//1716. Calculate Money in Leetcode Bank
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
//
//He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
//
//Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.
//
//
//
//Example 1:
//
//Input: n = 4
//Output: 10
//Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.
//Example 2:
//
//Input: n = 10
//Output: 37
//Explanation: After the 10th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37. Notice that on the 2nd Monday, Hercy only puts in $2.
//Example 3:
//
//Input: n = 20
//Output: 96
//Explanation: After the 20th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96.
//
//
//Constraints:
//
//1 <= n <= 1000

package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CalculateMoneyInLeetcodeBank_1716 {
//  approch : simulate the approch :
//  time complexity : O(n)
//  space complexity : O(1)
    public static int totalMoneyBruteForce(int n) {
        int totalMoney =0;
        int totalday=0;
        for(int week =0;week<(n/7)+1;week++){
            int money = week+1;
            for(int day=1;day<=7;day++){
                if(totalday==n){
                    break;
                }
                totalMoney+= money;
                money++;
                totalday++;
            }
        }
        return totalMoney;
    }




    public static void main(String[] args) {
        //Example 1:

        int n1 = 4;
        int output1= 10;

        //Example 2:

        int n2 = 10;
        int output2= 37;

        //Example 3:

        int n3 = 20;
        int output3= 96;

        int ans1 = totalMoneyBruteForce(n1);
        int ans2 = totalMoneyBruteForce(n2);
        int ans3 = totalMoneyBruteForce(n3);

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }


}

