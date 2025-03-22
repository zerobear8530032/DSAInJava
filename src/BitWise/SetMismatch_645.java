///*645. Set Mismatch
//Solved
//Easy
//Topics
//Companies
//You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
//
//You are given an integer array nums representing the data status of this set after the error.
//
//Find the number that occurs twice and the number that is missing and return them in the form of an array.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,2,4]
//Output: [2,3]
//Example 2:
//
//Input: nums = [1,1]
//Output: [1,2]
// 
//
//Constraints:
//
//2 <= nums.length <= 104
//1 <= nums[i] <= 104*/



package BitWise;

import java.util.Arrays;

public class SetMismatch_645 {
//	brute force approch :
//	sort the array and we will get answer :
//	then we can check i , i+1 if that is equal
//	we got our repeated number we want to find
//	number which is missing so 
//	its just sum of all number in from 1 to n -  sum of all number ;
	
//  time complexity O(N log n)
//  space complexity O(1)
	
	
	public static int[] findErrorNumsBruteForce(int[] nums) {
      Arrays.sort(nums);
      int n = nums.length;
      int arrsum=0;
      for(int x:nums) {
    	  arrsum+=x;
      }
      for(int i =0;i<n-1;i++) {
    	  if(nums[i]==nums[i+1]) {
    		  int repeating= nums[i];
    		  int totalsum = n*(n+1)/2;
    		  arrsum= arrsum-repeating;
    		  int missing = totalsum-arrsum;
    		  
    		  return new int[]{repeating,missing};
    	  }
      }
      return new int[] {-1,-1};
    }
	
//	Better approch :
//	here we can create a frequency array while taking the sum
//	then we can just get the value number which have value as 1
//	we got our repeated number we want to find
//	number which is missing so 
//	its just missing +1 because rest number is from 1 to n
//  time complexity O(N)
//  space complexity O(N)
	
	
	public static int[] findErrorNumsBetter(int[] nums) {
		int [] map = new int [nums.length];
		int arrsum=0;
		for(int x:nums) {
			map[x-1]++;
			arrsum+=x;
		}
		int n = nums.length;
		for(int i =0;i<map.length;i++) {
			if(map[i]==2) {
				int repeating = i+1;
				 int totalsum = n*(n+1)/2;
	    		  arrsum= arrsum-repeating;
	    		  int missing = totalsum-arrsum;
	    		  return new int[]{repeating,missing};
			}
		}
		return new int [] {-1,-1};
		
	}
	
	
//	Better approch :
//	we can use count sort instead of using the normal sort to sort array and
//	no extra space is required
//	after counting sort we can get duplicate element 
//	we will use same approch to get missing
//	number which is missing so 
//	its just missing +1 because rest number is from 1 to n
//  time complexity O(n)
//  space complexity O(1)
	
	
	public static int[] findErrorNumsCountingSort(int[] nums) {
		int i =0;
		int n = nums.length;
		
		while(i<n) {
			int correct=nums[i]-1;
		   if(nums[i]!=nums[correct]) {
			   int t = nums[i];
			   nums[i]=nums[correct];
			   nums[correct]=t;
		   }else {
			   i++;
		   }
		}
		int repeating =-1;
		for(i =0;i<n;i++) {
			if(nums[i]!= i+1) {
				return new int []{nums[i],i+1};
			}
		}
		return new int [] {-1,-1};
	}
	
//	Best approch :
//	we can use xor operator which 
//	no extra space is required
//	after counting sort we can get duplicate element 
//	we will use same approch to get missing
//	number which is missing so 
//	its just missing +1 because rest number is from 1 to n
//  time complexity O(n)
//  space complexity O(1)
	
	
	public static int[] findErrorNumsBest(int[] nums) {
		       
		        int xorAll = 0, n = nums.length;

		        // Step 1: XOR all numbers in nums and 1 to n
		        
		        for (int i = 1; i <= n; i++) {
		            xorAll^=nums[i-1];
		            xorAll ^= i;
		        }

		        // Step 2: Find rightmost set bit
		        int rightmostBit = xorAll & -xorAll;
		        int xor1 = 0, xor2 = 0;

		        // Step 3: Split numbers into two groups and XOR separately
		        for (int num : nums) {
		            if ((num & rightmostBit) != 0) {
		                xor1 ^= num;
		            } else {
		                xor2 ^= num;
		            }
		        }

		        for (int i = 1; i <= n; i++) {
		            if ((i & rightmostBit) != 0) {
		                xor1 ^= i;
		            } else {
		                xor2 ^= i;
		            }
		        }

		        // Step 4: Identify duplicate and missing
		        for (int num : nums) {
		            if (num == xor1) {
		                return new int[]{xor1, xor2}; // [Duplicate, Missing]
		            }
		        }
		        return new int[]{xor2, xor1}; // [Duplicate, Missing]
		    }
		 
	
	public static boolean check(int [] nums,int [] output) {
		if(nums.length!=output.length) {
			return false;
		}
		for(int i =0;i<nums.length;i++) {
			if(nums[i]!=output[i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
			
		//Example 1:

		int []nums1 = {1,2,2,4};
		int []output1= {2,3};

		//Example 2:
		int []nums2 = {1,1};
		int []output2= {1,2};
	
		
		System.out.println("Brute Force Approch :");
		
		int []ans1 =findErrorNumsBruteForce(nums1.clone());
		int []ans2 = findErrorNumsBruteForce(nums2.clone());
		
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}			
		
		System.out.println("Better Force Approch :");
		
		ans1 = findErrorNumsBetter(nums1.clone());
		ans2 = findErrorNumsBetter(nums2.clone());
		
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}
		
		System.out.println("Counting sort Approch :");
		
		ans1 = findErrorNumsCountingSort(nums1.clone());
		ans2 = findErrorNumsCountingSort(nums2.clone());
		
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}
		
		
		
		System.out.println("Best Approch :");
		
		ans1 = findErrorNumsBest(nums1.clone());
		ans2 = findErrorNumsBest(nums2.clone());
		
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}
		
	

	}

}
