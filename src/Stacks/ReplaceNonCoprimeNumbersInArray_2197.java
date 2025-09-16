//2197. Replace Non-Coprime Numbers in Array
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array of integers nums. Perform the following steps:
//
//Find any two adjacent numbers in nums that are non-coprime.
//If no such numbers are found, stop the process.
//Otherwise, delete the two numbers and replace them with their LCM (Least Common Multiple).
//Repeat this process as long as you keep finding two adjacent non-coprime numbers.
//Return the final modified array. It can be shown that replacing adjacent non-coprime numbers in any arbitrary order will lead to the same result.
//
//The test cases are generated such that the values in the final array are less than or equal to 108.
//
//Two values x and y are non-coprime if GCD(x, y) > 1 where GCD(x, y) is the Greatest Common Divisor of x and y.
//
//
//
//Example 1:
//
//Input: nums = [6,4,3,2,7,6,2]
//Output: [12,7,6]
//Explanation:
//- (6, 4) are non-coprime with LCM(6, 4) = 12. Now, nums = [12,3,2,7,6,2].
//- (12, 3) are non-coprime with LCM(12, 3) = 12. Now, nums = [12,2,7,6,2].
//- (12, 2) are non-coprime with LCM(12, 2) = 12. Now, nums = [12,7,6,2].
//- (6, 2) are non-coprime with LCM(6, 2) = 6. Now, nums = [12,7,6].
//There are no more adjacent non-coprime numbers in nums.
//Thus, the final modified array is [12,7,6].
//Note that there are other ways to obtain the same resultant array.
//Example 2:
//
//Input: nums = [2,2,1,1,3,3,3]
//Output: [2,1,1,3]
//Explanation:
//- (3, 3) are non-coprime with LCM(3, 3) = 3. Now, nums = [2,2,1,1,3,3].
//- (3, 3) are non-coprime with LCM(3, 3) = 3. Now, nums = [2,2,1,1,3].
//- (2, 2) are non-coprime with LCM(2, 2) = 2. Now, nums = [2,1,1,3].
//There are no more adjacent non-coprime numbers in nums.
//Thus, the final modified array is [2,1,1,3].
//Note that there are other ways to obtain the same resultant array.
//
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 105
//The test cases are generated such that the values in the final array are less than or equal to 108.

package Stacks;

import java.util.*;

public class ReplaceNonCoprimeNumbersInArray_2197 {
    public static List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stk = new Stack();
        for (int x : nums) {
            long curr= x;
            while(!stk.isEmpty()){
                long top = stk.peek();
                long gcd = gcd( curr, top);
                if (gcd == 1) break; // coprime, stop merging
                curr = (curr * stk.pop()) / gcd; // merge into LCM
            }
            stk.push((int)curr);
        }
        List<Integer> res = new ArrayList();
        while (!stk.isEmpty()) {
            res.add(stk.pop());
        }
        Collections.reverse(res);
        return res;
    }

    public static long gcd(long a ,long b){
        if(b==0){return a;}
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {6,4,3,2,7,6,2};
        List<Integer> output1= new ArrayList<>(Arrays.asList(12,7,6));

        //Example 2:

        int [] nums2 = {2,2,1,1,3,3,3};
        List<Integer> output2= new ArrayList<>(Arrays.asList(2,1,1,3));

        List<Integer> ans1=replaceNonCoprimes(nums1);
        List<Integer> ans2= replaceNonCoprimes(nums2);

        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }


    }
}
