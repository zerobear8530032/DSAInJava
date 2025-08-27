//2561. Rearranging Fruits
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You have two fruit baskets containing n fruits each. You are given two 0-indexed integer arrays basket1 and basket2 representing the cost of fruit in each basket. You want to make both baskets equal. To do so, you can use the following operation as many times as you want:
//
//Choose two indices i and j, and swap the ith fruit of basket1 with the jth fruit of basket2.
//The cost of the swap is min(basket1[i], basket2[j]).
//Two baskets are considered equal if sorting them according to the fruit cost makes them exactly the same baskets.
//
//Return the minimum cost to make both the baskets equal or -1 if impossible.
//
//
//
//Example 1:
//
//Input: basket1 = [4,2,2,2], basket2 = [1,4,1,2]
//Output: 1
//Explanation: Swap index 1 of basket1 with index 0 of basket2, which has cost 1. Now basket1 = [4,1,2,2] and basket2 = [2,4,1,2]. Rearranging both the arrays makes them equal.
//Example 2:
//
//Input: basket1 = [2,3,4,1], basket2 = [3,2,5,1]
//Output: -1
//Explanation: It can be shown that it is impossible to make both the baskets equal.
//
//
//Constraints:
//
//basket1.length == basket2.length
//1 <= basket1.length <= 105
//1 <= basket1[i], basket2[i] <= 109

package Greedy;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
public class RearrangingFruits_2561 {
// approch :
//    here we know 2 things to make both  basket equal so
//    we need at least 2 of each fruit means each fruit frequency should be even
//    other wise return -1
//    second we can take as many swaps we want
//    so we can get frequency of each fruit in b1 ,b2
//    and each basket shoudl have total/2 fruits
//    so we can get extra from both basket ans store to individual lists
//    b1 store how many extra fruits b1  have b2 store how many b2 have
//    we can find it using total/2 - b1freq if its less then 0
//    means other basket have extra fruits so put it in b2 extra lists
//    now just swap the max fruit with min we can sort both list one in ascending
//    second descending and get min at each index
//    last thing we can take 2 step to swap fuits too
//    using a the minimum fruit like this
//    Extra from basket1 = 10
//    Extra from basket2 = 15
//    Global minimum fruit cost = 2
//    Direct swap: cost = min(10, 15) = 10
//    Indirect swap:
//    Swap 10 with 2 → cost = 2
//    Swap 15 with 2 → cost = 2
//    Total = 4
//    Result: you effectively swapped 10 and 15, but total cost = 4 instead of 10.
//    time complexity : O(n)
//    space complexity : O(n)
    public static  long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer> b1 = new HashMap();
        HashMap<Integer,Integer> b2 = new HashMap();
        HashMap<Integer,Integer> total = new HashMap();
        long minVal=Integer.MAX_VALUE; // this will store global MIN fruit so that instead of swapping
        // from extra fruit we can swap 2 fruits in 2 step using global minimum
        List<Integer> extra1= new ArrayList();
        List<Integer> extra2= new ArrayList();
        for(int x:basket1){
            b1.put(x,b1.getOrDefault(x,0)+1);
            total.put(x,total.getOrDefault(x,0)+1);
            minVal= Math.min(minVal,x);
        }
        for(int x:basket2){
            b2.put(x,b2.getOrDefault(x,0)+1);
            total.put(x,total.getOrDefault(x,0)+1);
            minVal= Math.min(minVal,x);
        }

        for(Map.Entry<Integer, Integer> e:total.entrySet()){
            int key= e.getKey();
            int val= e.getValue();
            if(val%2!=0){
                return -1;
            }
            // we can create extra here :
            int b1freq= b1.getOrDefault(key,0);
            int b2freq= b2.getOrDefault(key,0);
            int target = val/2;
            if(b1freq-target<0){// means b1 have less fruits then target
                for(int i =0;i<b2freq-target;i++){
                    extra2.add(key);
                }
            }else{
                for(int i =0;i<b1freq-target;i++){
                    extra1.add(key);
                }
            }
        }
        Collections.sort(extra1);
        Collections.sort(extra2, Collections.reverseOrder());
        long ans =0;
        for(int i=0;i<extra1.size();i++){
            // here we can see we can swap furit directly using extra or using a minimum fruit
            long globalminfruitswap = 2*minVal;
            ans += Math.min(Math.min(extra1.get(i), extra2.get(i)),globalminfruitswap);
        }
        return ans;
    }
    public static void main(String[] args) {

    //Example 1:

    int [] basket11 = {4,2,2,2}, basket12 = {1,4,1,2};
    int output1=1;

    //Example 2:

    int [] basket21 = {2,3,4,1}, basket22 = {3,2,5,1};
    int output2=-1;

    long ans1 =minCost(basket11,basket12);
    long ans2 =minCost(basket21,basket22);

        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }


    }
}
