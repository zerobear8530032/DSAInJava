//1475. Final Prices With a Special Discount in a Shop
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array prices where prices[i] is the price of the ith item in a shop.
//
//There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.
//
//Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.
//
//
//
//Example 1:
//
//Input: prices = [8,4,6,2,3]
//Output: [4,2,4,2,3]
//Explanation:
//For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
//For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
//For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
//For items 3 and 4 you will not receive any discount at all.
//Example 2:
//
//Input: prices = [1,2,3,4,5]
//Output: [1,2,3,4,5]
//Explanation: In this case, for all items, you will not receive any discount at all.
//Example 3:
//
//Input: prices = [10,1,1,6]
//Output: [9,0,1,6]
//
//
//Constraints:
//
//1 <= prices.length <= 500
//1 <= prices[i] <= 1000
package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop_1475 {
    public static int[] finalPrices(int[] prices) {
        int [] res= new int [prices.length];
        Stack<Integer> stk = new Stack();
        // we can use the Next Smaller Element to right for this questions
        for(int i =prices.length-1;i>=0;i--){
            if(stk.isEmpty()){
                res[i]=prices[i];
            }else{
                while(!stk.isEmpty() && prices[stk.peek()]>prices[i]){
                    stk.pop();
                }
                if(stk.isEmpty()){
                    res[i]=prices[i];
                }else{
                    res[i]=prices[i]- prices[stk.peek()];
                }
            }
            stk.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] prices1 = {8,4,6,2,3};
        int [] output1= {4,2,4,2,3};

        //Example 2:

        int [] prices2 = {1,2,3,4,5};
        int [] output2= {1,2,3,4,5};

        //Example 3:

        int [] prices3 = {10,1,1,6};
        int [] output3= {9,0,1,6};

        int [] ans1= finalPrices(prices1);
        int [] ans2= finalPrices(prices2);
        int [] ans3= finalPrices(prices3);

        if(Arrays.equals(output1,ans1)) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Your Output :"+ Arrays.toString(ans1) );
            System.out.println("Actual Output :"+ Arrays.toString(output1));
        }
        if(Arrays.equals(output2,ans2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Your Output :"+ Arrays.toString(ans2));
            System.out.println("Actual Output :"+ Arrays.toString(output2));
        }
        if(Arrays.equals(output3,ans3)) {
            System.out.println("Case 3 Passed ");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Your Output :"+ Arrays.toString(ans3));
            System.out.println("Actual Output :"+ Arrays.toString(output3));
        }

    }
}
