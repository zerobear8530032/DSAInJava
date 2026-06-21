//1833. Maximum Ice Cream Bars
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//It is a sweltering summer day, and a boy wants to buy some ice cream bars.
//
//At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins. The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible.
//
//Note: The boy can buy the ice cream bars in any order.
//
//Return the maximum number of ice cream bars the boy can buy with coins coins.
//
//You must solve the problem by counting sort.
//
//
//
//Example 1:
//
//Input: costs = [1,3,2,4,1], coins = 7
//Output: 4
//Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.
//Example 2:
//
//Input: costs = [10,6,8,7,7,8], coins = 5
//Output: 0
//Explanation: The boy cannot afford any of the ice cream bars.
//Example 3:
//
//Input: costs = [1,6,3,1,2,5], coins = 20
//Output: 6
//Explanation: The boy can buy all the ice cream bars for a total price of 1 + 6 + 3 + 1 + 2 + 5 = 18.
//
//
//Constraints:
//
//costs.length == n
//1 <= n <= 105
//1 <= costs[i] <= 105
//1 <= coins <= 108
package Sorting;

import java.util.Arrays;

public class MaximumIceCreamBars_1833 {
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res=0;
        for(int x:costs){
            if(coins>=x){
                coins-=x;
                res++;
            }else{
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] costs1 = {1,3,2,4,1};
        int coins1 = 7;
        int output1= 4;

        //Example 2:

        int [] costs2 = {10,6,8,7,7,8};
        int coins2 = 5;
        int output2= 0;

        //Example 3:

        int [] costs3 = {1,6,3,1,2,5};
        int coins3= 20;
        int output3= 6;

        int ans1= maxIceCream(costs1,coins1);
        int ans2= maxIceCream(costs2,coins2);
        int ans3= maxIceCream(costs3,coins3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }
    }
}
