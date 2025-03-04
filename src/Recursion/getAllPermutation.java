//31. Next Permutation
//Medium
//Topics
//Companies
//A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
//
//For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
//The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
//
//For example, the next permutation of arr = [1,2,3] is [1,3,2].
//Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
//While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
//Given an array of integers nums, find the next permutation of nums.
//
//The replacement must be in place and use only constant extra memory.
//

//Example 1:
//
//Input: nums = [1,2,3]
//Output: [1,3,2]
//Example 2:
//
//Input: nums = [3,2,1]
//Output: [1,2,3]
//Example 3:
//
//Input: nums = [1,1,5]
//Output: [1,5,1]
package Recursion;

import java.util.ArrayList;
import java.util.List;

public class getAllPermutation {
	
	
	public static void  getAllPermutation(int [] arr, int index,List<List<Integer>> ans){
		if(index==arr.length) {
			List<Integer> ds= new ArrayList();
			for (int i =0;i<arr.length;i++) {
				ds.add(arr[i]);
			}
			ans.add(ds);
			return ;
		}
		for(int i =index;i<arr.length;i++) {
			swap(index,i,arr);
			getAllPermutation(arr, index+1, ans);
			swap(index,i,arr);
		}
		
		
	}
	
	public static void swap(int idx1,int idx2,int [] arr) {
		int temp= arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=temp;
	}
	
	

	
	public static void main(String[] args) {
		
		
		//Example 1:
		
		int []nums1 = {1,2,3};
		
		//Example 2:

		int []nums2 = {3,2,1};

		//Example 3:
		
		int [] nums3 = {1,1,5};
		
		List<List<Integer>> ans = new ArrayList();
		getAllPermutation(nums1, 0, ans);
		System.out.println(ans);
		ans = new ArrayList();
		getAllPermutation(nums2, 0, ans);
		System.out.println(ans);
		ans = new ArrayList();
		getAllPermutation(nums3, 0, ans);
		System.out.println(ans);
		
		
	}
}
