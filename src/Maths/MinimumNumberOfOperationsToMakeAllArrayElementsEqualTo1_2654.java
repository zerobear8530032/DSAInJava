//2654. Minimum Number of Operations to Make All Array Elements Equal to 1
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a 0-indexed array nums consisiting of positive integers. You can do the following operation on the array any number of times:
//
//Select an index i such that 0 <= i < n - 1 and replace either of nums[i] or nums[i+1] with their gcd value.
//Return the minimum number of operations to make all elements of nums equal to 1. If it is impossible, return -1.
//
//The gcd of two integers is the greatest common divisor of the two integers.
//
//
//
//Example 1:
//
//Input: nums = [2,6,3,4]
//Output: 4
//Explanation: We can do the following operations:
//- Choose index i = 2 and replace nums[2] with gcd(3,4) = 1. Now we have nums = [2,6,1,4].
//- Choose index i = 1 and replace nums[1] with gcd(6,1) = 1. Now we have nums = [2,1,1,4].
//- Choose index i = 0 and replace nums[0] with gcd(2,1) = 1. Now we have nums = [1,1,1,4].
//- Choose index i = 2 and replace nums[3] with gcd(1,4) = 1. Now we have nums = [1,1,1,1].
//Example 2:
//
//Input: nums = [2,10,6,14]
//Output: -1
//Explanation: It can be shown that it is impossible to make all the elements equal to 1.
//
//
//Constraints:
//
//2 <= nums.length <= 50
//1 <= nums[i] <= 106
package Maths;

public class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1_2654 {
//    approch :
//    we know 1 thing if the single element is 1
//    inside the array we can make rest of array to 1 in n-count of 1 operations
//    and if no 1 is there we can can create 1 using gcd of 2 numbers
//    so here we can use a property of gcd which  is associativity
//    where is gcd(a,b,c) = gcd(gcd(a,b),c)// simple order does not matter her e
//    so we can just check for every sub array which create the gcd of 1
//    and take that many operations which is the subarray we use to creat the gcd -1
//    and sum it with n-1
//    time complexity : O(n * log (x)+ n^2 * log(x));
//    space complexity : O(1)
    public static int minOperations(int[] nums) {
        int countOnes=0;
        int gcd=0;
        for(int x:nums){
            if(x==1){
                countOnes++;
            }
            gcd=gcd(gcd,x);
        }
        if(gcd>1){return -1;}
        if(countOnes>0){return nums.length-countOnes;}
        int minSubArray=Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            int curr_GCD= 0;
            for(int j =i;j<nums.length;j++){
                if(j-i+1 >=minSubArray){break;}// already have smaller subarray
                curr_GCD= gcd(curr_GCD,nums[j]);
                if(curr_GCD==1){
                    int size = j-i+1;
                    minSubArray= size;
                    break;
                }
            }
        }

        if(minSubArray==Integer.MAX_VALUE){
            return -1;
        }
        return (minSubArray-1)+nums.length-1;
    }
    public static int gcd(int a , int b){
        while(a>0 && b>0){
            a= a%b;
            int temp = a;
            a=b;
            b=temp;
        }
        return Math.max(a,b);
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {2,6,3,4};
        int output1= 4;

        //Example 2:

        int [] nums2 = {2,10,6,14};
        int output2= -1;

        int ans1 = minOperations(nums1);
        int ans2 = minOperations(nums2);
        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }



    }
}
