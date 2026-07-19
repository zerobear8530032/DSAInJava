//3867. Sum of GCD of Formed Pairs
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array nums of length n.
//
//Construct an array prefixGcd where for each index i:
//
//Let mxi = max(nums[0], nums[1], ..., nums[i]).
//prefixGcd[i] = gcd(nums[i], mxi).
//After constructing prefixGcd:
//
//Sort prefixGcd in non-decreasing order.
//Form pairs by taking the smallest unpaired element and the largest unpaired element.
//Repeat this process until no more pairs can be formed.
//For each formed pair, compute the gcd of the two elements.
//If n is odd, the middle element in the prefixGcd array remains unpaired and should be ignored.
//Return an integer denoting the sum of the GCD values of all formed pairs.
//
//The term gcd(a, b) denotes the greatest common divisor of a and b.
//
//
//Example 1:
//
//Input: nums = [2,6,4]
//
//Output: 2
//
//Explanation:
//
//Construct prefixGcd:
//
//i	nums[i]	mxi	prefixGcd[i]
//0	2	2	2
//1	6	6	6
//2	4	6	2
//prefixGcd = [2, 6, 2]. After sorting, it forms [2, 2, 6].
//
//Pair the smallest and largest elements: gcd(2, 6) = 2. The remaining middle element 2 is ignored. Thus, the sum is 2.
//
//Example 2:
//
//Input: nums = [3,6,2,8]
//
//Output: 5
//
//Explanation:
//
//Construct prefixGcd:
//
//i	nums[i]	mxi	prefixGcd[i]
//0	3	3	3
//1	6	6	6
//2	2	6	2
//3	8	8	8
//prefixGcd = [3, 6, 2, 8]. After sorting, it forms [2, 3, 6, 8].
//
//Form pairs: gcd(2, 8) = 2 and gcd(3, 6) = 3. Thus, the sum is 2 + 3 = 5.
//
//
//
//Constraints:
//
//1 <= n == nums.length <= 105
//1 <= nums[i] <= 10​​​​​​​9
package Maths;

import java.util.Arrays;

public class SumOfGCDOfFormedPairs_3867 {
//    approch :
//    here we can create a gcd function whih find gcd using euclidian method
//    rest we just have a running max and gcd we can create the prefixGCD
//    then we can just sort it and take first last index and take their gcd and sum it
//    and return answer
//    time complexity : N log n
//    space complexity : N
    public static long gcdSum(int[] nums) {
        long [] prefixGCD= new long [nums.length];
        int max= 0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            prefixGCD[i]= gcd(nums[i],max);
        }
        Arrays.sort(prefixGCD);
        long res=0;
        int s=0;
        int e = prefixGCD.length-1;
        while(s<e){
            res+= gcd(prefixGCD[s],prefixGCD[e]);
            s++;
            e--;
        }
        return res;
    }

    public static long gcd(long a ,long b){
        if (b == 0){
            return a;
        }
        else{
            return gcd (b, a % b);
        }

    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {2,6,4};
        long output1= 2L;

        //Example 2:

        int [] nums2 = {3,6,2,8};
        long output2= 5L;

        long ans1= gcdSum(nums1);
        long ans2= gcdSum(nums2);

        if(ans1==output1) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ (output1));
            System.out.println("Your Output : "+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ output2);
            System.out.println("Your Output : "+ ans2);
        }
    }
}
