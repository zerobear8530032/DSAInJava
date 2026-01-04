//1390. Four Divisors
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. If there is no such integer in the array, return 0.
//
//
//
//Example 1:
//
//Input: nums = [21,4,7]
//Output: 32
//Explanation:
//21 has 4 divisors: 1, 3, 7, 21
//4 has 3 divisors: 1, 2, 4
//7 has 2 divisors: 1, 7
//The answer is the sum of divisors of 21 only.
//Example 2:
//
//Input: nums = [21,21]
//Output: 64
//Example 3:
//
//Input: nums = [1,2,3,4,5]
//Output: 0
//
//
//Constraints:
//
//1 <= nums.length <= 104
//1 <= nums[i] <= 105
package Maths;

public class FourDivisors_1390 {
//    approch : here we go through each number find the factorials in most efficeint way
//    if the factorials does not equal 4  we will return 0 from function if its 4 we will return sum of them
//    time complexity : O ( n* root(num))
//    space complexity : O( 1)
    public static int sumFourDivisors(int[] nums) {
        int res=0;
        for(int num:nums){
            int factorsSum= getFourFactorsSum(num);
            res+=factorsSum;
        }
        return res;
    }
    private static int getFourFactorsSum(int num){
        int sum =0;
        int count =0;
        for(int i =1;i*i<=num;i++){
            if(num%i==0){
                if(num/i != i){
                    sum+=i;
                    sum+= (num/i);
                    count+=2;
                }else{
                    sum+=i;
                    count+=1;
                }
            }
            if(count>4){
                return 0;
            }
        }

        return count ==4 ? sum :0;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {21,4,7};
        int output1 = 32;

        //Example 2:

        int [] nums2 = {21,21};
        int output2 = 64;

        //Example 3:

        int [] nums3 = {1,2,3,4,5};
        int output3 = 0;

        int ans1= sumFourDivisors(nums1);
        int ans2= sumFourDivisors(nums2);
        int ans3= sumFourDivisors(nums3);
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
