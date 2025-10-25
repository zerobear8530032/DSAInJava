//Last Stone Weight
//Solved
//You are given an array of integers stones where stones[i] represents the weight of the ith stone.
//
//We want to run a simulation on the stones as follows:
//
//At each step we choose the two heaviest stones, with weight x and y and smash them togethers
//If x == y, both stones are destroyed
//If x < y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
//Continue the simulation until there is no more than one stone remaining.
//
//Return the weight of the last remaining stone or return 0 if none remain.
//
//Example 1:
//
//Input: stones = [2,3,6,2,4]
//
//Output: 1
//Explanation:
//We smash 6 and 4 and are left with a 2, so the array becomes [2,3,2,2].
//We smash 3 and 2 and are left with a 1, so the array becomes [1,2,2].
//We smash 2 and 2, so the array becomes [1].
//
//Example 2:
//
//Input: stones = [1,2]
//
//Output: 1
//Constraints:
//
//1 <= stones.length <= 20
//1 <= stones[i] <= 100
package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight_NEETCODE {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap= new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2.compareTo(o1);
            }
        });
        for(int x:stones){
            maxheap.add(x);
        }
        while(maxheap.size()>1){
            int n1 = maxheap.remove();
            int n2 = maxheap.remove();
            if(n1!=n2){
                maxheap.add(Math.abs(n1-n2));
            }
        }
        if(maxheap.size()==1){
            return maxheap.remove();
        }
        return 0;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] stones1 = {2,3,6,2,4};
        int output1= 1;

        //Example 2:

        int [] stones2 = {1,2};
        int output2= 1;

        int ans1= lastStoneWeight(stones1);
        int ans2 = lastStoneWeight(stones2);


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

    }
}
