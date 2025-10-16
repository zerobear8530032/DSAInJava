//2598. Smallest Missing Non-negative Integer After Operations
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a 0-indexed integer array nums and an integer value.
//
//In one operation, you can add or subtract value from any element of nums.
//
//For example, if nums = [1,2,3] and value = 2, you can choose to subtract value from nums[0] to make nums = [-1,2,3].
//The MEX (minimum excluded) of an array is the smallest missing non-negative integer in it.
//
//For example, the MEX of [-1,2,3] is 0 while the MEX of [1,0,3] is 2.
//Return the maximum MEX of nums after applying the mentioned operation any number of times.
//
//
//
//Example 1:
//
//Input: nums = [1,-10,7,13,6,8], value = 5
//Output: 4
//Explanation: One can achieve this result by applying the following operations:
//- Add value to nums[1] twice to make nums = [1,0,7,13,6,8]
//- Subtract value from nums[2] once to make nums = [1,0,2,13,6,8]
//- Subtract value from nums[3] twice to make nums = [1,0,2,3,6,8]
//The MEX of nums is 4. It can be shown that 4 is the maximum MEX we can achieve.
//Example 2:
//
//Input: nums = [1,-10,7,13,6,8], value = 7
//Output: 2
//Explanation: One can achieve this result by applying the following operation:
//- subtract value from nums[2] once to make nums = [1,-10,0,13,6,8]
//The MEX of nums is 2. It can be shown that 2 is the maximum MEX we can achieve.
//
//
//Constraints:
//
//1 <= nums.length, value <= 105
//-109 <= nums[i] <= 109

package Maths;

import java.util.HashMap;

public class SmallestMissingNonNegativeIntegerAfterOperations_2598 {
//    approch :
//    here we just observer 3 things :
//    1 what is MEX : its the min integer which is not present in 0 to infinite range
//    now if all elements are positive and [0,1,2,3,4] the MEX = 5
//    cause 0 to 4 is present
//    now if all elements are positive and [1,2,3,4] the MEX = 0
//    cause 1 to 4 is present but 0 is not
//    2: now to get max MEX we need to make the array such as this [0,1,2,3....n-1]
//    so that the mex= n
//    3: now how can we find is is possible to make a number to equal to certain value by adding and substracting :
//    we can do this by taking mod nums[i]-x %value ==0 : make sure we able to make value x by adding or substracting value as much time we want
//     no the approch is simple we need to try to make every single element as 0 1 2 3 4 5 to get max MEX
//    so we can use a loop from 0 to n  and go on every value and try to make that number if its possible tp make it
//    we can mark it by swapping it to the index in array which  it will give us after operation  is applied
//    so the maximum MEX is possible in range of only 0 to n
//
//    time complexity : O(n*n)
//    space complexity : O(n)
       public static int findSmallestIntegerBruteForce(int[] nums, int value) {
            for(int mex =0;mex<nums.length;mex++){// here MEX is starting from 0
                boolean found =false;
                for(int i =mex;i<nums.length;i++){// if any number from current mex index till cannot be maded then current mex is our answer
                    if((nums[i]-mex)%value==0){// if its possible to make current MEX then we will put it at the index of MEX its porviding and exit the loop for next iteration
                        found = true;
                        swap(mex,i,nums);
                        break;
                    }
                }
                if(!found){return mex;}// if no one make current MEX its our answer
            }
            return nums.length;// at the end the length of array is the answer at max
        }

        public static void swap(int i, int j , int [] arr){
            int t= arr[i];
            arr[i]=arr[j];
            arr[j]=t;
        }

//    Best Approch :
//    here we use remainder instead of finding values of MEX
//    first we make an frequency map of remainder of all elements it should be positive only
//    so we can use ((x%value) +value) %value
//    after this we can start from 0 to n and find which MEX is possible in O(1) time by  a hashmap look up
//    because we have remainder we can check if current MEX %val is present in the hashmao
//    if yes we can use it to make current MEX
//
//    time complexity : O(n)
//    space complexity : O(n)
    public static int findSmallestIntegerBest(int[] nums, int value) {
        HashMap<Integer,Integer> remainderMap= new HashMap();
        for(int x:nums){
            int rem = ((x%value)+value)%value;
            remainderMap.put(rem,remainderMap.getOrDefault(rem,0)+1);
        }
        for(int MEX=0;MEX<=nums.length;MEX++){
            int rem = MEX%value;
            if(remainderMap.containsKey(rem) && remainderMap.get(rem)!=0 ){
                remainderMap.put(rem,remainderMap.get(rem)-1);
            }else{
                return MEX;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        //Example 1:

        int [] nums1 = {1,-10,7,13,6,8};
        int value1 = 5;
        int output1= 4;

        //Example 2:

        int [] nums2 = {1,-10,7,13,6,8};
        int value2 = 7;
        int output2= 2;

        System.out.println("BruteForce Approch :");

        int ans1=findSmallestIntegerBruteForce(nums1,value1);
        int ans2=findSmallestIntegerBruteForce(nums2,value2);
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

        System.out.println("Best Approch :");

        ans1=findSmallestIntegerBest(nums1,value1);
        ans2=findSmallestIntegerBest(nums2,value2);

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
