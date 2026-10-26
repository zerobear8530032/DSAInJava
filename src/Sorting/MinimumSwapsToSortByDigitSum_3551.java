//3551. Minimum Swaps to Sort by Digit Sum
//Attempted
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array nums of distinct positive integers. You need to sort the array in increasing order based on the sum of the digits of each number. If two numbers have the same digit sum, the smaller number appears first in the sorted order.
//
//Return the minimum number of swaps required to rearrange nums into this sorted order.
//
//A swap is defined as exchanging the values at two distinct positions in the array.
//
//
//
//Example 1:
//
//Input: nums = [37,100]
//
//Output: 1
//
//Explanation:
//
//Compute the digit sum for each integer: [3 + 7 = 10, 1 + 0 + 0 = 1] → [10, 1]
//Sort the integers based on digit sum: [100, 37]. Swap 37 with 100 to obtain the sorted order.
//Thus, the minimum number of swaps required to rearrange nums is 1.
//Example 2:
//
//Input: nums = [22,14,33,7]
//
//Output: 0
//
//Explanation:
//
//Compute the digit sum for each integer: [2 + 2 = 4, 1 + 4 = 5, 3 + 3 = 6, 7 = 7] → [4, 5, 6, 7]
//Sort the integers based on digit sum: [22, 14, 33, 7]. The array is already sorted.
//Thus, the minimum number of swaps required to rearrange nums is 0.
//Example 3:
//
//Input: nums = [18,43,34,16]
//
//Output: 2
//
//Explanation:
//
//Compute the digit sum for each integer: [1 + 8 = 9, 4 + 3 = 7, 3 + 4 = 7, 1 + 6 = 7] → [9, 7, 7, 7]
//Sort the integers based on digit sum: [16, 34, 43, 18]. Swap 18 with 16, and swap 43 with 34 to obtain the sorted order.
//Thus, the minimum number of swaps required to rearrange nums is 2.
//
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 109
//nums consists of distinct positive integers.
package Sorting;


import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumSwapsToSortByDigitSum_3551 {
//    approch :
//    here we copy entire array sort it inthe required order
//    now we know where each element position will be
//    now we can check current element position by maintina a hashmap
//    then we can just put it in the position we get from the sorted array
//    we got our swap counts
//    time complexity : O( n log n)
//    space complexity : O( n )
    public static int minSwaps(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2)->{
            int sum1= digitSum(i1);
            int sum2= digitSum(i2);
            if(sum1==sum2){
                return i1-i2;
            }
            return sum1-sum2;
        });
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            indexMap.put(nums[i],i);
            queue.add(nums[i]);
        }
        int idx=0;
        int swaps=0;
        while(!queue.isEmpty()){
            int num = queue.poll();
            int index= indexMap.get(num);
            if(index==idx){
                idx++;
                continue;
            }else{
                System.out.println(num+" "+idx+" "+index+" "+nums[idx]);
                System.out.println(indexMap);
                indexMap.put(num,idx);
                indexMap.put(nums[idx],index);
                swap(nums,index,idx);
                idx++;
                swaps++;
            }
        }

        return swaps;
    }

    public static void swap(int [] nums , int l, int r){
        int temp = nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }

    public static int digitSum(int n){
        int x =n;
        int sum =0;
        while(x!=0){
            sum+= x%10;
            x/=10;
        }
        // System.out.println(sum+" "+x);
        return sum;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {37,100};
        int output1=1;
        //Example 2:

        int [] nums2 = {22,14,33,7};
        int output2=0;

        //Example 3:

        int [] nums3 = {18,43,34,16};
        int output3= 2;

        //Example 4:

        int [] nums4 = {1};
        int output4 =2;

        int ans1= minSwaps(nums1);
        int ans2= minSwaps(nums2);
        int ans3= minSwaps(nums3);
        int ans4= minSwaps(nums4);

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
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }
        if(output4==ans4) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Actual Output :"+output4);
            System.out.println("Your Output :"+ans4);
        }

    }
}
