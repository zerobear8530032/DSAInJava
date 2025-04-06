//368. Largest Divisible Subset
//Medium
//Topics
//Companies
//Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
//
//answer[i] % answer[j] == 0, or
//answer[j] % answer[i] == 0
//If there are multiple solutions, return any of them.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,3]
//Output: [1,2]
//Explanation: [1,3] is also accepted.
//Example 2:
//
//Input: nums = [1,2,4,8]
//Output: [1,2,4,8]
// 
//
//Constraints:
//
//1 <= nums.length <= 1000
//1 <= nums[i] <= 2 * 109
//All the integers in nums are unique.


package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

class LargestDivisibleSubset_368 {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
     List<Integer> ans = new ArrayList<Integer>();
     int currMax=0;
     for(int i =0;i<nums.length;i++){
        List<Integer> subset= new ArrayList();
        subset.add(nums[i]);
        for(int j=i+1;j<nums.length;j++){
            if(valid(subset,nums[j])){
                subset.add(nums[j]);
            }
        }
        if(currMax<subset.size()){
            ans= subset;
            currMax=ans.size();
        }
     }

     return ans;   
    }
    public static  boolean valid(List<Integer> nums,int x){
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)%x!=0 && x%nums.get(i)!=0) {
            	return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
    	//Example 1:
    	//
    	int [] nums1 = {1,2,3};
    	int [] output1= {1,2};

    	//Example 2:
    	//
    	int [] nums2 = {1,2,4,8};
    	int [] output2= {1,2,4,8};
    	
    	System.out.println(largestDivisibleSubset(nums1));

	}
}