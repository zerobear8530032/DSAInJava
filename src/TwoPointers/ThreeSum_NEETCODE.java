package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum_NEETCODE {
	    
//	brute force approch :
//	here we take every single pair by nested loop
//	and sort the triplet and add it to the hashset to remove duplicates
//	and last give answer as a list
//	time complexity: O(n*n*(n log n +n) 
//	space complexity: space n*3; 
	public static List<List<Integer>> threeSumBruteForce(int[] nums) {
	        HashSet<List<Integer>> triplets = new HashSet();
	        for(int i =0;i<nums.length;i++){
	            for(int j =i+1;j<nums.length;j++){
	                for(int k =j+1;k<nums.length;k++){
	                    int sum = nums[i]+nums[j]+nums[k];
	                    if(sum==0){
	                        List <Integer> temp = new ArrayList(Arrays.asList(nums[i],nums[j],nums[k]));
	                        Collections.sort(temp);
	                        triplets.add(temp);
	                    }
	                }
	            }
	        }
	        List<List<Integer>> ans = new ArrayList<List<Integer>>(triplets);
	        return ans;
	    }
	
//	Better approch :
//	HERE THE  WE CAN OPTIMIZE IT IF THE INITAL ARRAY IS SORTED WE CAN SET 2 POINTER TO 2 INDEX AND REST OF THE
//	LAST NUMBER CAN BE GET AS TARGET-NUMS[X1]+NUMS[X2]= NUMS[X3]
//	WE CAN SEARCH FOR THAT NUMS[X3} USING BINARY SEARCH 
//	time complexity: O(n log n)+O(n*n* log n) 
//	space complexity: space n*3; 
	public static List<List<Integer>> threeSumBetter(int[] nums) {
		HashSet<List<Integer>> triplets = new HashSet();
		Arrays.sort(nums);
		for(int i =0;i<nums.length;i++){
			for(int j =i+1;j<nums.length;j++){
				int target= 0-(nums[i]+nums[j]);
				int k=search(nums, j+1, nums.length-1, target);
				if(k!=-1) {
					List<Integer> temp = new ArrayList(Arrays.asList(nums[i],nums[j],nums[k]));
					triplets.add(temp);
				}
			}
		}
		List<List<Integer>> ans = new ArrayList(triplets);
		return ans;
	}
	
//	Best approch :
//	we can sort the array and then apply a 2 pointer technique to search the target instead of binary search
//	time complexity: O(n log n)+O(n*n*n) 
//	space complexity: space n*3; 
	public static List<List<Integer>> threeSumBest(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList();
		for(int i =0;i<nums.length;i++){
			int k= nums.length-1;
			int j= i+1;
			while(j<k) {
				int sum = nums[i]+nums[j]+nums[k];
				if(sum<0) {
					j++;
				}
				if(j==k) {
					break;
				}
				sum = nums[i]+nums[j]+nums[k];
				if(sum>0) {
					k--;
				}
				
				if(j==k) {
					break;
				}
				sum = nums[i]+nums[j]+nums[k];
				if(sum==0) {
					List<Integer> temp = new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k]));
					ans.add(temp);
					break;
				}
			}
		
		}
		return ans;
	}
	public static int search(int [] nums, int start ,int end, int target) {
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(target<nums[mid]) {
				end=mid-1;
			}else if (target>nums[mid]){
				start=mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}

	
	public static void main(String[] args) {
		
		int []nums1 = {-1,0,1,2,-1,-4};
		List<List<Integer>> output1 = new ArrayList<>(Arrays.asList(Arrays.asList(-1, -1, 2),Arrays.asList(-1, 0, 1)));
		int []nums2 = {0,1,1};
		List<List<Integer>> output2 = new ArrayList<>();
		
		System.out.println(threeSumBest(nums1));

		
						
	}

}
