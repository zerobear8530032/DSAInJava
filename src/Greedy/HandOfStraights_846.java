//846. Hand of Straights
//Medium
//Topics
//premium lock icon
//Companies
//Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
//
//Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.
//
//
//
//Example 1:
//
//Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
//Output: true
//Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
//Example 2:
//
//Input: hand = [1,2,3,4,5], groupSize = 4
//Output: false
//Explanation: Alice's hand can not be rearranged into groups of 4.
//
//
//
//Constraints:
//
//1 <= hand.length <= 104
//0 <= hand[i] <= 109
//1 <= groupSize <= hand.length
//
//
//Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
package Greedy;

import java.util.TreeSet;

public class HandOfStraights_846 {
//    approch :
//    we can check if its possible to make k groups by n%groupsize ==0 ofnot its not possible
//    if possible then
//    here we  count frequency of each element and sort them by values
//     after that we cna just take smallest element and keep removing the next element untill group size i reach
//    if the next element is not valid we can return false
//    time complexity : O(n)
//    space complexity : O(max(nums))
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0){
            return false;
        }
        int [] nums= new int[10001];
        TreeSet<Integer> set = new TreeSet<>();
        for(int x:hand){
            nums[x]++;
            set.add(x);
        }
        int groups = n/groupSize;
        for(int i =0;i<groups;i++){
            if(set.isEmpty()){
                return false; // not required here
            }
            int lastIndex= set.first();
            for(int j=lastIndex;j<lastIndex+groupSize;j++){
                if(nums[j]<=0){
                    return false;
                }
                nums[j]--;
                if(nums[j]<=0){

                    set.remove(j);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] hand1 = {1,2,3,6,2,3,4,7,8};
        int groupSize1 = 3;
        boolean output1 = true;
        //Example 2:

        int [] hand2 = {1,2,3,4,5};
        int groupSize2 = 4;
        boolean output2 = false;


        boolean ans1= isNStraightHand(hand1,groupSize1);
        boolean ans2= isNStraightHand(hand2,groupSize2);


        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }

    }
}
