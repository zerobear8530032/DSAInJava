//2342. Max Sum of a Pair With Equal Sum of Digits
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
//
//Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
//

//Example 1:
//
//Input: nums = [18,43,36,13,7]
//Output: 54
//Explanation: The pairs (i, j) that satisfy the conditions are:
//- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
//- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
//So the maximum sum that we can obtain is 54.
//Example 2:
//
//Input: nums = [10,12,19,14]
//Output: -1
//Explanation: There are no two numbers that satisfy the conditions, so we return -1.
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 109
package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class MaxSumofPairWithEqualSumofDigits_2342 {
	
//	brute force approch :
//	use nested loop and check every single pair and calcualte sum of digits 
	
	 public static int maximumSumBruteForce(int[] nums) {
		    int ans =-1;// default ans =-1
		    for(int i =0;i<nums.length;i++){
		    	for(int j=i+1;j<nums.length;j++) {
		    		if(sumDigit(nums[i])==sumDigit(nums[j])) {
		    			ans=Math.max(ans,nums[i]+nums[j]);
		    		}
		    	}
		    }
		    return ans;// this will return -1 if no such pair found else max sum of 2 number
		    }

		    
		
	
	
//	optimie approch :
//	we use a hash map where key = sum of digits and value = nums[i]
//	check if the key exists in map means we have seen that sum already them we 
//	just need to get the max pair their 
	
	public static int maximumSumOptimize(int[] nums) {
	    HashMap <Integer,Integer> map = new HashMap();// herer key = sumof digits , value= nums[i]
	    int ans =-1;// default ans =-1
	    for(int i =0;i<nums.length;i++){
	        int sum = sumDigit(nums[i]);// get the sum of digits 
	        if(map.containsKey(sum)){// check the key exists in the map 
	            ans = Math.max(ans,nums[i]+map.get(sum));// here if the key exists means the nums[i] having same sum of digits as some other number which already exists in the map so we update the prev ans with new pair if its greater then previous 
	            if(map.get(sum)<nums[i]){// here we also check the value present at the sum key is largest because we need to give the largest sum 
	                map.put(sum,nums[i]);// here we update with new value
	            }
	        }else{
	            map.put(sum,nums[i]);// if the key does not exists means we are encountering that sum first time 
	        }
	    }
	    return ans;// this will return -1 if no such pair found else max sum of 2 number
	    }

	    public static int sumDigit(int n){
	        int sum =0;
	        while(n!=0){
	            sum+=n%10;
	            n/=10;
	        }
	        return sum;
	    }
	

	public static void main(String[] args) {
		
		
		//Example 1:
		
		int [] nums1 = {18,43,36,13,7};
		int output1=54;
		
		//Example 2:

		int [] nums2 = {10,12,19,14};
		int output2=-1;
		
		System.out.println("Brute approch:");
		
		int ans1= maximumSumBruteForce(nums1);
		int ans2= maximumSumBruteForce(nums2);
		
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
		
		System.out.println("Optimize approch:");
		
		ans1= maximumSumOptimize(nums1);
		ans2= maximumSumOptimize(nums2);
		
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
