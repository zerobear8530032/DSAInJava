//2161. Partition Array According to Given Pivot
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:
//
//Every element less than pivot appears before every element greater than pivot.
//Every element equal to pivot appears in between the elements less than and greater than pivot.
//The relative order of the elements less than pivot and the elements greater than pivot is maintained.
//More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. If i < j and both elements are smaller (or larger) than pivot, then pi < pj.
//Return nums after the rearrangement.
//
// 
//
//Example 1:
//
//Input: nums = [9,12,5,10,14,3,10], pivot = 10
//Output: [9,5,3,10,10,12,14]
//Explanation: 
//The elements 9, 5, and 3 are less than the pivot so they are on the left side of the array.
//The elements 12 and 14 are greater than the pivot so they are on the right side of the array.
//The relative ordering of the elements less than and greater than pivot is also maintained. [9, 5, 3] and [12, 14] are the respective orderings.
//Example 2:
//
//Input: nums = [-3,4,3,2], pivot = 2
//Output: [-3,2,4,3]
//Explanation: 
//The element -3 is less than the pivot so it is on the left side of the array.
//The elements 4 and 3 are greater than the pivot so they are on the right side of the array.
//The relative ordering of the elements less than and greater than pivot is also maintained. [-3] and [4, 3] are the respective orderings.
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//-106 <= nums[i] <= 106
//pivot equals to an element of nums.
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PartitionArrayAccordingToGivenPivot_2161 {
//	brute force approch :
//	create a list of all elements small then pivote in sequence they occur 
//	create a counter of number of pivote
//	create a list of all element greater then pivpte in sequencee
//	last combine them small+pivotecount+greater 
//	return ans;
//	time complexity :O(n)
//	space complexity :O(n)
	public static int [] pivotArrayBruteForce(int [] nums,int pivot) {
		
		ArrayList<Integer> small = new ArrayList();
		ArrayList<Integer> greater = new ArrayList();
		int p =0;
		for(int x: nums) {
			if(x<pivot) small.add(x);
			if(x>pivot) greater.add(x);
			if (x==pivot) p++;
		}
		
		int [] ans = new int [small.size()+p+greater.size()];
		
		int idx=0;
		for(int x:small) {
			ans[idx]=x;
			idx++;
		}
		for(int i=0;i<p;i++) {
			ans[idx]=pivot;
			idx++;
		}
		for(int x:greater) {
			ans[idx]=x;
			idx++;
		}
		
		return ans;
	}
	
//	Better:
//	here we just iterate over entire array :
//	where we first add all small element in the ans array 
//	then again iterate over entire array and put alla element equal to pivote
//	last again iterate and put all element grater to pivote in array 
//	time complexity :O(n)
//	space complexity :O(1)
	public static int[] pivotArrayBetter(int[] nums, int pivot) {
		int [] ans = new int [nums.length];
		int start=0;
		for(int i =0;i<nums.length;i++) {
			if(nums[i]<pivot) ans[start++]= nums[i];
		}
		for(int i =0;i<nums.length;i++) {
			if(nums[i]==pivot) ans[start++]= nums[i];
		}		
		for(int i =0;i<nums.length;i++) {
			if(nums[i]>pivot) ans[start++]= nums[i];
		}

        return ans;
    }

//	Best :
//	use 2 pointers similar to the better one but here we use 2 pointer which will 
//	work on both sides at once :
//	by using 2 pointers we can put smaller and greater element at both side this is more efficient then previous
//	time complexity :O(n)
//	space complexity :O(1)
	
	public static int[] pivotArrayOptimize(int[] nums, int pivot) {
		int n=nums.length;
		int s=0;
		int e=n-1;
		int ans []= new int [nums.length];
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<pivot) {
				ans[s]=nums[i];
				s++;
			}
		    if(nums[n-1-i] > pivot)
            {
                ans[e] = nums[n-1-i];
                e--;
            }
		}
		while(s<=e) {
			ans[s]=pivot;
			s++;
		}
		return ans;
	}
	

 	public static boolean check(int [] ans,int []output) {
 		if(ans.length!=output.length) {
 			return false;
 		}
 		for(int i=0;i<ans.length;i++) {
 			if(ans[i]!=output[i]) {
 				return false;
 			}
 		}
 		return true;
 		
 	}
 	
 	
	public static void main(String[] args) {
		
		//Example 1:
		
		int [] nums1 = {9,12,5,10,14,3,10};
		int pivot1 = 10;
		int [] output1= {9,5,3,10,10,12,14};

		//Example 2:
		
		int [] nums2 = {-3,4,3,2};
		int  pivot2 = 2;
		int [] output2= {-3,2,4,3};
		
		System.out.println("Brute Force Approch :");
		int [] ans1= pivotArrayBruteForce(nums1, pivot1);
		int [] ans2= pivotArrayBruteForce(nums2, pivot2);
		
		  
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
		ans1= pivotArrayBetter(nums1, pivot1);
		ans2= pivotArrayBetter(nums2, pivot2);
		
		
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
		System.out.println("Optimize Force Approch :");
		ans1= pivotArrayOptimize(nums1, pivot1);
		ans2= pivotArrayOptimize(nums2, pivot2);
		
		
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
