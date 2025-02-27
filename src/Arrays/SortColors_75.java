//75. Sort Colors
//Solved
//Medium
//Topics
//Companies
//Hint
//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//You must solve this problem without using the library's sort function.
//
// 
//
//Example 1:
//
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
//Example 2:
//
//Input: nums = [2,0,1]
//Output: [0,1,2]
// 
//
//Constraints:
//
//n == nums.length
//1 <= n <= 300
//nums[i] is either 0, 1, or 2.
// 
//
//Follow up: Could you come up with a one-pass algorithm using only constant extra space?


package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class SortColors_75 {
//	brute force approch using sorting algo : 
//	using sorting is not allowed that why it is not a good approch :
//	time complexity :O(n log n)
//	space complexity :O(1)
	 public static void sortColorsBruteForce(int[] nums) {
		Arrays.sort(nums);
	    }
//	Better force approch using sorting algo : 
//	using a hashmap and keep track of frequency :
//	time complexity :O(n )
//	space complexity :O(1)-> even using hashmap will not get more then more then 3 values
	 
	 public static void sortColorsBetter(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap();
		for(int i =0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			}else {
				map.put(nums[i], 1);
			}
		}
		//		fill the array :
		int color1= map.getOrDefault(0,0);
		int i=0;
		for(int f=0;f<color1;f++) {
			nums[i]=0;
			i++;
		}
		int color2= map.getOrDefault(1,0);
		for(int f=0;f<color2;f++) {
			nums[i]=1;
			i++;
		}
		int color3= map.getOrDefault(2,0);
		for(int f=0;f<color3;f++) {
				nums[i]=2;
			i++;
		}
	 }

//	Best approch using sorting algo : 
//	using a hashmap and keep track of frequency will use more extra space
//	 we can use a single variable for each color c1,c2,c3 and rest is same
//	time complexity :O(n )
//	space complexity :O(1)
//	 
	 public static void sortColorsBest(int[] nums) { 
		 int c1=0,c2=0,c3=0;
		 for(int i =0;i<nums.length;i++) {
			 if(nums[i]==0) {
				 c1++;
			 }
			 if(nums[i]==1) {
				 c2++;
			 }
			 if(nums[i]==2) {
				 c3++;
			 }
		 }
		 int i =0;
		 for(int f =0;f<c1;f++) {
			 nums[i]=0;
			 i++;
		 }
		 for(int f =0;f<c2;f++) {
			 nums[i]=1;
			 i++;
		 }
		 for(int f =0;f<c3;f++) {
			 nums[i]=2;
			 i++;
		 }
		 
	 }
	    public static boolean check(int [] arr1, int [] arr2) {
			if(arr1.length!=arr2.length) {
				return false;
			}
			for(int i =0;i<arr1.length;i++) {
				if(arr1[i]!=arr2[i]) {
					return false;
				}
			}
			
			return true;
		}
	 
	public static void main(String[] args) {
		//Example 1:

		int []nums1 = {2,0,2,1,1,0};
		int []output1= {0,0,1,1,2,2};

		//Example 2:
		
		int []nums2 = {2,0,1};
		int []output2= {0,1,2};
		
		System.out.println("Brute Force Approch :");
		
		sortColorsBruteForce(nums1);
		sortColorsBruteForce(nums2);
		
		 if(check(nums1,output1)) {
				System.out.println("Case 1 Passed ");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output1));
				System.out.println("Your Output : "+ Arrays.toString(nums1));
			}
			if(check(nums2,output2)) {
				System.out.println("Case 2 Passed ");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output2));
				System.out.println("Your Output : "+ Arrays.toString(nums2));
			}
			
			nums1=new int [] {2,0,2,1,1,0};
			nums2=new int [] {2,0,1};
			
			System.out.println("Better Force Approch :");
		
			sortColorsBetter(nums1);
			sortColorsBetter(nums2);
			
			if(check(nums1,output1)) {
				System.out.println("Case 1 Passed ");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output1));
				System.out.println("Your Output : "+ Arrays.toString(nums1));
			}
			if(check(nums2,output2)) {
				System.out.println("Case 2 Passed ");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output2));
				System.out.println("Your Output : "+ Arrays.toString(nums2));
			}
			
			nums1=new int [] {2,0,2,1,1,0};
			nums2=new int [] {2,0,1};
			
			System.out.println("Better Force Approch :");
			
			sortColorsBest(nums1);
			sortColorsBest(nums2);
			
			if(check(nums1,output1)) {
				System.out.println("Case 1 Passed ");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output1));
				System.out.println("Your Output : "+ Arrays.toString(nums1));
			}
			if(check(nums2,output2)) {
				System.out.println("Case 2 Passed ");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output2));
				System.out.println("Your Output : "+ Arrays.toString(nums2));
			}
			
			

	}

}
