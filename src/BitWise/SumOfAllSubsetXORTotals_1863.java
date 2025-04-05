//1863. Sum of All Subset XOR Totals
//Solved
//Easy
//Topics
//Companies
//Hint
//The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.
//
//For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
//Given an array nums, return the sum of all XOR totals for every subset of nums. 
//
//Note: Subsets with the same elements should be counted multiple times.
//
//An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
//
// 
//
//Example 1:
//
//Input: nums = [1,3]
//Output: 6
//Explanation: The 4 subsets of [1,3] are:
//- The empty subset has an XOR total of 0.
//- [1] has an XOR total of 1.
//- [3] has an XOR total of 3.
//- [1,3] has an XOR total of 1 XOR 3 = 2.
//0 + 1 + 3 + 2 = 6
//Example 2:
//
//Input: nums = [5,1,6]
//Output: 28
//Explanation: The 8 subsets of [5,1,6] are:
//- The empty subset has an XOR total of 0.
//- [5] has an XOR total of 5.
//- [1] has an XOR total of 1.
//- [6] has an XOR total of 6.
//- [5,1] has an XOR total of 5 XOR 1 = 4.
//- [5,6] has an XOR total of 5 XOR 6 = 3.
//- [1,6] has an XOR total of 1 XOR 6 = 7.
//- [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
//0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
//Example 3:
//
//Input: nums = [3,4,5,6,7,8]
//Output: 480
//Explanation: The sum of all XOR totals for every subset is 480.
// 
//
//Constraints:
//
//1 <= nums.length <= 12
//1 <= nums[i] <= 20

package BitWise;

import java.util.ArrayList;
import java.util.List;

class SumOfAllSubsetXORTotals_1863 {
//	brute force : approch :
//	we can use the brute force approch to find all subset of entier array then apply XOR on each element and last just 
//	sum them up at last
//	time complexity : O(2^n*n)
//	space complexity : O(2^n*n)
    public static int subsetXORSumBruteForce(int[] nums) {
        List<List<Integer>> subsets= getAllSubSet(nums);
        int sum =0;
        for(List<Integer> subset : subsets){
            int XOR =0;
            for(int x:subset){
                XOR^=x;
            }
            sum+=XOR;
        }
        return sum;
        
    }
    public static List<List<Integer>> getAllSubSet(int [] nums){
        List<List<Integer>> subsets= new ArrayList();
        int end= (int)Math.pow(2,nums.length);
        for(int i =1;i<end;i++){
            String str= Integer.toBinaryString(i);
            List<Integer> subset= new ArrayList();
            int index=0;
            for(int j=str.length()-1;j>=0;j--){
                if(str.charAt(j)=='1'){
                    subset.add(nums[index]);
                }
                index++;
            }
            subsets.add(subset);
        }
        return subsets;
    }
    
//    better approch :
//    we can just find the  XOR of entier sub set rather then creating a list of subset element while creating the subset
//	time complexity : O(2^n*n)
//	space complexity : O(2^n)
    public static int subsetXORSumBetter(int[] nums) {
            List<Integer>subsetsXOR= getAllSubSetXOR(nums);
            int sum =0;
            for(int  XOR : subsetsXOR){
                sum+=XOR;
            }
            return sum;
            
        }
        public static List<Integer> getAllSubSetXOR(int [] nums){
            List<Integer> subsets= new ArrayList();
            int end= (int)Math.pow(2,nums.length);
            for(int i =1;i<end;i++){
                String str= Integer.toBinaryString(i);
                int subsetXOR=0;
                int index=0;
                for(int j=str.length()-1;j>=0;j--){
                    if(str.charAt(j)=='1'){
                        subsetXOR^=nums[index];
                    }
                    index++;
                }
                subsets.add(subsetXOR);
            }
            return subsets;
        }
        
//   Optimize approch :
//  we can remove the requirement of using the binary string of number to find subset we can use a bitmask
//	time complexity : O(2^n*n)
//	space complexity : O(2^n)
        public static int subsetXORSumOptimze(int[] nums) {
        	List<Integer>subsetsXOR= getAllSubSetXOROptimize(nums);
        	int sum =0;
        	for(int  XOR : subsetsXOR){
        		sum+=XOR;
        	}
        	return sum;
        	
        }
        public static List<Integer> getAllSubSetXOROptimize(int [] nums){
        	List<Integer> subsets= new ArrayList();
        	int n = nums.length;
        	int total = 1 << n;  // 2^n subsets
        	for(int mask =0;mask<total;mask++){
        		int subsetXOR=0;
        		for(int i=0;i<n;i++){
        			if((mask& (1<<i))!=0) {
        				subsetXOR^=nums[i];
        			}
        		}
        		subsets.add(subsetXOR);
        	}
        	return subsets;
        }

    
    
    public static void main(String[] args) {
    	//Example 1:

    	int [] nums1 = {1,3};
    	int output1=6;
    	
    	//Example 2:

    	int [] nums2 = {5,1,6};
    	int output2=28;
    	
    	//Example 3:
    	
    	int [] nums3 = {3,4,5,6,7,8};
    	int output3=480;
    	
    	System.out.println("Brute Force Approch :");
    	
		int ans1= subsetXORSumBruteForce(nums1);	
		int ans2= subsetXORSumBruteForce(nums2);	
		int ans3= subsetXORSumBruteForce(nums3);	
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
		System.out.println("Best Approch :");
		 	
		ans1= subsetXORSumBetter(nums1);	
		ans2= subsetXORSumBetter(nums2);	
		ans3= subsetXORSumBetter(nums3);	
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
		System.out.println("Optimize Approch :");
		
		ans1= subsetXORSumOptimze(nums1);	
		ans2= subsetXORSumOptimze(nums2);	
		ans3= subsetXORSumOptimze(nums3);	
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}

    
    }

}