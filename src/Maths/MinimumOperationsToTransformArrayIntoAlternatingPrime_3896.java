//3896. Minimum Operations to Transform Array into Alternating Prime
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given an integer array nums.
//
//An array is considered alternating prime if:
//
//Elements at even indices (0-based) are prime numbers.
//Elements at odd indices are non-prime numbers.
//In one operation, you may increment any element by 1.
//
//Return the minimum number of operations required to transform nums into an alternating prime array.
//
//A prime number is a natural number greater than 1 with only two factors, 1 and itself.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//
//Output: 3
//
//Explanation:
//
//The element at index 0 must be prime. Increment nums[0] = 1 to 2, using 1 operation.
//The element at index 1 must be non-prime. Increment nums[1] = 2 to 4, using 2 operations.
//The element at index 2 is already prime.
//The element at index 3 is already non-prime.
//Total operations = 1 + 2 = 3.
//
//Example 2:
//
//Input: nums = [5,6,7,8]
//
//Output: 0
//
//Explanation:
//
//The elements at indices 0 and 2 are already prime.
//The elements at indices 1 and 3 are already non-prime.
//No operations are needed.
//
//Example 3:
//
//Input: nums = [4,4]
//
//Output: 1
//
//Explanation:
//
//The element at index 0 must be prime. Increment nums[0] = 4 to 5, using 1 operation.
//The element at index 1 is already non-prime.
//Total operations = 1.
//
//
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 105
package Maths;

import java.util.ArrayList;
import java.util.List;

public class MinimumOperationsToTransformArrayIntoAlternatingPrime_3896 {
    public static int minOperations(int[] nums) {
        boolean [] scieve = new boolean [20_000_0];
        scieve[0]=true;
        scieve[1]=true;
        int res=0;
        for(int i=2;i*i<=scieve.length;i++){
            if(scieve[i]){continue;}
            for(int j=i*i;j<scieve.length;j=j+i){
                scieve[j]=true;
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i=2;i<scieve.length;i++){
            if(!scieve[i] ) {primes.add(i);}
        }
        // System.out.println(primes);
        for(int i=0;i<nums.length;i++){
            // System.out.println(nums[i] + "  " + scieve[nums[i]]);
            if(i%2==0 && scieve[nums[i]]){
                // System.out.println("even");
                int idx=binarySearch(primes,nums[i]);
                res+= primes.get(idx)-nums[i];
                // System.out.println("even "+res);
            }else if(i%2!=0 && !scieve[nums[i]]){
                // System.out.println("odd");
                if(nums[i]<=3){
                    res+=4-nums[i];
                }else{
                    res++;
                }
                // System.out.println("odd "+res);
            }
        }
        return res;
    }
    public static int binarySearch(List<Integer> prime ,int target ) {
        int s =0;
        int e = prime.size()-1;
        int i =0;
        while(s<=e){
            int mid = (e+s)/2;
            if(target < prime.get(mid)){e=mid-1;}
            else if(target > prime.get(mid)){s=mid+1;}
            else{return mid;}
        }
        return s;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,3,4};
        int output1= 3;

        //Example 2:

        int [] nums2 = {5,6,7,8};
        int output2= 0;

        //Example 3:

        int [] nums3 = {4,4};
        int output3= 1;

        int ans1= minOperations(nums1);
        int ans2= minOperations(nums2);
        int ans3= minOperations(nums3);
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

    }
}
