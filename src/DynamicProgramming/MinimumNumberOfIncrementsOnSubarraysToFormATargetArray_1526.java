// 1526. Minimum Number of Increments on Subarrays to Form a Target Array
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array target. You have an integer array initial of the same size as target with all elements initially zeros.
//
//In one operation you can choose any subarray from initial and increment each value by one.
//
//Return the minimum number of operations to form a target array from initial.
//
//The test cases are generated so that the answer fits in a 32-bit integer.
//
//
//
//Example 1:
//
//Input: target = [1,2,3,2,1]
//Output: 3
//Explanation: We need at least 3 operations to form the target array from the initial array.
//[0,0,0,0,0] increment 1 from index 0 to 4 (inclusive).
//[1,1,1,1,1] increment 1 from index 1 to 3 (inclusive).
//[1,2,2,2,1] increment 1 at index 2.
//[1,2,3,2,1] target array is formed.
//Example 2:
//
//Input: target = [3,1,1,2]
//Output: 4
//Explanation: [0,0,0,0] -> [1,1,1,1] -> [1,1,1,2] -> [2,1,1,2] -> [3,1,1,2]
//Example 3:
//
//Input: target = [3,1,5,4,2]
//Output: 7
//Explanation: [0,0,0,0,0] -> [1,1,1,1,1] -> [2,1,1,1,1] -> [3,1,1,1,1] -> [3,1,2,2,2] -> [3,1,3,3,2] -> [3,1,4,4,2] -> [3,1,5,4,2].
//
//
//Constraints:
//
//1 <= target.length <= 105
//1 <= target[i] <= 105
package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray_1526 {
//    we can apply simple aoperation
//    where we find the longest sub array which have minimum values and when a subarray contains any single zero
//    we will divide the array in 2 sub array left and right not including 0 index values
//    repeat same on both subarray and usm every thing in output;
//    time complexity : O(n*n)
//    space complexity : O(n*n)

    public static int minNumberOperations(int[] target) {
        if(target.length==0){
            return 0;
        }
        int operations=0;
        int min = Integer.MAX_VALUE;
        List<Integer> ranges= new ArrayList<>();
        ranges.add(-1);
        for(int i=0;i<target.length;i++){
            min = Math.min(min,target[i]);
        }
        for(int i =0;i<target.length;i++){
            target[i]-=min;
            if(target[i]==0){ranges.add(i);}
        }
            ranges.add(target.length);


        for(int i=0;i<ranges.size()-1;i++){
            int l = ranges.get(i)+1;
            int r = ranges.get(i+1);
            int [] partition = Arrays.copyOfRange(target,l,r);
            operations+= minNumberOperations(partition);
        }

        return operations+min;
    }
//     we can be greeedy and we can take the longest sub arry we can get
//    time complexity : O(n)
//    space complexity : O(1)
    public static int minNumberOperationsBest(int[] target) {
        int res = target[0];
        for(int i=1;i<target.length;i++){
            if(target[i]>target[i-1]){
                res+= target[i]-target[i-1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] target1 = {1,2,3,2,1};
        int output1= 3;

        //Example 2:

        int [] target2 = {3,1,1,2};
        int output2= 4;

        //Example 3:

        int [] target3 = {3,1,5,4,2};
        int output3= 7;

        int ans1 =  minNumberOperations(target1 );
        int ans2 =  minNumberOperations(target2 );
        int ans3 =  minNumberOperations(target3 );

        System.out.println("Brute Force Approch :");

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
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }


        target1 =new int [] {1,2,3,2,1};
        target2 = new int [] {3,1,1,2};
        target3= new int [] {3,1,5,4,2};


        System.out.println("Best Approch :");
        ans1 =  minNumberOperationsBest(target1 );
         ans2 =  minNumberOperationsBest(target2 );
         ans3 =  minNumberOperationsBest(target3 );


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
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }


    }
}
